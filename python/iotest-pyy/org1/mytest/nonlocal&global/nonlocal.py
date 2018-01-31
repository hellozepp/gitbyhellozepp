#!/usr/bin/env python
#--coding:utf-8--
x = 4
def test():
    global x
    x += 3
test()
print(x)#和里面的关联
print("--------------------------")
def test2():
    pass
    # nonlocal y
# SyntaxError: no binding for nonlocal 'y' found
# nonlocal主要用于修改外层函数的变量 py3

def test3():
    z = 3
    def test4():
        # print(z)#如果没使用nonlocal，z掉不了
        nonlocal z
        z+=1
        return z
    print(test4())
    print(test4())
    print(test4())
test3()
print("--------------------------")

def make_counter():
    count = 0

    def counter():
        nonlocal count
        count += 1
        return count

    return counter


def make_counter_test():
    mc = make_counter()
    print(mc())
    print(mc())
    print(mc())
make_counter_test()