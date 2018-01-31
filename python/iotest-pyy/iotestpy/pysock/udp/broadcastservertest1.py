from socket import *
from time import ctime

HOST = '0.0.0.0'
PORT = 21567
BUFSIZE = 1024

ADDR = (HOST, PORT)

udpSerSock = socket(AF_INET, SOCK_DGRAM)
udpSerSock.bind(("", PORT))
while True:
    data, addr = udpSerSock.recvfrom(BUFSIZE)
    print("...received ->{} {}".format(addr, data))

udpSerSock.close()