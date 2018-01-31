#coding= utf-8
#Python Number(数字)
# python包含 6 中内建的序列，包括列表、元组、字符串、Unicode字符串、buffer对象和xrange对象。
a = 3
del a
# print a
# NameError: name 'a' is not defined
print(int(3.123))
print(int(3.5))
print(2/3)
"""
Python Number 类型转换

int(x [,base ])         将x转换为一个整数
long(x [,base ])        将x转换为一个长整数
float(x )               将x转换到一个浮点数
complex(real [,imag ])  创建一个复数
str(x )                 将对象 x 转换为字符串
repr(x )                将对象 x 转换为表达式字符串,相当于'%r'
eval(str )              用来计算在字符串中的有效Python表达式,并返回一个对象
tuple(s )               将序列 s 转换为一个元组
list(s )                将序列 s 转换为一个列表
chr(x )                 将一个整数转换为一个字符
unichr(x )              将一个整数转换为Unicode字符
ord(x )                 将一个字符转换为它的整数值
hex(x )                 将一个整数转换为一个十六进制字符串
oct(x )                 将一个整数转换为一个八进制字符串
exec("print("hello zepp")\) 执行py
"""
#==============================
obj='I love Python'
obj==eval(repr(obj)) # 任意类型转 规格化string
#obj==eval(str(obj)) #报错

repr([0,1,2,3])
'[0,1,2,3]'
print(repr((0,"0")))
"(0, '0')"
repr('Hello')
"'Hello'"

str(1.0/7.0)
'0.142857142857'
repr(1.0/7.0)
'0.14285714285714285'
#==============================
x=3
print(repr(x==1))
print(repr(x+1))
print(repr("a\nb"))
print(str("a\nb"))
print(eval("1+3*4-6"))
print(eval("x==3"))
print("3>2",3>2)
# print eval("n==3")#报错
# 字符串转换成列表
a = "[[1,2], [3,4], [5,6], [7,8], [9,0]]"
print(type(a)) #a的类型
b=eval(a)
print(type(b)) #a的类型
#################################################
print("字符串转换成字典")
a = "{1: 'a', 2: 'b'}"
print(type(a))
b = eval(a)#<type 'dict'>
print(b)
print(type(b))#dict
#################################################
# 通过exec可以执行动态Python代码，类似Javascript的eval功能
# eval函数可以计算Python表达式
exec("print( \"hello zepp\")")
cc=1
exec ("cc = 2")
print(cc)
#################################################
from decimal import *
getcontext().prec = 6
print(Decimal(2)/Decimal(3))
print(Decimal(1.1)+Decimal(1.1))

print(str(Decimal('3.40').quantize(Decimal('1.00'))))
print(str(Decimal('3.40')))
print(str(Decimal('3.40')/Decimal('1')))
# print(Decimal(1) /1000/1.2 / 10000)
print(str(Decimal('0.00000174418873795').quantize(Decimal('1.00'))))
res =Decimal('300.00')
print(type(res))
print(res)
####################float#########################
a= (float(1.3) / float(2.3) )
print(float('%.2f' % a))

