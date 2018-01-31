logger = open("log.txt", "w")
try:
    logger.write('Hello1 ')
    logger.write('World')
finally:
    logger.close()

print(logger.closed)

#上下文管理器
with open("log.txt",'w') as logger:
    logger.write("hello2")
print(logger.close())

#实现计时功能
import time
class MyTimer(object):
    def __init__(self, verbose=False):
        self.verbose = verbose

    def __enter__(self):
        self.start = time.time()
        return self

    def __exit__(self, *unused):
        self.end = time.time()
        self.secs = self.end - self.start
        self.msecs = self.secs * 1000
        if self.verbose:
            print("elapsed time: %f ms" % self.msecs)


def fib(n):
    if n in [1, 2]:
        return 1
    else:
        return fib(n - 1) + fib(n - 2)
with MyTimer(True):
    print(fib(30))


