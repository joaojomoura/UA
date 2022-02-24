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

# Dominios de pesquisa
# Permitem calcular
# as accoes possiveis em cada estado, etc

# module from practical classes and modified by us

from copy import deepcopy

from utils import State, Action


def get_rotations(node):
    shape = node.state.current_piece.positions
    xs = set([x for x, y in shape])
    ys = set([y for x, y in shape])

    if len(set(ys)) == len(set(xs)):  # shape == "O":
        node.rotation = [""]
        return [""]
    # shape in ("L", "J", "T"):
    elif len(set(ys)) == 3 and len([x1 for x1, y1 in shape if x1 == list(xs)[0]]) != 2 or \
            len(set(xs)) == 3 and len([y1 for x1, y1 in shape if y1 == list(ys)[0]]) != 2:
        node.rotation = ["", "w", "ww", "www"]
        return ["", "w", "ww", "www"]
    else:  # shape in ("S", "Z", "I"):
        node.rotation = ["", "w"]
        return ["", "w"]


def get_drops(node):
    piece = node.state.current_piece.positions

    xs = set([x for x, y in piece])
    x_min = min(xs)
    x_max = max(xs)

    moves = [""]
    for i in range(1, x_min):
        moves += ["a" * i]

    for i in range(x_max, 9):
        moves += ["d" * (i - x_max + 1)]

    node.direction = moves
    return moves


class SearchDomain:

    # construtor
    def __init__(self, modifiers: list[float] = ()):
        self.modifiers = modifiers

    # lista de accoes possiveis num estado
    def actions(self, node) -> list[str]:
        if node.rotation == []:
            rotations = get_rotations(node)
            # print("rotations:", node.state.current_piece.positions)
            return rotations
        if node.direction == []:
            drops = get_drops(node)
            # print("drops:", node.state.current_piece.positions)
            return drops
        if node.stage == 6:
            return ["n"]

        # print("heuristics:", node.state.current_piece.positions)
        return ["h"]

    # resultado de uma accao num estado, ou seja, o estado seguinte
    def result(self, node, action):
        if len(action) == 0:
            return SearchNode(deepcopy(node.state), node, node.cost)

        if action == "n":
            new = SearchNode(deepcopy(node.state), node, node.cost)
            new.rotation = []
            new.direction = []
            new.stage = 0

            new.state.current_piece = deepcopy(new.state.lookahead.pop(0))

            new.actions = action
            return new
        if action == "h":
            # print("pre processed:", node.state.current_piece.positions)
            new = SearchNode(deepcopy(node.state), node, node.cost)
            new.cost = 1000 + new.process_cost(self.modifiers)
            new.has_heuristic = True
            print(f"Heuristic for {node.get_path()}: {new.cost}")

            new.actions = action
            return new

        if action[0] == "w":
            new_state: State = deepcopy(node.state)

            for rotation in action[0]:
                new_state = new_state.get_action_result(Action.Rotate)

            new = SearchNode(new_state, node, node.cost)
            new.rotation = action

            l = len(set([x for x, y in new.state.current_piece.positions]))
            ys = [y for x, y in new.state.current_piece.positions]
            diff = max(ys) - min(ys)

            new.cost = - 0.5 * l - 0.3 * diff
            new.actions = action
            return new

        new = SearchNode(deepcopy(node.state), node, node.cost)

        if action[0] == "d":
            new.state = new.state.drop_piece(len(action))
            new.actions = action

            self.placement_heuristic(action, new)
            return new

        if action[0] == "a":
            xs = set([x for x, y in new.state.current_piece.positions])
            x_min = min(xs)
            #
            # prevx = [x for x, y in node.state.current_piece.positions]
            new.state = new.state.drop_piece(-(x_min - len(action)))
            # nextx = [x for x, y in new.state.current_piece.positions]

            # for x in range(len(prevx)):
            #     if nextx[x] >= 10:
            #         print(f"a: {prevx[x]} -> {nextx[x]}")
            self.placement_heuristic(action, new)
            new.actions = action
            # new.cost = 1000 + new.process_cost(self.modifiers)
            return new

    def placement_heuristic(self, action, new_node):
        y_max = max([y for x, y in new_node.state.current_piece.positions])
        xs = list(set([y for x, y in new_node.state.current_piece.positions]))
        xs.sort()
        print(xs)
        res = []
        for x in xs:
            res += [30]
            for y in range(30):
                if new_node.state.game[y][x] == 1:
                    res[-1] = 30 - y
                    break
        print("res", res, xs)
        game_max = max(xs)
        game = [game_max - y for y in res]
        piece = list(set([y_max - y for x, y in new_node.state.current_piece.positions]))
        print("lens", action, len(game), len(piece))
        diff = []
        for i in range(len(piece)):
            diff += [piece[i] - game[i]]
        new_node.cost = 1000 - abs(sum(diff))


# Problemas concretos a resolver
# dentro de um determinado dominio
class SearchProblem:
    def __init__(self, domain, initial):
        self.domain = domain
        self.initial = initial

    def goal_test(self, state):
        return self.domain.satisfies(state)


# Nos de uma arvore de pesquisa
class SearchNode:
    def __init__(self, state: State, parent, cost=0):
        self.has_heuristic = False
        self.state = state
        self.parent: SearchNode = parent
        self.actions = ''
        self.cost = cost + parent.cost if parent is not None else cost
        self.rotation = deepcopy(parent.rotation) if parent is not None else []
        self.direction = deepcopy(parent.direction) if parent is not None else []
        self.stage = parent.stage if parent is not None else 0

        # self.state.stage = self.stage

    def __repr__(self):
        return str(self)

    def is_final(self):
        return self.rotation != [] and \
               self.direction != [] and \
               self.has_heuristic

    def process_cost(self, modifiers: list[float]):
        if self.direction == [] or self.rotation == []:
            return self.cost
        return self.parent.cost + self.state.fast_heuristic(offender="process_cost")
        # res = 0
        #
        # self.stage += 1
        # if self.stage == 1:
        #     h_cleared_lines, self.state.h_column_height, self.state.h_game = self.state.h_cleared_lines()
        #     self.cost += modifiers[0] * h_cleared_lines
        #     res = modifiers[0] * h_cleared_lines
        # elif self.stage == 2:
        #     h_number_of_pits = self.state.h_number_of_pits(self.state.h_column_height)
        #     self.cost += modifiers[1] * h_number_of_pits
        #     res = modifiers[1] * h_number_of_pits
        # elif self.stage == 3:
        #     h_total_height = self.state.h_total_height(self.state.h_column_height)
        #     self.cost += modifiers[2] * h_total_height
        #     res = modifiers[2] * h_total_height
        # elif self.stage == 4:
        #     h_max_well, h_total_height_discrepancy = self.state.h_total_height_discrepancy_max_well(
        #         self.state.h_column_height)
        #     self.cost += modifiers[3] * h_max_well + modifiers[4] * h_total_height_discrepancy
        #     res = modifiers[3] * h_max_well + modifiers[4] * h_total_height_discrepancy
        # elif self.stage == 5:
        #     self.state.h_columns_holes, h_total_hole_count = self.state.h_total_hole_count(self.state.h_column_height,
        #                                                                                    self.state.h_game)
        #     self.cost += modifiers[5] * h_total_hole_count
        #     res = modifiers[5] * h_total_hole_count
        # elif self.stage == 6:
        #     # h_n_cols_with_holes = np.count_nonzero(np.array(self.state.h_columns_holes) > 0)
        #     h_n_cols_with_holes = len([ch for ch in self.state.h_columns_holes if ch > 0])
        #     self.cost += modifiers[6] * h_n_cols_with_holes
        #     res = modifiers[6] * h_n_cols_with_holes
        # else:
        #     return 0
        #
        # print(self.get_path())
        # return res

    def __str__(self):
        return "no(" + str(self.state) + "," + str(self.parent) + ")"

    def get_path(self):
        if self.parent is None:
            # return [node.state]
            return [self.actions]
        path = self.parent.get_path()
        # path += [node.state]
        path += [self.actions]
        return path


# Arvores de pesquisa
class SearchTree:

    # construtor
    def __init__(self, problem):
        self.problem = problem
        root = problem.initial
        self.open_nodes = [root]
        self.solution = None

    def get_plan(self, node: SearchNode):
        if node.parent is None:
            return [node.actions] if node.actions not in ('n', 'h', '') else []

        plan = self.get_plan(node.parent)
        if node.actions not in ('n', 'h', ''):
            plan += node.actions  # [0].split('')

        return plan

    # obter o caminho (sequencia de estados) da raiz ate um no
    def get_path(self, node):
        if node.parent is None:
            # return [node.state]
            return [node]
        path = self.get_path(node.parent)
        # path += [node.state]
        path += [node]
        return path

    # procurar a solucao
    def search(self, limit=-1):
        while self.open_nodes != []:
            node = self.open_nodes.pop(0)
            print(self.get_plan(node), node.cost)

            if node.is_final():  # self.problem.goal_test(node.state):
                print("Is a final node!")
                self.solution = node
                return self.get_plan(node)

            lnewnodes = []

            if not (0 < limit < len(self.get_path(node))):
                # when heuristics need to be calculated there are no actions
                actions = self.problem.domain.actions(node)
                print(f"//===ACTIONS {len(actions)}")
                for a in actions:
                    # new_state = self.problem.domain.result(node.state, a)
                    # new_node = SearchNode(new_state, node)
                    # new_node.cost = node.cost + self.problem.domain.cost(node, a)
                    new_node = self.problem.domain.result(node, a)
                    path = self.get_path(new_node)
                    if new_node.state not in path[:-1]:
                        lnewnodes.append(new_node)
                print("\\\\==========")

                print("New nodes: ", [str(c.cost)[:5] for c in lnewnodes])
                self.add_to_open(lnewnodes)

        return None

    # juntar novos nos a lista de nos abertos de acordo com a estrategia
    def add_to_open(self, lnewnodes):
        self.open_nodes.extend(lnewnodes)
        self.open_nodes.sort(key=lambda n: n.cost)
        print("Open nodes: ", [str(c.cost)[:5] for c in self.open_nodes])
