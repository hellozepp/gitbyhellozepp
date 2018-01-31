import threading

semaphore = threading.Semaphore(2)


def func():
    if semaphore.acquire():
        for i in range(5):
            print(threading.currentThread().getName() + " 正在执行")
        semaphore.release()
        print(threading.currentThread().getName() + " 释放信号量")


for i in range(5):
    t1 = threading.Thread(target=func)
    t1.start()