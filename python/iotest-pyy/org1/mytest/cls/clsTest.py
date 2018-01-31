class cls(object):
    def __new__(clazz):
        print("new %s"%clazz)
        return  object.__new__(clazz)
    def __init__(self):
        self.a = 0
        self.b = 1
        self.c = set([])
        self.name = ""
    def __str__(self):
        return "a->"+str(self.a)+"; b->"+str(self.b)+"; set->"+str(self.c)+"; name->"+self.name

c1 = cls()
c2 = cls()
c3 = cls()
c1.a+=100
c2.a+=99
c3.c.add("aaa")
cls.name="小张"
print(c1)
print(c2)
print(c3)

#错误
print("*"*12)
class cls:
    a = 0
    b= 1
    c = set([])
    name = ""

    def __str__(self):
        return "a->"+str(self.a)+"; b->"+str(self.b)+"; set->"+str(self.c)+"; name->"+self.name

c1 = cls()
c2 = cls()
c3 = cls()
c1.a+=100
c1.a+=100
c2.a+=99
c3.c.add("aaa")
cls.name = "小张"
c3.name = "xiaoming"
print(c1)
print(c2)
print(c3)