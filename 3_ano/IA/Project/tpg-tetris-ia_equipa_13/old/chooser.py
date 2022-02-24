# Module Developed by:
# Joao Moura, 43889
# Ruben Castelhano, 97688
# Joao Felisberto, 98003

"""
Based on a heuristics function determine where to drop the piece
"""


def weight(height: float) -> float:
    """
    Given the weights of the attributes calculates a column's heuristics
    """
    return -height


def play(state: list[list[int]], next_piece: list[list[int]]) -> list[str]:
    """
    Given the game state outputs the sequence of keys to be played
    TODO: implement rotation
    """
    # util.get_piece(next_piece)
    if next_piece is None:
        return [""]

    columns = heuristic(state, next_piece)
    print(columns)

    present, length, rotations = read_piece(next_piece)
    max_c = 0
    for i in range(len(columns) - length + 1):
        if sum(columns[max_c:max_c + length]) < sum(columns[i:i + length]):
            max_c = i
    # for i in range(len(columns)):
    #     if columns[max_c] < columns[i]:
    #         max_c = i
    print([-1 if max_c <= v < max_c + length else -8 for v in range(len(columns))])

    moves = 'a ' * (present - max_c - 1) if max_c < present else 'd ' * (max_c - present + 1)
    print(moves)
    # return (moves + 's').split()
    return moves.split()


def heuristic(state: list[list[int]], piece: list[list[int]]):
    """
    Given the game state and a piece returns the heuristics for every column

    analyses height and piece affinity
    """
    heights = []

    for x in range(1, 9):
        for y in range(30):
            if [x, y] in state:
                break
        height = 30 - y

        heights.append(height)

    return calculate(heights)


def calculate(heights: list) -> list[float]:
    """
    Given lists with parameters calculates the final heuristics
    """
    res = list(range(len(heights)))
    for i in range(len(res)):
        res[i] = weight(heights[i])

    return res


def read_piece(piece: list[list[int]]) -> (int, int, int):
    """
    Tells where the piece is and how large it is
    """
    xs = [x for x, y in piece]
    ys = [y for x, y in piece]

    x = list(set(xs))
    y = list(set(ys))

    first = min(x)
    length = len(x)

    rotations = 0 if len(x) == len(y) else \
        1 if len([v for v in ys if v == y[0]]) == 2 and len([v for v in ys if v == y[1]]) == 2 \
            else 3

    return first, length, rotations
