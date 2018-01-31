#coding: utf-8
#Python程序语言指定任何非0和非空（null）值为true，0 或者 null为false。
if(0):
    print("1this is true")
elif(1):print("1this is false")
if True:
    print("2this is true")
else:
    print("2this is false")
if 3>2:print(3>2)
if True:print(True)
if(not None):print(None)
else: print("not suppot None")
'''# python 并不支持 switch 语句，所以多个条件判断，只能用 elif 来实现，如果判断需要多个条件需同时判断时，可以使用 or （或），
表示两个条件有一个成立时判断条件成功；使用 and （与）时，表示只有两个条件同时成立的情况下，判断条件才成功。 '''
def xiaoming(args):
    name = "xiaoming"
    age  = 18
    sex  = "boy"
    mathematicsScore = args
    if(mathematicsScore>=90):print("优秀")
    elif(mathematicsScore >=60 and mathematicsScore <=90):
        print("及格")
    elif(mathematicsScore < 60):print("补考")
xiaoming(60)
print("===========成员运算符=================")
'''
运算符	描述	实例 in and 的区别是in放回Bool，and成功返回最后一个，失败返回第一个失败的值

in	如果在指定的序列中找到值返回 True，否则返回 False。 	x 在 y 序列中 , 如果 x 在 y 序列中返回 True。
not in	如果在指定的序列中没有找到值返回 True，否则返回 False。 	x 不在 y 序列中 , 如果 x 不在 y 序列中返回 True。
'''
#测试字符串，列表或元组
a = 10
b = 20
list = [1, 2, 3, 4, 5 ];

if ( a in list ):
   print("1 - 变量 a 在给定的列表中 list 中")
else:
   print("1 - 变量 a 不在给定的列表中 list 中")

if ( b not in list ):
   print("2 - 变量 b 不在给定的列表中 list 中")
else:
   print("2 - 变量 b 在给定的列表中 list 中")

# 修改变量 a 的值
a = 2
if ( a in list ):
   print("3 - 变量 a 在给定的列表中 list 中")
else:
   print("3 - 变量 a 不在给定的列表中 list 中")
a = "2"
str1 = "1234"
if (a in str1):
    print("in")
else:
    print("not in")

tup =tuple("1234")
print("当前元祖为：",tup)
if (('1') in tup):
    print("in")
else:print("not in")
print("=============== 身份运算符===================")
"""
 身份运算符用于比较两个对象的存储单元
运算符	描述	实例
is是判断两个标识符是不是引用自一个对象	x is y, 
如果 id(x) 等于 id(y) , is 返回结果 1
is not是判断两个标识符是不是引用自不同对象	x is not y, 如果 id(x) 不等于 id(y). is not 返回结果 1

Python中的对象包含三要素：id、type、value。
id用来唯一标识一个对象，type标识对象的类型，value是对象的值。
"""

import copy
a = [1, 2, 3, 4, ['a', 'b']]  # 原始对象
b = a  # 赋值，传对象的引用
c = copy.copy(a)  # 对象拷贝，浅拷贝
d = copy.deepcopy(a)  # 对象拷贝，深拷贝,深层次的引用关系也会跟着拷贝
a.append(5)  # 修改对象a
a[4].append('c')  # 修改对象a中的['a', 'b']数组对象

print('a = ', a)
print('b = ', b)
print('c = ', c)
print('d = ', d)


a=1
b=copy.copy(a)
print("打印复制和原来的标识",id(a),id(b))
print(id(a)==id(b))
print(a is b)


str ="draw_person draw_prize draw_activity"
print(str.upper())
print((str.lower()))          # 把所有字符中的大写字母转换成小写字母
print((str.capitalize()))     # 把第一个字母转化为大写字母，其余小写
print((str.title()))          # 把每个单词的第一个字母转化为大写，其余小写

a = "aaa"
b = "aaa"
print(id(a),id(b))
if(id(a)==id(b)):
    print("有相同的标识")
else:print("not有相同的标识")
b = "bbb"
print(id(a),id(b))
print("=========20 20==============")

a = 20
b = 20
print(id(a),id(b))
if ( a is b ):
   print("1 - a 和 b 有相同的标识")
else:
   print("1 - a 和 b 没有相同的标识")

if ( id(a) is not id(b) ):
   print("2 - a 和 b 没有相同的标识")
else:
   print("2 - a 和 b 有相同的标识")

# 修改变量 b 的值
b = 30
if ( a is b ):
   print("3 - a 和 b 有相同的标识")
else:
   print("3 - a 和 b 没有相同的标识")

if ( a is not b ):
   print("4 - a 和 b 没有相同的标识")
else:
   print("4 - a 和 b 有相同的标识")

a = "0"
if a is not 0:
    print("fuck")
else:
    print("fuck too")
