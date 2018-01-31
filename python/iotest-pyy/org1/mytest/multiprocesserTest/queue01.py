# coding=utf-8
from multiprocessing import Process, Queue

import time


def write(q):
    for i in range(5):
        print("put Queue %s" % i)
        q.put(i)
        time.sleep(0.5)


def read(q):
    while True:
        v = q.get(True)
        print("get the %s" % v)


if __name__ == "__main__":
    q = Queue()
    pr = Process(target=read, args=(q,))
    pw = Process(target=write, args=(q,))
    pr.start()
    pw.start()
    pw.join()
    pr.terminate()
