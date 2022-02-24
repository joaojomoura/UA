import socket
import threading
import struct

ip_addr = "0.0.0.0"
tcp_port = 7777

def process_client_stats(client_socket,address): 
    print(f'Accepted connection from {address[0]}:{address[1]}')

    logFile = open(f"{address[0]}_{address[1]}.txt", 'w')
    try:
        while True:
            request = client_socket.recv(1024)
            if not request:
                client_socket.close()
                break
            else:
                print(request.decode())
                logFile.write(f"{request.decode()}\n")
                logFile.flush()
    except (socket.timeout, socket.error):
        print(f'Client {address} error. Done!')
    finally:
        logFile.close()


server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((ip_addr, tcp_port))
server.listen()

print(f'Listening on {ip_addr}:{tcp_port}')

while True:
    client_sock, address = server.accept()
    client_handler = threading.Thread(target=process_client_stats,args=(client_sock,address),daemon=True)
    client_handler.start()