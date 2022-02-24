# Module Developed by:
# Joao Moura, 43889
# Ruben Castelhano, 97688
# Joao Felisberto, 98003

import asyncio
from copy import deepcopy
import getpass
import json
import os
import time
import websockets

from fast_search import AStar, F_Search
from utils import State, ShapeHelper
from pprint import pprint

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


async def agent_loop(server_address="localhost:8000", agent_name="student"):
    async with websockets.connect(f"ws://{server_address}/player") as websocket:

        # Receive information about static game properties
        await websocket.send(json.dumps({"cmd": "join", "name": agent_name, "key": ""}))

        initial_game = await websocket.recv()

        lastState = None
        nextKey = []
        current_state: State = None
        target_state: State = None
        s_search: F_Search = F_Search()

        while True:
            try:
                state = json.loads(
                    await websocket.recv()
                )  # receive game update, this must be called timely or your game will get out of sync with the server

                if lastState is None and "piece" in state and state["piece"] is not None:

                    if current_state is None:
                        # t1 = time.time()
                        print("-----------New Piece ------------")
                        print(state["piece"])
                        shape = ShapeHelper.get_shape(state["piece"])
                        if shape is None:
                            continue

                        cpy = deepcopy(clean_game)
                        for x, y in state['game']:
                            cpy[y][x] = 1

                        current_state = State(cpy, shape)
                        # current_state.lookahead = [
                        #     ShapeHelper.get_next_shape(s) for s in
                        #     state['next_pieces']
                        # ]
                        current_state = current_state.wait()

                        positions = current_state.get_all_possible_positions_fast()
                        positions.sort(key=lambda x: x.fast_heuristic())

                        best_positions = positions[-2:]
                        positions = []
                        next_piece = ShapeHelper.get_next_shape(state['next_pieces'][0])
                        for pos in best_positions:
                            s = State(pos.merge_game_with_shape(), next_piece, parent=pos)
                            positions += s.get_all_possible_positions_fast()
                        positions.sort(key=lambda x: x.fast_heuristic())

                        target_state: State = positions[-1].parent
                        # print(f"time taken: {time.time()-t1}")

                        # print(positions)
                        # print([p.parent for p in positions])

                elif current_state is not None:
                    # t1 = time.time()
                    astar = AStar(current_state, target_state)
                    search_result = astar.search()
                    # print(f"A-star time: {time.time() - t1}")
                    if search_result is not None:
                        nextKey = search_result
                    else:
                        nextKey = s_search.get_path(current_state, target_state)
                    current_state = None
                    # rint(f"Path: {nextKey}")

                if "piece" in state:
                    lastState = state["piece"]
                key = ''
                if nextKey != []:
                    key = nextKey.pop(0)

                await websocket.send(
                    json.dumps({"cmd": "key", "key": key})
                )  # send key command to server - you must implement this send in the AI agent
            except websockets.exceptions.ConnectionClosedOK:
                print("Server has cleanly disconnected us")
                return


# DO NOT CHANGE THE LINES BELLOW
# You can change the default values using the command line, example:
# $ NAME='arrumador' python3 client.py
loop = asyncio.get_event_loop()
SERVER = os.environ.get("SERVER", "localhost")
PORT = os.environ.get("PORT", "8000")
NAME = os.environ.get("NAME", getpass.getuser())
loop.run_until_complete(agent_loop(f"{SERVER}:{PORT}", NAME))
