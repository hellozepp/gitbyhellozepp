import socket

socCli = socket.socket()
socCli.connect(('127.0.0.1', 8080))
while True:
    data = input("input str:")
    socCli.send(data.encode())
    print(socCli.recv(1024).decode("utf-8"))