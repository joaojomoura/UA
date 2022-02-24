#encoding: utf8
# Joao Moura 43889
from semantic_network import *
from bayes_net import *

from itertools import product

class MySemNet(SemanticNetwork):
    def __init__(self):
        SemanticNetwork.__init__(self)
        # IMPLEMENT HERE (if needed)
        pass

    def source_confidence(self,user):
        relations_list = list(set([(d.relation.name,d.relation.entity1,d.relation.entity2) for d in self.declarations if d.user == user and isinstance(d.relation,AssocOne)]))
        counter1 = 0
        counter2 = 0
        for (r,e1,e2) in relations_list:
            dic = {}
            for d in self.declarations:
                if d.relation.entity1 == e1 and d.relation.name == r: 
                    if isinstance(d.relation,AssocOne):
                        if d.relation.entity2 in dic:
                            dic[d.relation.entity2] += 1
                        else:
                            dic[d.relation.entity2] = 1
            if(dic[e2] >= max(dic.values())):
                counter1 += 1
            else:
                counter2 += 1
        return (1 - (0.75 ** counter1)) * (0.75 ** counter2)


    def query_with_confidence(self,entity,assoc):
        # IMPLEMENT HERE
        newdic = {}
        for d in self.number_occur_foreach_alter(entity,assoc):
            newdic[d] = self.confidence(self.number_occur_foreach_alter(entity,assoc)[d], self.number_of_declar(entity,assoc))
        return newdic
    def number_occur_foreach_alter (self,entity,assoc):
        dic_second_argument = {}
        l = self.query(entity,assoc)
        for d in l:
            entity = d.relation.entity1
            if d.relation.entity1 == entity and d.relation.name == assoc:
                if isinstance(d.relation,AssocOne):
                    if d.relation.entity2 in dic_second_argument:
                        dic_second_argument[d.relation.entity2] += 1
                    else:
                        dic_second_argument[d.relation.entity2] = 1
        return dic_second_argument
    def query(self, e, assoc=None):
        parents = [d.relation.entity2 for d in self.query_local(e1=e) if not isinstance(d.relation, AssocOne)]        
        ldecl = [d for d in self.query_local(e1=e, relname=assoc) if isinstance(d.relation, AssocOne)]
        for p in parents:
            ldecl+=self.query(p, assoc)
        return ldecl
    
    def number_of_declar (self,entity,assoc):
        l = self.query(entity,assoc)
        counter = 0
        for d in l:
            entity = d.relation.entity1
            if d.relation.entity1 == entity and d.relation.name == assoc:
                if isinstance(d.relation,AssocOne):
                    counter += 1
        return counter

    def confidence(self,n,t):
        return (n/(2*t)) + (1 - (n/(2*t)))*(1 - (0.95 ** n))*(0.95 ** (t-n))



class MyBN(BayesNet):

    def __init__(self):
        BayesNet.__init__(self)
        # IMPLEMENT HERE (if needed)
        pass

    def individual_probabilities(self):
        dic_prob = {}
        for k in self.dependencies.keys():
            dic_prob[k] = (self.individualProb(k))
        return dic_prob

    #Funcoes auxiliares
    def individualProb(self,var):
        prob = 0.0
        ancestors = self.conjunction(self.ancestors(var))
        for conj in ancestors:
            prob += self.jointProb(conj + [(var, True)])
        return prob

    def conjunction(self, ancestor_variables):
        list_conj = product([True,False], repeat=len(ancestor_variables))
        return list(map(lambda c : list(zip(ancestor_variables, c)),list_conj))

    def ancestors(self, var):
        ancestor_variables = [ v for (v,x) in list(self.dependencies[var].items())[0][0] ]
        list_ancestors = ancestor_variables

        for v in ancestor_variables:
            list_ancestors += self.ancestors(v)

        return list(set(list_ancestors)) 

