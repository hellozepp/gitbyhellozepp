import threading
import time

class Queue:
    def __init__(self):
        self.sth=-1
        self.cond=threading.Condition()

    def put(self,sth):
        with self.cond:
            while self.sth != -1:
                self.cond.wait()
            self.sth=sth
            self.cond.notify()

    def take(self):
        with self.cond:
            while self.sth == -1:
                self.cond.wait()
            res=self.sth
            self.sth=-1
            self.cond.notify()
            return res

def producer(queue):
    for sth in range(5):
        queue.put(sth)
        print("队列中放入{}".format(sth))
        time.sleep(1)

def consumer(queue):
    for i in range(5):
        res=queue.take()
        print("队列中取出{}".format(res))
        time.sleep(1)

queue=Queue()
p = threading.Thread(target=producer,args=(queue,))
c = threading.Thread(target=consumer,args=(queue,))

p.start()
c.start()




