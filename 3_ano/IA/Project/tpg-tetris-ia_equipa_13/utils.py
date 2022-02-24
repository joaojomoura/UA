# Module Developed by:
# Joao Moura, 43889
# Ruben Castelhano, 97688
# Joao Felisberto, 98003

import shape

from shape import Shape
from copy import deepcopy

x = 10
y = 30

shape_dict = {"S": shape.S, "Z": shape.Z, "I": shape.I, "O": shape.O, "J": shape.J, "T": shape.T, "L": shape.L}
Dummy = [
    [".....", ".....", ".....", ".....", "....."]
]

shapes = {"S": None, "Z": None, "I": None, "O": None, "J": None, "T": None, "L": None}
next_shapes = {"S": None, "Z": None, "I": None, "O": None, "J": None, "T": None, "L": None}
for key, value in shape_dict.items():
    shape = Shape(value)
    shape.set_pos((x - 5) / 2, 1)
    shapes[key] = shape

for key, value in shape_dict.items():
    shape = Shape(value)
    next_shapes[key] = shape


class Action:
    Rotate = 'w'
    Left = 'a'
    Down = 's'
    Right = 'd'
    Nothing = ''


class ShapeHelper:
    @staticmethod
    def get_shape(positions: list):
        for key, value in shapes.items():
            found = True
            for i, v in enumerate(positions):
                if v[0] != value.positions[i][0] or v[1] != value.positions[i][1]:
                    found = False
                    break
            if found:
                print(f"Piece: {key}")
                shape = Shape(shape_dict[key])
                shape.set_pos((x - 5) / 2, 0)
                return shape
        print("Piece not found")
        return None

    @staticmethod
    def get_next_shape(positions: list):
        for key, value in next_shapes.items():
            found = True
            for i, v in enumerate(positions):
                if v[0] != value.positions[i][0] or v[1] != value.positions[i][1]:
                    found = False
                    break
            if found:
                print(f"Next Piece: {key}")
                shape = Shape(shape_dict[key])
                return shape
        print("Piece not found")
        return None

    @staticmethod
    def dummy_shape():
        return Shape(Dummy)


clean_game = [[1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]]

clean_row = [1, 0, 0, 0, 0, 0, 0, 0, 0, 1]


# game properties

class State:
    def __init__(self, game: list, current_piece: Shape, action: Action = None, parent=None) -> None:
        self.game = game
        self.current_piece = deepcopy(current_piece)
        self.parent = parent
        self.action = action

    def merge_game_with_shape(self):
        cpy = deepcopy(self.game)
        for x, y in self.current_piece.positions:
            cpy[y][x] = 1

        return cpy

    def _is_valid(self, piece: Shape):
        for x, y in piece.positions:
            if self.game[y][x] == 1:
                return False
        return True

    def _collide_left_lateral(self, piece: Shape, x1=0):
        for x, y in piece.positions:
            if x <= x1:
                return True
        return False

    def _collide_right_lateral(self, piece: Shape, x2=8):
        for x, y in piece.positions:
            if x > x2:
                return True
        return False

    def _collide_bottom(self, piece: Shape):
        for x, y in piece.positions:
            if y > 29:
                return True
        return False

    def __is_action_possible(self, action: Action):
        cpy = deepcopy(self.current_piece)
        # if self.action == Action.Down:
        #     return False
        cpy.y += 1
        if not self._is_valid(cpy):
            return False

        if action == Action.Nothing:
            return self._is_valid(cpy)
        if action == Action.Down:
            return self._is_valid(cpy)
        if action == Action.Left:
            cpy.translate(-1, 0)
            return self._is_valid(cpy)
        if action == Action.Right:
            cpy.translate(1, 0)
            return self._is_valid(cpy)
        if action == Action.Rotate:
            cpy.rotate()
            return self._is_valid(cpy)
        return False

    def get_valid_actions(self):
        actions = []
        if self.__is_action_possible(Action.Nothing):
            actions.append(Action.Nothing)
        if self.__is_action_possible(Action.Down):
            actions.append(Action.Down)
        if self.__is_action_possible(Action.Left):
            actions.append(Action.Left)
        if self.__is_action_possible(Action.Right):
            actions.append(Action.Right)
        if self.__is_action_possible(Action.Rotate):
            actions.append(Action.Rotate)
        return actions

    def get_action_result(self, action: Action):
        cpy = deepcopy(self.current_piece)
        cpy.y += 1
        if action is Action.Down:
            while self._is_valid(cpy):
                cpy.y += 1
            cpy.y -= 1
        elif action is Action.Left:
            cpy.translate(-1, 0)
        elif action is Action.Right:
            cpy.translate(1, 0)
        elif action is Action.Rotate:
            cpy.rotate()
        return State(self.game, cpy, action, self.parent)

    def get_all_possible_positions_fast(self, x1=0, x2=8):
        '''
        Simpler way of detecting positions for the current piece.
        Go down from left to right on each rotation until you hit the bottom or other pieces.
        No complex positions here, but all of them are reachable.
        '''
        cpy = deepcopy(self.current_piece)
        rots = len(cpy.plan)
        possible_states = []
        y = cpy.y
        for i in range(rots):
            cpy.y = y
            if i > 0:
                cpy.rotate()

            cpy.translate(-1, 0)
            while not self._collide_left_lateral(cpy, x1):
                cpy.translate(-1, 0)
            cpy.translate(1, 0)

            while not self._collide_right_lateral(cpy, x2):
                cpy.y = y
                while self._is_valid(cpy):
                    cpy.y += 1
                cpy.y -= 1
                possible_states.append(State(self.game, cpy, parent=self.parent))
                cpy.translate(1, 0)

        return possible_states

    def drop_piece(self, col: int):
        '''
        Col must be between 1 and 8
        '''
        new = deepcopy(self)

        act = Action.Left if col < 0 else Action.Right

        for i in range(abs(col)):
            new = new.get_action_result(act)

        return new

    def print(self):
        cpy = deepcopy(self.game)
        for x, y in self.current_piece.positions:
            cpy[y][x] = 1
        for y in range(31):
            print(cpy[y])

    def wait(self):
        cpy = deepcopy(self.current_piece)
        cpy.y += 1
        return State(self.game, cpy)

    def fast_heuristic(self):
        game = self.merge_game_with_shape()

        row_c = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        cleared_lines = 0
        for y in range(29, -1, -1):
            for x in range(1, 9):
                if game[y][x] == 1:
                    row_c[y] += 1
            if row_c[y] == 8:
                cleared_lines += 1
            elif row_c[y] == 0:
                break

        if cleared_lines > 0:
            for y in range(29, -1, -1):
                if row_c[y] == 8:
                    for i in range(y, -1, -1):
                        if row_c[i - 1] == 0:
                            game[i] = clean_row[:]
                            break
                        else:
                            game[i] = game[i - 1]
                elif row_c[y] == 0:
                    break

        column_height = [0, 0, 0, 0, 0, 0, 0, 0]
        for x in range(1, 9):
            for y in range(30):
                if game[y][x] == 1:
                    column_height[x - 1] = 30 - y
                    break

        total_height = sum(column_height)

        total_height_discrepancy = 0
        for x in range(0, 7):
            total_height_discrepancy += abs(column_height[x] - column_height[x + 1])

        total_hole_count = 0
        for x in range(1, 9):
            hit = False
            for y in range(30 - column_height[x - 1], 30):
                inside = game[y][x] == 1
                if not hit:
                    if inside:
                        hit = True
                elif not inside:
                    total_hole_count += 1

        return (cleared_lines * 1) + (total_height * -0.65) + (total_height_discrepancy * -0.4) + (
                total_hole_count * -0.25)
