import socket
import psutil
import time
import datetime
import sys
import json

print(f"Cpu Count is: {psutil.cpu_count()}")


ip_addr = "127.0.0.1"
tcp_port = 7777

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

sock.connect((ip_addr, tcp_port))

while True:
    try: 
        stats = {"Timestamp:": datetime.datetime.now().timestamp(), "Cpu": psutil.cpu_percent(interval=1, percpu=False), 
                 "Memory": psutil.virtual_memory()[2], "Swap": psutil.swap_memory().percent}
        # print(f"Cpu usage: {psutil.cpu_percent(interval=1, percpu=True)}")
        # print(f"Swap: {psutil.swap_memory()}")
        # print(f"Virtual: {psutil.virtual_memory()}")
        print(json.dumps(stats).encode())
        sock.send(json.dumps(stats).encode())
        time.sleep(1)
    except (socket.timeout, socket.error):
        print('Server error. Done!')
        sys.exit(0)