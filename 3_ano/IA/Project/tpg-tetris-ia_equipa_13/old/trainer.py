# Module Developed by:
# Joao Moura, 43889
# Ruben Castelhano, 97688
# Joao Felisberto, 98003

import csv
import os
from os.path import exists
import random
from statistics import mean


def run_client(port, modifiers: list[float]):
    if not exists("hills.csv"):
        with open("hills.csv", 'w') as f:
            writer = csv.writer(f)
            writer.writerow(("lines", "d_height", "t_height", "holes", "score"))

    if not exists("hillstmp.csv"):
        with open("hillstmp.csv", 'w') as f:
            writer = csv.writer(f)
            writer.writerow(("lines", "d_height", "t_height", "holes", "score"))

    if exists("highscores.json"):
        os.remove("highscores.json")

    os.system(
        f"python3 student2.py --port {port} --lines {modifiers[0]} --t_height {modifiers[1]} --holes {modifiers[2]} --d_height {modifiers[3]}")

    try:

        with open("highscores.json", 'r') as r:
            score = int(r.read())

        res = modifiers + [score]

        with open("hills.csv", 'a', newline='') as f:
            writer = csv.writer(f)
            writer.writerow(res)

        return res

    except FileNotFoundError:
        print("Not found")


def main():
    if exists("highscores.json"):
        os.remove("highscores.json")

    if exists("hillstmp.csv"):
        with open("hillstmp.csv", 'r') as f:
            reader = csv.reader(f)
            last_ln = []
            for ln in reader:
                last_ln = ln

            prev_pt = [float(v) for v in last_ln]
    else:
        prev_pt = None

    while True:
        print("WAS MAX")
        prev_pt, is_max = train_pass(5, start_pt=prev_pt)

        with open("hills.csv", 'a', newline='') as f:
            writer = csv.writer(f)
            writer.writerow(prev_pt)

        while not is_max:
            prev_pt, is_max = train_pass(5)

            with open("hills.csv", 'a', newline='') as f:
                writer = csv.writer(f)
                writer.writerow(prev_pt)


def train_pass(points: int, average: int = 3, port=8000, start_pt=None, threshold=3) -> tuple[list[float], bool]:
    runs = []

    if start_pt is None:
        start_pt = random_point(4, mult=20)
        avg_pt = []
        for j in range(average):
            avg_pt.append(run_client(port, start_pt))

        runs.append(avg_pt[0][:-1] + [int(mean([v[-1] for v in avg_pt]))])
        #        with open("hillstmp.csv", 'a', newline='') as f:
        #            writer = csv.writer(f)
        #            writer.writerow(runs[0])
        start_pt = runs[0]

    for i in range(points):
        point = random_point(4, mult=0.3, centre=start_pt[:-1])

        avg_pt = []
        for j in range(average):
            avg_pt.append(run_client(port, point))

        runs.append(avg_pt[0][:-1] + [int(mean([v[-1] for v in avg_pt]))])
        with open("hillstmp.csv", 'a', newline='') as f:
            writer = csv.writer(f)
            writer.writerow(runs[-1])

    max_pt = max(runs, key=lambda run: run[-1])

    return max_pt, (abs(max_pt[-1] - start_pt[-1]) <= threshold)


def random_point(n: int, mult: float = 1, centre: list[float] = None) -> list[float]:
    res = []
    for i in range(n):
        res.append((random.random() * mult) - (mult / 2))

    if centre is not None:
        for i in range(n):
            res[i] += centre[i]

    return res


if __name__ == '__main__':
    try:
        main()
    except OSError:
        print("Bye")
