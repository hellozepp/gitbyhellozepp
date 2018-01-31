print("经典类继承按·深度有限")

class D:

    def bar(self):
        print('D.bar')


class C(D):

    def bar(self):
        print('C.bar')


class B(D):

    pass


class A(B, C):

    pass

a = A()
# 执行bar方法时
# 首先去A类中查找，如果A类中没有，则继续去B类中找，如果B类中么有，则继续去D类中找，如果D类中么有，则继续去C类中找，如果还是未找到，则报错
# 所以，查找顺序：A --> B --> D --> C
# 在上述查找bar方法的过程中，一旦找到，则寻找过程立即中断，便不会再继续找了
a.bar()


print("新类继承按·广度优先")
class D(object):
    def __init__(self):
        print("D")
    def bar(self):
        print('D.bar')
class C(D):
    def __init__(self):
        print("c")
class B(D):
    def __init__(self):
        print("B")
class A(B,C):
    def __init__(self):
        print("A")
a = A()
a.bar()
print("知呼例子")
class A():
    def __init__(self):
        pass
    def save(self):
        print("This is from A")
class B(A):
    def __init__(self):
        pass
class C(A):
    def __init__(self):
        pass
    def save(self):
        print("This is from C")
class D(B,C):
    def __init__(self):
        pass
fun =  D()
fun.save()
# 经典类的答案： This is from A
# 新式类的答案： This is from C