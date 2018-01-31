# coding= utf-8
# "本模块用于测试字符串数据类型特性 "
# 字符串的拼接
from filecmp import cmp
print("============类型转换=============")
# str int 相互转化
b = -3.1
b = str(b)
print(b)
b = str("-3.1")
print(b)

# int
# b=int(b) #
# b=int("3.1") #
b = int("-3")  # 只能转换整数
b = int(-3.6)  # 只保留整数位，不是舍五入
print(b)

# float
c = float(-3.06)
c = float("-3.06")
# c=float(a) #不能转化字符串

# bool
d = bool(True)
print(type(d))
if (d): print('ok')
str1 = """三个单引号（或三个双引号）也可以表示跨行字符串
1
2
3
over"""
print(str1)

# tuple
up1 = ('physics', 'chemistry', 1997, 2000);
tup2 = (1, 2, 3, 4, 5);
tup3 = "a", "b", "c", "d";
tup1 = (1,);  # 单值元组
print(tup1)
# 访问元组
tup1 = ('physics', 'chemistry', 1997, 2000);
tup2 = (1, 2, 3, 4, 5, 6, 7);
print("tup1[0]: ", tup1[0])
print("tup2[1:5]: ", tup2[1:5])
# tuple本身是不可变的
# tup1[0] = 100
# 创建一个新的元组

# list的值为可变
tup2 = ('abc', 'xyz', [1, 2, 3]);
list1 = [1, 2, 3]
list1[0] = 2
print("list1: " + str(list1))
tup2_1 = (1, 2, [3, 4])
tup2_1[2][1] = 1
print(tup2_1)

# 二维元祖
tup2_1 = (1, 2, (3, 4))
print("二维元祖：" + str(tup2_1))
print("tup2_1[2][1]:" + str(tup2_1[2][1]))

tup3 = tup1 + tup2;
print(tup3);
# 以上实例输出结果：
# (12, 34.56, 'abc', 'xyz')
# 删除元祖
tup = ('physics', 'chemistry', 1997, 2000);
print(tup);
del tup;
print("After deleting tup : ")
# print "'"+tup+"'";
# NameError: name 'tup' is not defined

# 列表的删除
list1 = [1, 2, 2, 3]
del list1[0]
list1.remove(2)  # 根据内容删除
# list1.remove(5)#报错
list1.pop()  # 弹栈

print("============替换=============")
# 1、replace替换
e = "1131,131"
e.replace("3", "1")
print(e)  # 改变了引用，但是需要赋值
f = e.replace("3", "1")
print(f)
print("============截取 分片 substring=============")  # 字符串切片 从0个开始
# 正向索引
# 反向索引
# 默认索引
str = '0123456789'
print(str[0:9])  # 截取第一位到第三位的字符 开区间
print(str[0:-1])#012345678
print(str[0:])  # all
print(str[:])  # 截取字符串的全部字符
print(str[6:])  # 截取第七个字符到结尾
print(str[:-3])  # 截取从头开始到倒数第三个字符之前
print("7:::", str[2])  # 截取第三个字符
print("8:::", str[-1])  # 截取倒数第一个字符
print("9:::", str[::-1])  # 创造一个与原字符串顺序相反的字符串
print("10:::", str[-3:-1])  # 截取倒数第三位与倒数第一位之前的字符
print("11:::", str[-3:])  # 截取倒数第三位到结尾
print("12:::", str[:-5:-3])  # 以3为步长，以从右向左的顺序，截取字符串末尾到倒数第5位（不包含倒数第5位）的字符并输出。
str = '6,148,72,35,0,33.6,0.627,50,1'
print("1::::", str)
print("2::::", str[-1])
print("3::::", str[:1])
print("4::::", str[:0])
print("5::::", str[:-1])
print("6::::", str[-1:])
print("6::::", str[::])

L = ['Michael', 'Sarah', 'Tracy', 'Bob', 'Jack']
print(L)
print(L[-2:])
print(L[-2:-1])
# from __future__ import print_function python2支持
print("按分隔符打印")
print('Michael', 'Sarah', 'Tracy', 'Bob', 'Jack', sep='/')
print("============查找字符charAt=============")
# strchr(sStr1,sStr2)
# < 0 为未找到
sStr1 = 'strchr'
sStr2 = 's'
nPos = sStr1.index(sStr2)
print(nPos)
# find 和index的区别：不存在时一个-1 一个报错
aaa = "a,c,x,d1d2d3"
bbb = "有钱不赚非君子"
# 计算，个数
print("a.count", aaa.count(","))
# 找出3在d1d2d3的位置
aaa = aaa.find('3', aaa.find("d1d2d3")) + 1
print("aaa:", aaa)
# 找出bbb中"钱"的位置

bbb = bbb.find("钱")
print("find(钱)", bbb)
print("============比较字符串=============")
a = 'strchrstrch'
b = 'strch'
c = 'str'
c = c+'ch'
print(c==b)
print(c is b)

import operator
print(operator.lt(a, b))
print(operator.gt(a, b))
print(operator.le(a, b))
print(operator.le(a, b))
print(operator.eq(a, b))
print(operator.ne(a, b))

print("============扫描字符串是否包含指定的字符=============")
print(len(sStr1 and sStr2))
print(len(sStr1))  # 长度
print("============将字符串中的大小写转换=============")
# strlwr(sStr1)
sStr1 = 'JCstrlwr'
# sStr1 = sStr1.upper()
sStr1 = sStr1.lower()
print(sStr1)
print("============追加指定长度的字符串=============")
# strncat(sStr1,sStr2,n)
# 1 相加，会生成新的str对象
sStr1 = '12345'
sStr2 = 'abcdef'
n = 3
sStr1 += sStr2[0:n]
print(sStr1)
# print sStr1.append("aaa") #str没有apppend方法
print("============扫描字符串=============")

# strpbrk(sStr1,sStr2)
sStr1 = 'cekjgdklab'
sStr2 = 'gka'
nPos = -1
#找到a中任意一个属于a的字符
for c in sStr1:
    if c in sStr2:
        nPos = sStr1.index(c)
        break
print(nPos)
print("============查找=============")
# strstr(sStr1,sStr2)
sStr1 = 'abcdefg'
sStr2 = 'cde'
print(sStr1.find(sStr2))  # 返回值为起始位置
print("============分割=============")
# strtok(sStr1,sStr2)
sStr1 = 'ab,cde,fgh,ijk'
sStr2 = ','
print(sStr1[0:sStr1.find(sStr2)])
sStr1 = sStr1[sStr1.find(sStr2) + 1:]  # 按照 ，来分割sStr1
print(sStr1)
# 或者
s = 'ab,cde,fgh,ijk'
print((s.split(',')))

import re

a = 'Beautiful, is; better*than\nugly'
# 四个分隔符为：,  ;  *  \n
x = re.split(',|; |\*|\n', a)
print(x)
print("============连接字符串=============")
delimiter = ','  # 分隔符
mylist = ['Brazil', 'Russia', 'India', 'China']
print(delimiter.join(mylist))
print("============定义字典=============")
a = "1+1= %(num1)s ,2+2 = %(num2)s" % {'num1': '2', 'num2': '4'}
print(a)

print("============转义字符=============")
"""
\(在行尾时) 	续行符
\\ 	反斜杠符号
\' 	单引号
\" 	双引号
\a 	响铃
\b 	退格(Backspace)
\e 	转义
\000 	空
\n 	换行
\v 	纵向制表符
\t 	横向制表符
\r 	回车
\f 	换页"""
# \xyy 	十六进制数，yy代表的字符，例如：\x0a代表换行
# \oyy 	八进制数，yy代表的字符，例如：\o12代表换行
#
# \other 	其它的字符以普通格式输出

print("it will test the " \
      "转义字符" \
      "      响铃\a" \
      "      abcd\b \e1\0002\n")
# raw_input("即将换页>")
print("\f")
print("换页完成")
print("============toCharArray=============")
str = 'abcde'
list = list(str)
print(list)
str_convert = ','.join(list)
print(str_convert)
print("============trim=============")
str = "0000000this is string example....wow!!!0000000";
print(str.strip('0'));

import random

# 生成随机数
print("生成随机数")
print(random.uniform(10, 20)) #16.977825775662076
print(random.uniform(20, 10))  # 没区别
# 生成随机整数
print(random.randint(12, 20))  # 生成的随机数n: 12 <= n <= 20
print(random.randint(20, 20))  # 结果永远是20
# print random.randint(20, 10) #该语句是错误的。
# 随机选取0到100间的偶数：
random.randrange(0, 101, 2)
# 随机字符：
random.choice('abcdefg&#%^*f')
# 多个字符中选取特定数量的字符：
print(random.sample('abcdefghij', 3))
# 多个字符中选取特定数量的字符组成新字符串：
#方法过时
# import string
# str = string.join(random.sample(['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'], 3)) \
#     .replace(" ", "")
print("join结果=========", str)
ten_things = "Apples Oranges Crows Telephone Light Sugar"

stuff = ten_things.split(' ', 3)  # Python split()通过指定分隔符对字符串进行切片，如果参数num 有指定值，则仅分隔 num 个子字符串,后面保留为一个
print("分割的字符串为：%r" % stuff)
print(stuff)
print("生成一个新的字符串。", '呵呵呵呵呵呵'.join(stuff))
print("haha".join("xixi"))

# 洗牌：
print("洗牌")
import random

items = [1, 2, 3, 4, 5, 6]
print(random.shuffle(items))
print(items)  # 坑，洗牌没返回值
list = [20, 16, 10, 5]
random.shuffle(list)
print("随机排序列表 : ", list)

# ==============range================
print("==============range================")
# 列表常用操作
li = [1, 2, 3, 4, 5, 6]  # 创建列表
print(li.__len__())
print(len(li))
print("操作数为：", 1, 2, 3, 4, 5, 6)
# 切片
print(li[1:5])  # 结束开区间
print("迭代列表操作：")
li[-2] = 2
for x in li:
    print(x, sep=' ',end=" ")#结束符为空格
print("(done)")
print(":-1===", li[:-1])  # 结束开区间
print(li[0:])
print("两个[::]：：", li[::2])  # 跳一个
print(li[2::])  # 开始跳两下，其他不跳
print(li[::-2])  # 倒着跳一个
print(li[-2::])  # 只保留最后两个
print(li)
print(len(li))
print(li[4:2:-1])
print(li[4::-1])
print("在列表末尾添加新的对象")
li.append(7)
print(li[0:])
# 一次性追加另一个序列中的多个值
li.extend(li)
print(li)
