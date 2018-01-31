#! /usr/bin/env python
# -*- coding: utf-8 -*-
import inspect

import os
from pprint import pprint


class Test(object):
    """Test Class doc"""

    def test(self):
        self.fuc = lambda x: x


class Testone(Test):
    pass


# 检查类型，模块，类，方法，生成器，代码等都可以
print(inspect.ismodule(os))
print(inspect.isclass(Test))

print(inspect.getdoc(Test))
print(inspect.getsourcefile(Test))  # 文件路径
print(inspect.getsourcelines(Test))  # 代码块，每行一个元素，组成数组

print(inspect.getsource(Test))  # 代码块 带缩进

print("="*50+"1")
#===========================================================
#
##打印全局变量中的模块对象
myglobals = {}
myglobals.update(globals())
modules = [value
           for key, value in myglobals.items()
           if inspect.ismodule(value)]
print(modules)

print("="*50+"2")
#===========================================================

##查看类的可调用方法
for name, value in inspect.getmembers(Test, callable):
    print("Callable:", name)

print("="*50+"3")
#===========================================================

for name, value in inspect.getmembers(Test(), callable):
    print("obj Callable:", name)

print("="*50+"4")
#===========================================================

def get_current_function_name():
    return inspect.stack()[1][3]
class MyClass:
    def function_one(self):
        pprint(inspect.stack())
        print()
        pprint(inspect.stack()[1])
        print()
        pprint(inspect.stack()[1][0])
        print("%s-------%s invoked"%(self.__class__.__name__, get_current_function_name()))
if __name__ == "__main__":
    myclass = MyClass()
    myclass.function_one()