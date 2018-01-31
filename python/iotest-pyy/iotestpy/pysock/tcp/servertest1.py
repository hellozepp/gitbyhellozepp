import socket
import time

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # 创建socket (AF_INET:IPv4, AF_INET6:IPv6) (SOCK_STREAM:面向流的TCP协议)
s.bind(("0.0.0.0", 10021))
s.listen(1)  # 监听，等待连接的最大数目为1
print("Server is running...")
def TCP(sock, addr):
    while True:
        data = sock.recv(1024)
        time.sleep(1)
        if not data or data.decode() == "quit":
            break
        sock.send(("hello "+data.decode("utf-8")).encode("utf-8"))
    sock.close()
while True:
    sock, addr = s.accept()
    TCP(sock, addr)