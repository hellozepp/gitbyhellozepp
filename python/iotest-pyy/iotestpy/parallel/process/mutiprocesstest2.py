from multiprocessing import Array, Value, Process,Queue

# 数据可以用Value或Array存储在一个共享内存地图里
import time


def func(a, b):
    a.value = 3.333333333333333
    for i in range(len(b)):
        b[i] = b[i]+1
        time.sleep(0.1)


if __name__ == "__main__":

    # ‘c’: ctypes.c_char　　　　 ‘u’: ctypes.c_wchar　　　　‘b’: ctypes.c_byte　　　　 ‘B’: ctypes.c_ubyte
    # ‘h’: ctypes.c_short　　　  ‘H’: ctypes.c_ushort　　  ‘i’: ctypes.c_int　　　　　 ‘I’: ctypes.c_uint
    # ‘l’: ctypes.c_long,　　　　‘L’: ctypes.c_ulong　　　　‘f’: ctypes.c_float　　　　‘d’: ctypes.c_double
    num = Value('d', 0.0)
    arr = Array('i', range(11))

    c = Process(target=func, args=(num, arr))
    d = Process(target=func, args=(num, arr))
    c.start()
    d.start()
    c.join()
    d.join()

    print(num.value)
    for i in arr:
        print(i)

# =======================================================================
print("=======================================================================")

def producer(queue):
    for sth in range(5):
        queue.put(sth)
        print("队列中放入{}".format(sth))

def consumer(queue):
    for i in range(5):
        res=queue.get()
        print("队列中取出{}".format(res))

myque=Queue(1)
p = Process(target=producer, args=(myque,))
c = Process(target=consumer, args=(myque,))
p.start()
c.start()