import threading,queue
import time

def producer(queue):
    for sth in range(5):
        queue.put(sth)
        print("队列中放入{}".format(sth))

def consumer(queue):
    for i in range(5):
        res=queue.get()
        print("队列中取出{}".format(res))

myque=queue.Queue(2)
p = threading.Thread(target=producer,args=(myque,))
c = threading.Thread(target=consumer,args=(myque,))

p.start()
c.start()




