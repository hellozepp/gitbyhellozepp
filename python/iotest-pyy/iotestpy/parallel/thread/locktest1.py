import threading
import time

#由于python没有真正意义的多核多线程调度，因此加不加锁没区别
data=1
def doSomthing1(lock):
    global data
    lock.acquire()
    data=data+1
    lock.release()

lock=threading.Lock()


for i in range(1,10):
    t1 = threading.Thread(target=doSomthing1, args=(lock,))
    t1.start()

time.sleep(2)

print(data)

# =======================================================================
print("=======================================================================")

# RLock允许在同一线程中被多次acquire。而Lock却不允许这种情况。
# 如果使用RLock，那么acquire和release必须成对出现，即调用了n次acquire，
# 必须调用n次的release才能真正释放所占用的琐。
# 可重入锁，也叫做递归锁，指的是同一线程 外层函数获得锁之后 ，内层递归函数仍然有获取该锁的代码，但不受影响。
# 有Lock了为什么还需要RLock呢？可重入锁最大的作用是在需要重复获得锁的情况下（如：递归调用）避免死锁！！！
# RLock对象是Lock对象的一个变种，但是它是一种可重入的Lock，其内部维护着一个Lock对象，还有一个计数器。
print("1")
# lock = threading.Lock()    #Lock对象
# lock.acquire()
# lock.acquire()  #产生了死琐。
# lock.release()
# lock.release()

print("2")
lock = threading.Lock()    #Lock对象
print(lock.acquire(blocking=False))
print(lock.acquire(blocking=False))  #产生了死琐。
lock.release()

print("3")

rLock = threading.RLock()  #RLock对象
rLock.acquire()
rLock.acquire()    #在同一线程内，程序不会堵塞。
# 可重入锁（RLock）的release()方法。首先它会去确认调用者是否是锁的拥有者。
# 如果是的话，计数器减1；如果计数器为0，那么锁将会被释放，这时其他线程就可以去获取锁了。
rLock.release()
rLock.release()