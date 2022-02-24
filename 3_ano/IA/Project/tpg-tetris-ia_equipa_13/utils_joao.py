# Module Developed by:
# Joao Moura, 43889
# Ruben Castelhano, 97688
# Joao Felisberto, 98003

# some portions based on game.py

from shape import Shape
import shape
from copy import deepcopy
from collections import Counter

shape_dict = {"S": shape.S, "Z": shape.Z, "I": shape.I, "O": shape.O, "J": shape.J, "T": shape.T, "L": shape.L}
Dummy = [
    [".....", ".....", ".....", ".....", "....."]
]

shapes = {"S": None, "Z": None, "I": None, "O": None, "J": None, "T": None, "L": None}
next_shapes = {"S": None, "Z": None, "I": None, "O": None, "J": None, "T": None, "L": None}
for key, value in shape_dict.items():
    shape = Shape(value)
    shape.set_pos(5 / 2, 1)
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


x = 10
y = 30

bottom = [(i, y) for i in range(x)] + [(i, y + 1) for i in range(x)]
left_lateral = [(0, i) for i in range(y)]
right_lateral = [(x - 1, i) for i in range(y + 1)]

grid = bottom + left_lateral + right_lateral


def zeros(dim1, dim2):
    res = []
    for i in range(dim1):
        res += []
        for j in range(dim2):
            res[i] += [0]

    return res

class State:
    def __init__(self, game: list, current_piece: Shape, action: Action = None, parent=None, lookahead=[],
                 inherit=False) -> None:
        self.game = game
        self.current_piece = deepcopy(current_piece)
        self.action = action
        self.parent = parent
        self.lookahead = lookahead

        self.h_column_height = parent.h_column_height if parent is not None and inherit else [0, 0, 0, 0, 0, 0, 0, 0]
        self.h_game = parent.h_game if parent is not None and inherit else 0
        self.h_column_holes = parent.h_column_holes if parent is not None and inherit else 0

    def fastest_heuristic(self):
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

        return (cleared_lines * 1) + (total_height * -0.65) + (total_height_discrepancy * -0.25) + (
                total_hole_count * -0.4)

    def merge_game_with_shape(self):
        cpy = deepcopy(self.game)
        for x, y in self.current_piece.positions:
            cpy[y][x] = 1
        return cpy

    def _is_valid(self, piece: Shape):
        return not any(
            [piece_part in grid for piece_part in piece.positions]
        ) and not self.kill_me(piece)

    def kill_me(self, piece: Shape):
        for x, y in piece.positions:
            for x2, y2 in self.game:
                if x == x2 and y == y2:
                    return True
        return False

    def _collide_left_lateral(self, piece: Shape):
        return any(
            [piece_part in left_lateral for piece_part in piece.positions]
        )

    def _collide_right_lateral(self, piece: Shape):
        return any(
            [piece_part in right_lateral for piece_part in piece.positions]
        )

    def _collide_bottom(self, piece: Shape):
        return any(
            [piece_part in bottom for piece_part in piece.positions]
        )

    def __is_action_possible(self, action: Action):
        cpy = deepcopy(self.current_piece)
        if self.action == Action.Down:
            return False
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
        return State(self.game, cpy, action)

    def wait(self):
        cpy = deepcopy(self.current_piece)
        cpy.y += 1
        return State(self.game, cpy)

    def get_all_possible_positions(self):
        '''
        Returns all possible positions.
        Some of them might not be reachable
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
            while not self._collide_left_lateral(cpy):
                cpy.translate(-1, 0)
            cpy.translate(1, 0)

            while not self._collide_right_lateral(cpy):
                cpy.y = y
                while not self._collide_bottom(cpy):
                    if self._is_valid(cpy):
                        cpy.y += 1
                        if not self._is_valid(cpy):
                            cpy.y -= 1
                            possible_states.append(State(self.game, cpy))
                            cpy.y += 1
                        cpy.y -= 1
                    cpy.y += 1
                cpy.translate(1, 0)

        return possible_states

    def get_all_possible_positions_fast(self):
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
            while not self._collide_left_lateral(cpy):
                cpy.translate(-1, 0)
            cpy.translate(1, 0)

            while not self._collide_right_lateral(cpy):
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
        # print(col)
        # cpy = deepcopy(self.current_piece)
        # cpy.set_pos(col, cpy.y)
        #
        # if not self._is_valid(cpy):
        #     print("mistakes here")
        #     return None
        #
        # while self._is_valid(cpy):
        #     cpy.y += 1
        # cpy.y -= 1
        # return State(self.game, cpy, parent=self.parent)

    def print_console(self):
        cpy = deepcopy(self.game)
        cpy.extend(self.current_piece.positions)
        res = zeros(30, 8)  # Create list representing game state with 0s
        res[cpy[:, 1], cpy[:, 0] - 1] = 1  # Assign 1 to positions representing filled spaces

    def print_valid_actions(self):
        print(f"Actions: {self.get_valid_actions()}")
        print("-----------")

    ##heuristic stuff
    @staticmethod
    def clear_rows(game: list):
        '''
        Calculates the number of cleared lines and computes the state after they have been cleared.\n
        Returns a tuple with the number of lines and the resulting state.
        '''
        lines = 0
        for item, count in Counter(y for _, y in game).most_common():
            if count == 8:
                game = [(x, y) for (x, y) in game if y != item]  # remove row
                game = [
                    (x, y + 1) if y < item else (x, y) for (x, y) in game
                ]  # drop blocks above
                lines += 1
        return (lines, State(game, Shape(("", Dummy))))

    def get_column_height(self, x: int):
        '''
        Calculates the height of a given column.\n
        Valid x is 1-8
        '''
        for y in range(30):
            if (x, y) in self.game + self.current_piece.positions:
                return 30 - y
        return 0

    def get_total_height_discrepancy(self):
        '''
        Calculates the total height discrepancy by summing the difference in height between adjacent columns
        '''
        discrepancy = 0
        for x in range(1, 8):
            discrepancy += abs(self.get_column_height(x) - self.get_column_height(x + 1))
        return discrepancy

    def height_discrepancy(self):
        maxY = 0
        minY = 30
        for x in range(1, 9):
            for y in range(30):
                if (x, y) in self.game + self.current_piece.positions:
                    if y < maxY:
                        maxY = y
                    if y > minY:
                        minY = y
        return abs(maxY - minY)

    def total_height(self):
        '''
        Calculates the total height by summing the height of each column
        '''
        total = 0
        for x in range(1, 9):
            total += self.get_column_height(x)
        return total

    def hole_count(self):
        '''
        Calculates the number of holes in this state
        '''
        holes = 0
        for x in range(1, 9):
            hit = False
            for y in range(30):
                inside = (x, y) in self.game + self.current_piece.positions
                if not hit:
                    if inside:
                        hit = True
                elif not inside:
                    holes += 1

        return holes

    def heuristic(self, lines, t_height, holes, d_height):
        y = self.clear_rows(self.game + self.current_piece.positions)
        if y[0] == 0:
            return (self.total_height() * t_height) + (self.hole_count() * holes) + (
                    self.get_total_height_discrepancy() * d_height)
        else:
            s = y[1]
            return (s.total_height() * t_height) + (y[0] * lines) + (s.hole_count() * holes) + (
                    s.get_total_height_discrepancy() * d_height)

    def sum_heuristic(self, lines, t_height, holes, d_height, n_cols, n_pits, m_well):
        cleared_lines, column_height, game = self.h_cleared_lines()

        number_of_pits = self.h_number_of_pits(column_height)

        total_height = self.h_total_height(column_height)

        max_well, total_height_discrepancy = self.h_total_height_discrepancy_max_well(column_height)

        columns_holes, total_hole_count = self.h_total_hole_count(column_height, game)

        # n_cols_with_holes = np.count_nonzero(np.array(columns_holes) > 0)
        n_cols_with_holes = len([ch for ch in columns_holes if ch > 0])

        # State.print_console(self)
        # print(f"Pits: {number_of_pits}\nColumns: {n_cols_with_holes}\nMax: {max_well}")

        return (cleared_lines * lines) + (total_height * t_height) + (total_height_discrepancy * d_height) + (
                total_hole_count * holes) + (n_cols_with_holes * n_cols) + (number_of_pits * n_pits) + (
                       max_well * m_well)

    def h_total_hole_count(self, column_height, game):
        total_hole_count = 0
        columns_holes = [0, 0, 0, 0, 0, 0, 0, 0]
        for x in range(1, 9):
            col_count = 0
            hit = False
            for y in range(30 - column_height[x - 1], 30):
                inside = (x, y) in game
                if not hit:
                    if inside:
                        hit = True
                elif not inside:
                    total_hole_count += 1
                    col_count += 1
            if col_count > 0:
                columns_holes[x - 1] = col_count
        return columns_holes, total_hole_count

    def h_total_height_discrepancy_max_well(self, column_height):
        total_height_discrepancy = 0
        max_well = 0
        for x in range(0, 7):
            if max_well < abs(column_height[x] - column_height[x + 1]):
                max_well = abs(column_height[x] - column_height[x + 1])
            total_height_discrepancy += abs(column_height[x] - column_height[x + 1])
        return max_well, total_height_discrepancy

    def h_total_height(self, column_height):
        total_height = sum(column_height)
        return total_height

    def h_number_of_pits(self, column_height):
        number_of_pits = 0
        for i in column_height:
            if i == 0:
                number_of_pits += 1
        return number_of_pits

    def h_cleared_lines(self):
        rows = self.clear_rows(self.game + self.current_piece.positions)
        cleared_lines = rows[0]
        if cleared_lines != 0:
            game = rows[1].game
        else:
            game = self.game + self.current_piece.positions
        column_height = [0, 0, 0, 0, 0, 0, 0, 0]
        for x in range(1, 9):
            for y in range(30):
                if (x, y) in game:
                    column_height[x - 1] = 30 - y
                    break
        return cleared_lines, column_height, game

    def fast_heuristic(self, lines, t_height, holes, d_height, n_cols, n_pits, m_well):
        rows = self.clear_rows(self.game + self.current_piece.positions)
        cleared_lines = rows[0]
        game = None
        if cleared_lines != 0:
            game = rows[1].game
        else:
            game = self.game + self.current_piece.positions

        column_height = [0, 0, 0, 0, 0, 0, 0, 0]
        for x in range(1, 9):
            for y in range(30):
                if (x, y) in game:
                    column_height[x - 1] = 30 - y
                    break

        number_of_pits = 0
        for i in column_height:
            if i == 0:
                number_of_pits += 1

        total_height = sum(column_height)

        total_height_discrepancy = 0
        max_well = 0
        for x in range(0, 7):
            if max_well < abs(column_height[x] - column_height[x + 1]):
                max_well = abs(column_height[x] - column_height[x + 1])
            total_height_discrepancy += abs(column_height[x] - column_height[x + 1])

        total_hole_count = 0
        columns_holes = [0, 0, 0, 0, 0, 0, 0, 0]
        for x in range(1, 9):
            col_count = 0
            hit = False
            for y in range(30 - column_height[x - 1], 30):
                inside = (x, y) in game
                if not hit:
                    if inside:
                        hit = True
                elif not inside:
                    total_hole_count += 1
                    col_count += 1
            if col_count > 0:
                columns_holes[x - 1] = col_count

        # n_cols_with_holes = np.count_nonzero(np.array(columns_holes) > 0)
        n_cols_with_holes = len([ch for ch in columns_holes if ch > 0])

        State.print_console(self)

        return (cleared_lines * lines) + (total_height * t_height) + (total_height_discrepancy * d_height) + (
                total_hole_count * holes) + (n_cols_with_holes * n_cols) + (number_of_pits * n_pits) + (
                       max_well * m_well)


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
                shape = Shape(shape_dict[key])
                shape.set_pos(5 / 2, 0)
                return shape
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
                shape = Shape(shape_dict[key])
                return shape
        return None

    @staticmethod
    def dummy_shape():
        return Shape(Dummy)
