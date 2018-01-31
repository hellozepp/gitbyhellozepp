import greenlet


def fun1():
    print("12")
    gr2.switch()
    print("56")
    gr2.switch()


def fun2():
    print("34")
    gr1.switch()
    print("78")


gr1 = greenlet.greenlet(fun1)
gr2 = greenlet.greenlet(fun2)
gr1.switch()