from multiprocessing import Process, Manager

# Server process manager比 shared memory 更灵活，因为它可以支持任意的对象类型。
# 另外，一个单独的manager可以通过进程在网络上不同的计算机之间共享，不过他比shared memory要慢。

# 由Manager()返回的manager提供list, dict, Namespace, Lock, RLock, Semaphore, BoundedSemaphore,
# Condition, Event, Barrier, Queue, Value and Array类型的支持

def f(d, l):
    d["name"] = "aaa"
    d["age"] = 18
    d["Job"] = "pm"
    l.reverse()


if __name__ == "__main__":
    with Manager() as man:
        d = man.dict()
        l = man.list(range(10))

        p = Process(target=f, args=(d, l))
        p.start()
        p.join()

        print(d)
        print(l)