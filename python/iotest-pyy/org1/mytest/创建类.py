class TheThing(object):
    def __init__(self):
        self.number = 0
    def some_function(self):
        print("I got called.")
    def add_me_up(self, more):
        self.number += more
        return self.number
a = TheThing()
b = TheThing()

a.some_function()
b.some_function()

print(a.add_me_up(20))
print(a.add_me_up(20))
print(b.add_me_up(30))
print(b.add_me_up(30))

print(a.number)
print(b.number)

'''
class 创建过程：
1.先创建一个 class ，格式为 "class 函数名（object)"
2.然后定义一个主体函数"__init__",设置函数需要的参数(self)
3.定义需要用到的其他函数，参数，和命令

'''
