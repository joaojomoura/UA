# Joao Moura 43889
# Discuti ideias com Ruben Castelhano 97688

from tree_search import *
from cidades import *

class MyNode(SearchNode):
    def __init__(self,state,parent,heuristic=0,cost = 0,arg5=None):
        super().__init__(state,parent)
        self.heuristic = heuristic
        self.cost = cost

class MyTree(SearchTree):

    def __init__(self,problem, strategy='breadth',seed=0): 
        super().__init__(problem,strategy,seed)
        root = MyNode(self.problem.initial,None,self.problem.domain.heuristic(self.problem.initial,self.problem.goal))
        self.all_nodes = [root]
        

    def astar_add_to_open(self,lnewnodes):
        self.open_nodes = sorted(self.open_nodes + lnewnodes, key=lambda i: self.all_nodes[i].cost + self.all_nodes[i].heuristic)

    def propagate_eval_upwards(self,node):
        #IMPLEMENT HERE
        pass
    
    
    def search2(self,atmostonce=False):
        
        while self.open_nodes != []:
            nodeID = self.open_nodes.pop(0)
            node = self.all_nodes[nodeID]
            if self.problem.goal_test(node.state):
                self.solution = node
                self.terminals = len(self.open_nodes)+1
                
                return self.get_path(node)
            lnewnodes = []
            self.non_terminals += 1
            for a in self.problem.domain.actions(node.state):
                newstate = self.problem.domain.result(node.state,a)
                if newstate not in self.get_path(node):
                    newnode = MyNode(newstate,nodeID,self.problem.domain.heuristic(newstate, self.problem.goal),(node.cost + self.problem.domain.cost(node.state,a)))
                    self.all_nodes.append(newnode)
                    lnewnodes.append(len(self.all_nodes) - 1)
                    
            self.add_to_open(lnewnodes)

    def repeated_random_depth(self,numattempts=3,atmostonce=False):
        tmp = 5000
        
        for i in range(numattempts):
            solution_tree = MyTree(self.problem, 'rand_depth',i)
            solution_tree.search2()
            
            if(tmp > solution_tree.solution.cost):
                tmp = solution_tree.solution.cost
                self.solution_tree = solution_tree

        return self.solution_tree.get_path(self.solution_tree.solution)

        



    def make_shortcuts(self):
        pass


class MyCities(Cidades):

    def maximum_tree_size(self,depth):   # assuming there is no loop prevention
        name_Of_Cities = []
        temp = set()
        for inner in self.connections:
            for elem in inner:
                if not elem  in temp:
                    if isinstance(elem,str):
                        temp.add(elem)
                        name_Of_Cities.append(elem)

        sum_c = 0
        for i in name_Of_Cities:
            sum_c += len(self.actions(i))

        average_Branch = sum_c / len(name_Of_Cities)
        

        return (sum([average_Branch ** i for i in range(depth+1)]))
            


