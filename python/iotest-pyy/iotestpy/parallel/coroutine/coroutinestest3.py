# pip3 install --upgrade pip3
# pip3 install gevent

import gevent


def fun1():
    print("a")  # 第一步
    gevent.sleep(0)  #可以通过gevent.sleep()交出控制权
    print("end a")  # 第三步


def fun2():
    print("b")  # 第二步
    gevent.sleep(0)
    print("end b")  # 第四步


gevent.joinall([
    gevent.spawn(fun1),
    gevent.spawn(fun2),
])


# =======================================================================
print("=======================================================================")

# 当一个greenlet遇到IO操作时，比如访问网络，就自动切换到其他的greenlet，
# 等到IO操作完成，再在适当的时候切换回来继续执行。由于IO操作非常耗时，经常使程序处于等待状态，
# 有了gevent为我们自动切换协程，就保证总有greenlet在运行，而不是等待IO。


# gevent.monkey.patch_all()的作用是将一些常见的阻塞，
# 如socket、select等会阻塞的地方实现协程跳转，而不是在那里一直等待，导致整个协程组无法工作。

import gevent.monkey
gevent.monkey.patch_all()

import urllib.request

def f(url):
    print("GET: {}".format(url))
    resp = urllib.request.urlopen(url)
    print("===: "+url)
    data = resp.read()
    print("{} bytes received from {}.".format (len(data), url))

gevent.joinall([
        gevent.spawn(f, "https://www.python.org/"),
        gevent.spawn(f, "https://www.yahoo.com/"),
        gevent.spawn(f, "https://github.com/"),
])