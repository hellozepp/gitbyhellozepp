import threading
import time

b= threading.Barrier(5, timeout=5)

def doSomthing():
    print("{}执行任务A".format(threading.current_thread().name))
    time.sleep(1)
    print("{}到达栅栏位置，开始等待".format(threading.current_thread().name))
    b.wait()
    print("{}执行任务".format(threading.current_thread().name))

for i in range(5):
    threading.Thread(target=doSomthing).start()
