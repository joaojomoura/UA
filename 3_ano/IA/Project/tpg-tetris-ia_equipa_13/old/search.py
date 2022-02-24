
# Module: tree_search
# 
# This module provides a set o classes for automated
# problem solving through tree search:
#    SearchDomain  - problem domains
#    SearchProblem - concrete problems to be solved
#    SearchNode    - search tree nodes
#    SearchTree    - search tree with the necessary methods for searhing
#
#  (c) Luis Seabra Lopes
#  Introducao a Inteligencia Artificial, 2012-2019,
#  Inteligência Artificial, 2014-2019

# module from practical classes and modified by us

from abc import ABC, abstractmethod
from utils import State
from utils import Action
import math

# Dominios de pesquisa
# Permitem calcular
# as accoes possiveis em cada estado, etc
class SearchDomain(ABC):

    # construtor
    @abstractmethod
    def __init__(self):
        pass

    # lista de accoes possiveis num estado
    @abstractmethod
    def actions(self, state):
        pass

    # resultado de uma accao num estado, ou seja, o estado seguinte
    @abstractmethod
    def result(self, state, action):
        pass

    # custo de uma accao num estado
    @abstractmethod
    def cost(self, state, action):
        pass

    # custo estimado de chegar de um estado a outro
    @abstractmethod
    def heuristic(self, state, goal):
        pass

    # test if the given "goal" is satisfied in "state"
    @abstractmethod
    def satisfies(self, state, goal):
        pass


# Problemas concretos a resolver
# dentro de um determinado dominio
class SearchProblem:
    def __init__(self, domain, initial, goal):
        self.domain = domain
        self.initial = initial
        self.goal = goal
    def goal_test(self, state):
        return self.domain.satisfies(state,self.goal)

# Nos de uma arvore de pesquisa
class SearchNode:
    def __init__(self, state, parent, cost=0, heuristic=0): 
        self.state = state
        self.parent = parent
        self.heuristic = heuristic
        if parent != None:
            self.depth = self.parent.depth + 1
            self.cost = self.parent.total_cost + cost
        else:
            self.depth = 0
            self.cost = 0
    
    def __eq__(self, o: object) -> bool:
        if o is None:
            return False
        return self.state.current_piece.positions == o.state.current_piece.positions

    def __ne__(self, other):
        return not self.__eq__(other)

    def __str__(self):
        return "no(" + str(self.state) + "," + str(self.parent) + ")"
    def __repr__(self):
        return str(self)

# Arvores de pesquisa
class SearchTree:

    # construtor
    def __init__(self,problem, strategy='breadth'): 
        self.problem = problem
        root = SearchNode(problem.initial, None)
        self.open_nodes = [root]
        self.strategy = strategy
        self.solution = None
        self.terminals = 0
        self.non_terminals = 0
        self.avg_branching = 0.0
        self.cost = 0

    # obter o caminho (sequencia de estados) da raiz ate um no
    def get_path(self,node):
        if node.parent == None:
            return [node.state]
        path = self.get_path(node.parent)
        path += [node.state]
        return(path)

    @property
    def length(self):
        return len(self.get_path(self.solution)) -1
        #return self.solution.depth

    # procurar a solucao
    def search(self, limit=None):
        while self.open_nodes != []:
            node = self.open_nodes.pop(0)
            if self.problem.goal_test(node.state):
                self.solution = node
                self.terminals = len(self.open_nodes)+1
                self.cost = self.solution.cost
                self.avg_branching = round((self.terminals +self.non_terminals-1)/self.non_terminals, 2)
                return self.get_path(node)
            lnewnodes = []
            self.non_terminals += 1
            for a in self.problem.domain.actions(node):
                newstate = self.problem.domain.result(node.state,a)
                if newstate not in self.get_path(node):
                    newnode = SearchNode(newstate, node, self.problem.domain.total_cost(node.state, a), self.problem.domain.total_cost(newstate, self.problem.goal))
                    if limit != None and newnode.depth > limit:
                        continue
                    lnewnodes.append(newnode)
            self.add_to_open(lnewnodes)
        return None

    # juntar novos nos a lista de nos abertos de acordo com a estrategia
    def add_to_open(self,lnewnodes):
        if self.strategy == 'breadth':
            self.open_nodes.extend(lnewnodes)
        elif self.strategy == 'depth':
            self.open_nodes[:0] = lnewnodes
        elif self.strategy == 'uniform':
            self.open_nodes.extend(lnewnodes)
            self.open_nodes.sort(key=lambda x:x.total_cost)
        elif self.strategy == 'greedy':
            self.open_nodes.extend(lnewnodes)
            self.open_nodes.sort(key=lambda x:x.total_cost)
        elif self.strategy == 'a*':
            self.open_nodes.extend(lnewnodes)
            self.open_nodes.sort(key=lambda x: x.total_cost + x.total_cost)

class TetrisPath(SearchDomain):
    def __init__(self):
        pass

    def actions(self, state: State):
        return state.get_valid_actions()

    def result(self, state:State, action:Action):
        return state.get_action_result(action)

    def cost(self, state:State, action:Action):
        return 1

    def heuristic(self, state:State, goal:State):
        goal_coords = (goal.current_piece.x, goal.current_piece.y)
        state_coords = (state.current_piece.x, state.current_piece.y)
        return math.sqrt(((goal_coords[0]-state_coords[0])*(goal_coords[0]-state_coords[0])) + ((goal_coords[1]-state_coords[1])*(goal_coords[1]-state_coords[1])))

    def satisfies(self, state:State, goal:State):
        return state.current_piece.positions == goal.current_piece.positions