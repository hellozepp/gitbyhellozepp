def decorate(func):
    def wrapper():
        print("定义一个装饰器")
        func()
    return wrapper
def text1():
    print("text1")

decorate(text1)()

print("="*50+"1")
#=======================================================

def decorate(func):
    def wrapper():
        print("定义一个装饰器")
        func()
    return wrapper
@decorate
def text1():
    print("text1")

text1()

print("="*50+"2")
#=======================================================

def decorate(name):
    def wrapper(func):
        def sub_wrapper():
            print("定义一个带参数的装饰器",name)
            func()
        return sub_wrapper
    return wrapper

def text1():
    print("text1")

decorate(name="python")(text1)()

print("="*50+"3")
#=======================================================

def decorate(name):
    def wrapper(func):
        def sub_wrapper():
            print("定义一个带参数的装饰器",name)
            func()
        return sub_wrapper
    return wrapper

@decorate(name="python")
def text1():
    print("text1")

text1()



print("="*50+"4")
#=======================================================

def decorate(name):
    def wrapper(func):
        def sub_wrapper(arg):
            print("定义一个带参数的装饰器",name)
            func(arg)
        return sub_wrapper
    return wrapper

def text1(arg):
    print("text1",arg)

decorate(name="python")(text1)("xxx")

print("="*50+"5")
#=======================================================

def decorate(name):
    def wrapper(func):
        def sub_wrapper(arg):
            print("定义一个带参数的装饰器",name)
            func(arg)
        return sub_wrapper
    return wrapper

@decorate(name="python")
def text1(arg):
    print("text1",arg)

text1("xxx")

print("="*50+"6")

#=======================================================

def wrapper(func):
    def sub_wrapper(arg):
        print("定义一个带参数的装饰器",arg)
        func(arg)
    return sub_wrapper

@wrapper
def text1(arg):
    print("text1",arg)


text1("xxx")

print("="*50+"7")
#===========================================
def decorate(func):
    def wrapper():
        func()
    return wrapper

def decoratex(func):
    def wrapper():
        func()
    return wrapper

def test11():
    print("lllll")

decorate(decoratex(test11))()

print("="*50+"8")
#===========================================
def decorate(func):
    def wrapper():
        func()
    return wrapper

def decoratex(func):
    def wrapper():
        func()
    return wrapper

@decorate
@decoratex
def test11():
    print("lllll")

test11()

print("="*50+"9")
#===========================================
class DDD():
    def decorate(func):
        def wrapper():
            func()
        return wrapper


@DDD.decorate
def test11():
    print("oooo")

test11()

# print(DDD.__dict__)

print("="*50+"10")
#=====================后面是类装饰器======================

def clsdeco(clz):
    class Test:
        def __init__(self):
            self.couse=clz()

        def getContent1(self):
            return "couse: "+self.couse.getContent()

    return Test

@clsdeco
class Eng:
    def getContent(self):
        return "ENG"

s=Eng()
print(s.getContent1())

# c=clsdeco(Eng)
# s=c()
# print(s.getContent())

print("="*50+"11")
#=========================================================

class desc1:
    def __init__(self,func):
        print("￥￥￥￥￥")
        self.func=func
    def __call__(self, *args, **kwargs):
        print("～～～～")
        res=self.func(args[0])
        return res

# @desc1
def some(arg):
    return arg+1

r=some(1)
print(r)

s=desc1(some)
r=s.__call__(1)

print(r)


print("="*50+"12")
#=========================================================


class decro1:
    def __init__(self,clz):
        self.clz=clz #Eng1

    def __call__(self, *args, **kwargs):
        class prof:
            def __init__(self,couse):
                self.couse=couse

            def getContent1(self):
                return self.couse.getContent1()+"|ZH|MATH"
        return prof(self.clz())

@decro1
class Eng1:
    def __init__(self):
        print("00000000")
    def getContent1(self):
        return "ENG"

class Eng2:
    def getContent1(self):
        return "ENG2"

c=Eng1()
print(c.getContent1())
print("--------------------------")

d=decro1(Eng2)
c=d.__call__()
print(c.getContent1())

print("="*50+"13")
#=========================================================

class Xxx():
    def __init__(self):
        pass

    def __call__(self, func):
        def _call(*args, **kw):
            return func(*args, **kw)

        return _call

class Yyy(object):
    @Xxx()
    def dis(self, test, ids):
        print('yyyyyyy: '+test+" "+ids)

Xxx().__call__(Yyy().dis)("aaa","bbb")

Yyy().dis("aaa","bbb")

print("="*50+"14")
#=========================================================



def log(mth):
    def wrapper(self,*args,**kwargs):
        print(self,args,kwargs)
        return mth(self,*args,**kwargs)#mth(s,1,2)
    return wrapper

class Some:
    @log
    def doit(self,a,b):
        return a+b

    def doit2(self,a,b):
        return a+b

s=Some()
print(s.doit(1,2))

s=Some()
print(log(Some.doit2)(s,1,2))

print("="*50+"15")
#=========================================================
class lazy():
    def __init__(self, func):
        self.func = func

    def __get__(self, instance, cls):
        print("=====")
        val = self.func(instance)
        setattr(instance, self.func.__name__, val)
        return val


class Circle():
    def __init__(self, radius):
        self.radius = radius

    @lazy
    def area(self):
        print('evalute')
        return 3.14 * self.radius ** 3


c = Circle(4)
print(c.radius)
print(c.area)
print(c.area)
print(c.area)

print("="*50+"16")
#=========================================================
class classmath:
    def __init__(self,mth):
        self.mth=mth

    def __get__(self, instance, owner):
        def wrapper(*args,**kwargs):
            return self.mth(owner,*args,**kwargs)

        return wrapper




class Other:
    @classmath
    def doit(clz,a,b):
        print(clz,a,b)
        return a+b

class Other1:
    def doit(clz,a,b):
        print(clz,a,b)
        return a+b

print(Other.doit(1,2))
o=Other1()
c=classmath(Other1.doit)
print(classmath.__get__(c,o,Other1)(1,2))

o=Other()
print(o.doit(1,2))



