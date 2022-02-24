# Module Developed by:
# Joao Moura, 43889
# Ruben Castelhano, 97688
# Joao Felisberto, 98003


from utils import Action, State
import math


class TetrisNode:
    def __init__(self, state: State, parent, cost=0, heuristic=0) -> None:
        self.state: State = state
        self.parent: TetrisNode = parent
        self.heuristic: int = heuristic
        self.cost: int = cost


class AStar:
    def __init__(self, start: State, goal: State):
        self.open = [TetrisNode(start, None)]
        self.goal: State = goal
        self.solution = None

    def search(self):
        cnt = 0
        while self.open != []:
            node = self.open.pop(0)

            if self.is_goal(node):
                self.solution = node
                return self.get_action_path(node)

            if cnt > 50:
                return None

            new_nodes = []
            for act in self.get_actions(node.state):
                cnt += 1
                new_state = self.get_action_result(node.state, act)

                if new_state not in self.get_path(node):
                    new_nodes.append(TetrisNode(new_state, node, node.cost + 1, self.heuristic(new_state)))

            self.open.extend(new_nodes)
            self.open.sort(key=lambda n: n.cost + n.heuristic)
        return None

    def is_goal(self, node: TetrisNode):
        return node.state.current_piece.positions == self.goal.current_piece.positions

    def get_path(self, node: TetrisNode):
        if node.parent == None:
            return [node.state]
        path = self.get_path(node.parent)
        path += [node.state]
        return (path)

    def get_action_path(self, node: TetrisNode):
        if node.parent == None:
            return []
        path = self.get_action_path(node.parent)
        path += [node.state.action]
        return (path)

    def get_actions(self, state: State):
        # print("-------------------------")
        # print(f"State")
        # state.print_console()
        # print(f"Valid actions: {state.get_valid_actions()}")
        # print("-------------------------")
        return state.get_valid_actions()

    def get_action_result(self, state: State, act: Action):
        # print(f"State:")
        # state.print_console()
        # print(f"Action: {act}")
        # print("Result:")
        # state.get_action_result(act).print_console()
        # print("-------------------------")
        return state.get_action_result(act)

    def cost(self, action: Action):
        if action == Action.Nothing:
            return 4
        if action == Action.Down:
            return 1
        if action == Action.Left:
            return 2
        if action == Action.Right:
            return 2
        if action == Action.Rotate:
            return 2

    def heuristic(self, state: State):
        goal_coords = (self.goal.current_piece.x, self.goal.current_piece.y)
        state_coords = (state.current_piece.x, state.current_piece.y)
        return math.sqrt(((goal_coords[0] - state_coords[0]) * (goal_coords[0] - state_coords[0])) + (
                    (goal_coords[1] - state_coords[1]) * (goal_coords[1] - state_coords[1])))


class F_Search():
    def __init__(self) -> None:
        pass

    @staticmethod
    def get_path(current: State, target: State):
        action_list = []

        rotation_offset = target.current_piece.rotation - current.current_piece.rotation
        # print(f"Current rotation {current.current_piece.rotation}")
        # print(f"Target rotation {target.current_piece.rotation}")
        if rotation_offset >= 0:
            for i in range(rotation_offset):
                action_list.append(Action.Rotate)
        else:
            for i in range(len(current.current_piece.plan) - current.current_piece.rotation):
                action_list.append(Action.Rotate)

        lateral_offset = target.current_piece.x - current.current_piece.x
        if lateral_offset >= 0:
            for i in range(lateral_offset):
                action_list.append(Action.Right)
        else:
            for i in range(abs(lateral_offset)):
                action_list.append(Action.Left)

        action_list.append(Action.Down)
        # print(action_list)

        return action_list
