import threading
import time

class Res:
    def __init__(self,name,resoure):
        self.name=name
        self.resource=resoure
        self.lock=threading.Lock()

    def action(self):
        with self.lock:
            self.resource+=1
            return self.resource

    def cooperate(self,other):
        with self.lock:
            other.action()
            print("{}整合{}的资源".format(self.name,other.name))

def cooperate(a,b):
    for i in range(10):
        a.cooperate(b)

res1=Res("res1",10)
res2=Res("res2",20)

t1 = threading.Thread(target=cooperate, args=(res1,res2))
t2 = threading.Thread(target=cooperate, args=(res2,res1))
t1.start()
t2.start()