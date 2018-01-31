# 就是为了用的时候方便好记。
import simplejson as json

class a:
    def __init__(self):
        pass
import sys
sys.stdout.write(type(a))
# isinstance()可以告诉我们，一个对象是否是某种类型（包括继承关系）。
class A():
    pass
class B(A):
    pass
class C(B):
    pass

a=A()
b=B()
c=C()

print(isinstance(c, C))
print(isinstance(c, B))
print(isinstance(c, A))
print(isinstance(a, C))
print(isinstance(b, C))
# 如果要获得一个对象的所有属性和方法，可以使用dir()函数，它返回一个包含字符串的list，比如，获得一个str对象的所有属性和方法：
print(dir('ABC'))



class MyObject:
    z=100
    def __len1__(self1):
        return 100
    def x(self1):
        print("this is x")

obj = MyObject()
print(len(obj))
if(hasattr(obj, 'x')): #有木有属性'x'
    obj.x()
    if (hasattr(obj, 'z')):  # 有木有属性'z'
        print("有木有属性'z'",obj.z)
print(getattr(obj, 'z', 'N/A'))
print(getattr(obj, 'y', 404))

class Student(object):
    name = 'Student'

s= Student()
s.name = 'Michael'
print(s.name) # 由于实例属性优先级比类属性高，因此，它会屏蔽掉类的name属性
print(Student.name)
del s.name
print(s.name)
# 导入模块时，是按照sys.path变量的值搜索模块，sys.path的值是包含每一个独立路径的列表，
# 包含当前目录、python安装目录、PYTHONPATH环境变量，搜索顺序按照路径在列表中的顺序（一般当前目录优先级最高）
import sys
print(sys.path)