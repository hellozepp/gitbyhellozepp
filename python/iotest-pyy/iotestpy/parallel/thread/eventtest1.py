import threading
import time

# isSet():  　　　　 当内置标志为True时返回True。
# set():     　　　　将标志设为True，并通知所有处于等待阻塞状态的线程恢复运行状态。
# clear():   　　　　将标志设为False。
# wait([timeout]):  如果标志为True将立即返回，否则阻塞线程至等待阻塞状态，等待其他线程调用set()

event = threading.Event()

def func():
    print("{} 正在等待事件" .format(threading.currentThread().getName()))
    event.wait()
    print("{} 获取事件通知，运行程序" .format(threading.currentThread().getName()))


if __name__ == "__main__":
    t1 = threading.Thread(target=func)
    t2 = threading.Thread(target=func)
    t1.start()
    t2.start()

    time.sleep(2)

    event.set()

    t1.join()
    t2.join()