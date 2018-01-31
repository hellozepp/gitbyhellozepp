import socket

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM) #创建一个socket,SOCK_DGRAM表示UDP
s.bind(("0.0.0.0", 10021))
while True:
    data, addr = s.recvfrom(1024)
    print("Received from {}.".format(addr))
    s.sendto(("hello "+data.decode('utf-8')).encode(), addr)#将数据变成大写送回客户端

#不关闭socket