# Module Developed by:
# Joao Moura, 43889
# Ruben Castelhano, 97688
# Joao Felisberto, 98003


from utils import Action, ShapeHelper
from utils import State
import sys
import search
from fast_search import AStar

# shape = ShapeHelper.get_shape([[2, 2], [3, 2], [4, 2], [5, 2]])
# shape = ShapeHelper.get_shape([[5, 29], [6, 29], [7, 29], [8, 29]])
# state = State([[7, 27], [7, 28], [8, 28], [8, 29]], shape)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Nothing)
# state = state.get_action_result(Action.Right)
# state = state.get_action_result(Action.Nothing)
# print(state.print_info())
# state = state.get_action_result(Action.Right)
# print(state.print_console())
sys.stdout = open('debug.txt', 'w')

# positions = state.get_all_possible_positions()
# positions.sort(key=lambda x: x.completes_lines()*10 + x.max_height()*0.4 - (x.hole_factor()*10))
# best_pos = positions[len(positions)-1]
# print("Best pos")
# best_pos.print_console()

# t = search.SearchTree(search.SearchProblem(search.TetrisPath(), state, best_pos), "greedy")
# search_result = t.search(limit=30)
# for action in search_result:
#     if action.action is not None:
#         print(action.action)

shape = ShapeHelper.get_shape([[4, 2], [3, 3], [4, 3], [3, 4]])
state = State([], shape)

positions = state.get_all_possible_positions_fast()
positions.sort(key=lambda x: x.total_cost(1, -0.5, -0.5, -0.3))
best_pos : State = positions[-1]
print("Best pos")
best_pos.print_console()  

# state.print_console()
# state = state.get_action_result(Action.Right)
# state.print_console()
# state = state.get_action_result(Action.Right)
# state.print_console()
# state = state.get_action_result(Action.Right)
# state.print_console()
# state = state.get_action_result(Action.Down)
# state.print_console()

# resulting_state = State([(6, 28), (7, 28), (7, 29), (8, 29)], Sha)
# print(satisfies(state, resulting_state))
astar = AStar(state, best_pos)
search_result = astar.search()
for action in search_result:
    if action.action is not None:
        print(action.action)

print("---------------------------------------")
t = search.SearchTree(search.SearchProblem(search.TetrisPath(), state, best_pos), "a*")
search_result = t.search(limit=30)
for action in search_result:
    if action.action is not None:
        print(action.action)
