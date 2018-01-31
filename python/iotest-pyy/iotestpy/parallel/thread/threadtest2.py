import threading
import time


def doSomthing(name):
    for i in range(1,10):
        print(name)
        time.sleep(1)

t1=threading.Thread(target=doSomthing,args=("t1",))
# t1.daemon=True

t2=threading.Thread(target=doSomthing,args=("t2",))
t1.start()
t1.join(100)  #100秒后不再等待
t2.start()
t2.join()


