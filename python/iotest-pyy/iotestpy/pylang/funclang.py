#coding=utf-8

def add(i,j=100):
    print("i="+str(i))
    print("j="+str(j))
    return i+j

print(add(1,2))
print(add(j=1,i=2))
print(add(i=1))


print("========================2============================")
#=====================================

sum=lambda i,j:[i+j,print(i),print(j),{i,j}]

print(sum(1,2))
#id看内存位置
#type看反射的类
print("========================3============================")
#=====================================
total=0
def sum(i,j):
    total=i+j
    print(total)#闭包不改变调用值
sum(1,2)
print(total)

print("=========================4===========================")
#=====================================
def sum(i,j):
    return i+j
def sub(i,j):
    return i-j
def opt(f,i,j):
    return f(i,j)

print(opt(sum,1,2))
print(opt(sub,1,2))

print("=========================5===========================")
#=====================================

def outer():
    num=10
    def inner():
        nonlocal num
        num=100
        print(num)
    inner()
    print(num)

outer()

print("========================6============================")
#=====================================

num=10
def fun():
    global num
    num=100
    print(num)
fun()
print(num)

print("==========================7==========================")
#=====================================

def sum(*num):
    totle=0
    for i in num:
        totle+=i
    return totle

print(sum(1,2,3,4,5))

print("===========================8=========================")
#=====================================

def returndict(**kvs):
    return {"name":kvs.get("name","xiaoming"),"age":kvs.get("age",0)}

res=returndict(age="bbb")
print(res)

print("===========================9=========================")
#=====================================
def some(*arg1,**arg2):
    print(arg1)
    print(arg2)

some(1,2,3,{"a":"b"},hehe=3,xixi="5")
some(a=1,b=2,c=3)
some(1,2,3,a=4,b=5,c=6)

print("===========================10=========================")
#=====================================
def fun():
    def xxx():
        return "hello"
    return xxx
print(fun()())

def fun():
    return lambda :print("hello")
fun()()

""" 
三种编译环境 cpython pypy cson jPython
pypy jit的编译
cpython jit解释
"""
