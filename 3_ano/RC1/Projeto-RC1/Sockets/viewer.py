import time
import json
from cProfile import label
from turtle import right
import matplotlib as mpl
import matplotlib.pyplot as plt

alive = True

def on_close(event):
    alive = False

def main():
    mpl.rcParams['toolbar'] = 'None'

    filename = input("File: ")

    file = open(filename, "r")

    cpu = []
    memory = []
    swap = []

    for line in file:
        data = json.loads(line)
        cpu.append(data["Cpu"])
        memory.append(data["Memory"])
        swap.append(data["Swap"])

    x = [i for i in range(len(cpu))]

    plt.ion()
    fig = plt.figure()
    fig.canvas.mpl_connect('close_event', on_close)

    cpu_line, = plt.plot(x, cpu, label="Cpu")
    memory_line, = plt.plot(x, memory, label="Memory")
    swap_line, = plt.plot(x, swap, label="Swap")
    
    plt.ylabel('percentage (%)')
    plt.xlabel('time (s)')
    plt.title(filename)
    plt.legend()
    plt.show()

    # https://makersportal.com/blog/2018/8/14/real-time-graphing-in-python
    # https://stackoverflow.com/a/3290355
    file.seek(0,2)
    while alive:
        line = file.readline()
        if line:
            data = json.loads(line)
            cpu.append(data["Cpu"])
            memory.append(data["Memory"])
            swap.append(data["Swap"])
            x.append(len(x))


        cpu_line.set_ydata(cpu)
        cpu_line.set_xdata(x)
        memory_line.set_ydata(memory)
        memory_line.set_xdata(x)
        swap_line.set_ydata(swap)
        swap_line.set_xdata(x)

        plt.xlim(right=len(x))

        plt.pause(0.05)

    file.close()

if __name__ == "__main__":
    main()