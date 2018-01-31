from abc import abstractmethod, ABCMeta
from functools import total_ordering

class A:
    def __new__(clz):
        print("--AA--")
        return object.__new__(clz)
    def __init__(self):
        print("AAA")
    def opt(self):
        print("A")

class B(A):
    def __new__(clz):
        print("--BB--")
        return object.__new__(clz)
    def __init__(self):
        print("BBB")
    def opt(self):
        print("B")

class C(A):
    def __new__(clz):
        print("--CC--")
        return object.__new__(clz)
    def __init__(self):
        print("CCC")
    def opt(self):
        print("C")

class D(B,C):
    def __new__(clz):
        print("--DD--")
        return object.__new__(clz)
    def __init__(self):
        print("DDD")

class D1(C,B):
    def __new__(clz):
        print("--DD1--")
        return object.__new__(clz)

    def __init__(self):
        print("DDD1")

class PPP:
    def opt(self):
        print("XXXX")

class TTT:
    pass

class SSS(TTT):
    pass

if __name__=="__main__":
    d=D()
    d.opt()

    d1 = D1()
    d1.opt()

    print(D.__mro__)
    print(D1.__mro__)

    print(D.__base__)
    print(D1.__base__)

    print(D.__bases__)

    d = D()

    D.__bases__=(PPP,)

    print(D.__bases__)

    print(D.__mro__)

    d.opt()

    s=SSS()
    print(SSS.__bases__)
    SSS.__bases__=(PPP,)
    s.opt()
    type()