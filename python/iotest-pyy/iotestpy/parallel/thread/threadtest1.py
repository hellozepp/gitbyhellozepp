import threading

import time


def doSomthing():
    print(threading.current_thread().name)

t1=threading.Thread(target=doSomthing)
t2=threading.Thread(target=doSomthing)
t1.start()
t2.start()

# =======================================================================
print("=======================================================================")

class MyRunable(threading.Thread):
    def __init__(self,name):
        super().__init__()
        self.name=name

    def run(self):
        while(True):
            print(self.name)
            time.sleep(0.5)  #0.5秒

MyRunable("myrun").start()
