import os
import sys
inpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/input2.txt"
outpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/output2.txt"

print(sys.stdin.fileno())
print(sys.stdout.fileno())
print(sys.stderr.fileno())
with open(inpath) as f:
    print(f.fileno())

# =======================================================================
print("=======================================================================")
# os.O_RDONLY: 以只读的⽅式打开
# os.O_WRONLY: 以只写的⽅式打开
# os.O_RDWR : 以读写的⽅式打开
# os.O_NONBLOCK: 打开时不阻塞
# os.O_APPEND: 以追加的⽅式打开
# os.O_CREAT: 创建并打开⼀个新⽂件
# os.O_TRUNC: 打开⼀个⽂件并截断它的长度为零（必须有写权限）
# os.O_EXCL: 如果指定的⽂件存在，返回错误
# os.O_SHLOCK: ⾃动获取共享锁
# os.O_EXLOCK: ⾃动获取独⽴锁
# os.O_DIRECT: 消除或减少缓存效果
# os.O_FSYNC : 同步写⼊
# os.O_NOFOLLOW: 不追踪软链接
fd=os.open(inpath,os.O_RDONLY)
bytearr=os.read(fd,15)
print(bytearr)
print(bytearr.decode("utf-8"))
os.close(fd)

# =======================================================================
print("=======================================================================")

def xxx(path,flags):
    if os.path.exists(path):
        return os.open(path,flags)
    else:
        return sys.stdout.fileno()

f=open("xxx","w",opener=xxx)
f.write("aaaaa")

f1=open(outpath,"w",opener=xxx)
f1.write("aaaaa")