#coding=utf-8
import random

mylist=[1,2,3,4,5]

for i in mylist:
    print(i,end=" ")

it=iter(mylist)
print(next(it))

for i in it:
    print(i,end=" ")

print()
print("===========================1=========================")
#=====================================

import sys

def mylistyield():
    for i in range(10):
        yield i

f=mylistyield()
for i in f:
    print(i,end=" ")

print()

#说明：yield from iterable本质上等于for item in iterable: yield item的缩写版
def mylistyield1():
        yield from range(10)

f=mylistyield1()
for i in f:
    print(i,end=" ")

print()
print("==========================2==========================")
# =====================================
# generator函数和普通函数的区别
# generator函数包含一个以上的yield声明
# generator函数被调用的时候，会返回一个iterator对象，但是函数并不会立即开始执行
# __iter__()和__next__()方法被自动实现，所以可以使用next()函数对返回的此iterator对象进行迭代
# 一旦一个generator 执行到yield语句，generator函数暂停，程序控制流被转移到调用方
# 在对generator的连续调用之间，generator的本地变量和状态会被保存
# 最终，generator函数终止，再调用generator会引发StopIteration异常

def myiteryield():
    print("第一次next")
    yield 1
    print("第二次next")
    yield 2
    print("第三次next")
    yield 3

def myret():
    print("不需要next")
    return 1

var=myret();
print(var)

print("-"*10)

list2 = myiteryield()
print(list2)
print(type(list2))

for l in list2:
    print(l)

print("-"*10)

for i in myiteryield():
    print(i)



print("====================================3=========================================")
# =====================================

def func(n):
    for i in range(0, n):
        print("*"*50)
        arg = yield i
        print('funcyield:', arg)


f = func(10)
i=100
while True:
    try:
        print('mainnext:', next(f))
        # send发送数据后进入了next状态，
        # 但是等到下一个yield到来的时候f.send返回值是yield的值，但是没有却没有东西可以send出去了
        # 所以相当与f.send(NULL)
        print('mainsend:', f.send(i))
        i+=1
        print("+"*50)
    except StopIteration as e:
        # e.with_traceback()
        break;


print("====================================4=========================================")
# =====================================


def product():
    while True:
        print("开始生产")
        data=random.randint(0,9)
        print("生产者生产了"+str(data))
        yield data

def consumer():
    while True:
        print("开始消费")
        data=yield
        print("消费了"+str(data))

def cleck(jobs,product,consumer):
    p=product()
    print("11111111111")
    c=consumer()
    print("22222222222222")
    next(c)
    print("3333333333")
    for i in range(jobs):
        data=next(p)
        print("44444444444:"+str(data))
        c.send(data)
        print("55555555555")

cleck(3,product,consumer)
