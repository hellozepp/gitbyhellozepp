
class Some:
    def __init__(self):
        print("__init__")
    def __new__(cls, *args, **kwargs):
        print("__new__")
        return  object.__new__(cls)

    def __call__(self, *args, **kwargs):
        print("__call__")

s=Some()
print(type(s)())  #int a=1 ;delctype a b;b=2

print(Some())

Some.__call__(s) #这个不是＠那个__call__


def xxx(arg):
    print(arg)

xxx(100)
xxx.__call__(100)

print("="*50+"1")
#=======================================================

def mysetfun(self,xyz):
    self.xyz=xyz
def mygetfun(self):
    return self.xyz

Test=type("Test", (), {'myset': mysetfun,'myget':mygetfun}) #编译成匿名类


t=Test()
t.myset("xxxxxx")
print(t.myget())


print("="*50+"2")
#=======================================================

class TTT():
    def __init__(self,m):
        self._m=m
    def getm(self):
        return self._m
t=TTT(1)
t=type(t)(100)
print(t.getm())

print("="*50+"3")
#=========================metaclass==============================

class SomeMeta(type):
    def __new__(metaclz,clzname,parents,attrs):
        clz=super(metaclz,metaclz).__new__(metaclz,clzname,parents,attrs)
        print("SomeMeta__new__",metaclz,"---",clzname,"---",parents,"---",attrs,"-----",clz)
        return clz

    def __init__(clz,clzname,parents,attrs):
        super(__class__, clz).__init__(clzname,parents,attrs)
        print("SomeMeta__init__",clz,"---",clzname,"---",parents,"---",attrs)

Some=SomeMeta('Some',(object,),{"doit":(lambda self,x:print("hello",x))})
print("------")
s=Some()
s.doit(100)

class Other(metaclass=SomeMeta):
    def __new__(cls, *args, **kwargs):
        print("Other new")
        obj=super().__new__(cls)
        return obj
    def __init__(self,n):
        self.__n=n
        print("Other init")
    def doOther(self,x):
        print("Other",x)

o=Other(199)
o.doOther(100)

class Objj:
    pass

class Other(Objj,metaclass=SomeMeta):
    def doOther(self,x):
        print("Other",x)

o=Other()
o.doOther(100)

print("="*50+"4")
#=======================================================

class SomeMeta(type):
    def __call__(clz, *args, **kwargs):
        print("call __new__")
        instance=clz.__new__(clz,*args,**kwargs)
        print("call __init__")
        clz.__init__(instance,*args,**kwargs)
        return instance

class Some(metaclass=SomeMeta):
    def __new__(cls, *args, **kwargs):
        print("Some __new__")
        return object.__new__(cls)

    def __init__(self):
        print("Some __init__")

s=Some()

print("="*50+"5")
#===========================抽象方法============================

class AbsX:
    def doSome(self):
        pass
    def doOther(self):
        pass

AbsX.__abstractmethods__=frozenset({"doSome","doOther"})#set(可变集合)与frozenset(不可变集合)
# a=AbsX()#这个会报错，因为有抽象方法
class XX(AbsX):
    def doOther(self):
        print("xx do other")

    def doSome(self):
        print("xx do some")

a=XX()
a.doOther()
a.doSome()

print("="*50+"6")
#===========================模仿ABCMeta============================
def abstract(func):
    func.__isabstract__=True
    return func

class MyABCMeta(type):
    def __new__(metaclz,clzname,parents,attrs):
        clz=super(metaclz,metaclz).__new__(metaclz,clzname,parents,attrs)

        print(attrs.items())

        for name, value in attrs.items():
            try:
                print(value,getattr(value,"__isabstract__"))
            except:
                pass
        #类中定义的抽象方法
        abstracts={name for name,value in attrs.items() if getattr(value,"__isabstract__",False)}

        #从父类中继承下来的抽象方法
        for p in parents:
            for name in getattr(p,"__abstractmethods__",set()):
                value=getattr(clz,name,None)
                if getattr(value,"__isabstract__",False):
                    abstracts.add(name)

        #指定给__abstractmethods__
        clz.__abstractmethods__=frozenset(abstracts)

        return clz

class AbsXX(metaclass=MyABCMeta):
    @abstract
    def doSome(self):
        pass

# x=AbsXX()

class XX(AbsXX):

    def doSome(self):
        print("xx do some")

a=XX()
a.doSome()
