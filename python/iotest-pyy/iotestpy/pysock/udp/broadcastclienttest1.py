from socket import *

from pip._vendor.distlib.compat import raw_input

HOST = "<broadcast>"
PORT = 21567
BUFSIZE = 1024

ADDR = (HOST, PORT)

udpCliSock = socket(AF_INET, SOCK_DGRAM)
udpCliSock.bind(('', 0))
udpCliSock.setsockopt(SOL_SOCKET, SO_BROADCAST, 1)
while True:
    data = raw_input('>')
    if not data:
        break
    print("sending -> {}" .format(data) )
    udpCliSock.sendto(data.encode("utf-8"), ADDR)
##    data,ADDR = udpCliSock.recvfrom(BUFSIZE)
##    if not data:
##        break
##    print data

udpCliSock.close()