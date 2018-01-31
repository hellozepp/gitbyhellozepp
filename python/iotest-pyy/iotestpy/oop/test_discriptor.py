class NonNegative():
    # self：descriptor 实例本身（如 Math.score）
    # ，ist：调用 score 的实例（如 xiaoming）,cls：descriptor 实例所在的类（如MathScore）
    def __init__(self):
        self.dic = dict()

    def __get__(self, ist, cls):
        print('Description get', ist)
        return self.dic[ist]

    def __set__(self, ist, value):
        print('Description set', ist, value)
        if value < 0:
            raise ValueError("Can't be negative number!")
        self.dic[ist] = value


class MathScore():
    score = NonNegative()
    std_id = NonNegative()

    def __init__(self, std_id, score):
        # 这里并未创建实例属性 std_id 和 score, 而是调用 MathScore.std_id 和 MathScore.score

        self.std_id = std_id
        self.score = score

    def check(self):
        if self.score >= 60:
            return 'pass'
        else:
            return 'failed'


xiaoming = MathScore(10, 90)
xiaoming.score=10
print(xiaoming.score)

class decriptorxxx:
    def __init__(self):
        print("__init__")

    def __get__(self, instance, owner):
        owner.xxx(instance)
        print("get",instance,owner)


    def __set__(self, instance, value):
        print("set",instance,value)


    def __delete__(self, instance):
        print("del",instance)


class Some:
    def xxx(self):
        print("xx===============xx")
    d=decriptorxxx()

s=Some()
s.d="aaaa"
s.d
del s.d

decriptorxxx.__set__(s.d,s,"aaaa")

print("="*50+"0")
#===============================================
class GetProp():
    def __init__(self, func):
        self.func = func

    def __get__(self, instance, cls):
        print("getprop")
        val = self.func(instance)
        return val

    def __set__(self, instance, value):
        print("setprop")
        self.func(instance, value)

class UUU():
    def __init__(self):
        pass

    @GetProp
    def uuu(self):
        print("get uuuuuu")
        return self.__uuu

    @GetProp
    def uuuu(self,u):
        print("set uuuuuu")
        self.__uuu=u


c = UUU()
c.uuuu="xxx"
c.uuuu="yyy"
print(c.uuu)

print("="*50+"1")
#=========================一个无法解决的问题，同名函数无法识别==============================
class GetSet():
    def __get__(self, instance, owner):
        print("get")
        return instance.__uuu
    def __set__(self, instance, value):
        print("set")
        instance.__uuu=value


class UUU():
    uuu=GetSet()
    def __init__(self):
        pass

c = UUU()

c.uuu=10
print(c.uuu) #无法识别到靠上的同名函数uuu,所以没法做到built-in的效果
c.uuu="xxx"
print(c.uuu)
print("="*50+"2")
#=======================================================
def myProp(getter,setter):
    class PropDesc:
        def __get__(self, instance, owner):
            return getter(instance)
        def __set__(self, instance, value):
            setter(instance,value)
    return PropDesc()

class Mytest:
    def mmm(self):
        print("get")
        return self.__mmm
    def mmmm(self,m):
        print("set")
        self.__mmm=m
    m=myProp(mmm,mmmm)

mytest=Mytest()
mytest.m=100
print(mytest.m)

print("="*50+"3")
#=======================================================
class Property():
    def __init__(self, fget = None, fset = None, fdel = None, doc = None):
        print("111111111")
        self.fget = fget
        self.fset = fset
        self.fdel = fdel
        if doc is None and fget is not None:
            doc = fget.__doc__
        self.__doc__ = doc

    def __get__(self, obj, objtype = None):
        print("222222222")
        if obj is None:
            return self
        if self.fget is None:
            raise AttributeError("unreadable attribute")
        return self.fget(obj)

    def __set__(self, obj, value):
        print("333333333")
        if self.fset is None:
            raise AttributeError("can't set attribute")
        self.fset(obj, value)

    def __delete__(self, obj):
        print("444444444")
        if self.fdel is None:
            raise AttributeError("can't delete attribute")
        self.fdel(obj)

    def getter(self, fget):
        print("gggggggg")
        return type(self)(fget, self.fset, self.fdel, self.__doc__)  #修改了fget方法

    def setter(self, fset):
        print("sssssssss")
        return type(self)(self.fget, fset, self.fdel, self.__doc__)  #修改了fset方法

    def deleter(self, fdel):
        print("ddddddddd")
        return type(self)(self.fget, self.fset, fdel, self.__doc__)  #修改了fdel方法


class Foo(object):
   def __init__(self):
       self._x = 1

   @Property
   def x(self):#x已经是个Property的对象了
       print('get......')
       return self._x

   @x.setter  #x是上一个x的setter方法返回的一个叫做ｘ的类的对象
   def x(self,val):
       print('set......')
       self._x = val

   @x.deleter
   def x(self):
       print('del.......')
       del self._x

# f=Foo()
# f.x="adfadfaf"
# print(f.x)
# del f.x

print("="*50+"4")
#=========================其他接口==============================

class C():
    a = 'abc'

    def __setattr__(self, key, value):
        print('__setattr__() is called',key,value)

    def __getattribute__(self, *args, **kwargs):
        print("__getattribute__() is called")
        return object.__getattribute__(self, *args, **kwargs)

    def __getattr__(self, name):
        print("__getattr__() is called ",name)
        return name + " from getattr"

    def __get__(self, instance, owner):
        print("__get__() is called", instance, owner)
        return self

    def __set__(self, instance, value):
        print("__set__() is called",instance,value)

    def __del__(self):
        print("__del__() is called")

    def __delattr__(self, item):
        print("__delattr__() is called ", item)




class C2(object):
    d = C()


c = C()
c2 = C2()

print("---------")
c.a="aaa"
print(c.a)
print(c.zzzzzzzz)
print("+++++++++")
c2.d="xxx"
c2.d
print(c2.d.a)

del c.a
