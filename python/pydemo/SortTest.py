#coding= utf-8
#range创建列表 用法
a = range(0,2)#代表从0到2(不包括2)
print a
print range(1,5,2) #代表从1到5，间隔2(不包含5)
# [1, 3]
print range(5) #代表从0到5(不包含5)
# [0, 1, 2, 3, 4]
print range(0,8,-1)
print range(8,0,-1)
#冒泡
array = [1, 2, 5, 3, 6, 8, 4]
print range(len(array)-1,0,-1) #不包括0
for i in range(len(array) - 1, 0, -1):
    print i
    for j in range(0, i):
        print j
        if array[j] > array[j + 1]:
            array[j], array[j + 1] = array[j + 1], array[j]
print array



#列表
print "===========列表表达式==============="
#格式：表达式 for 变量 in 迭代器
list1=[x for x in range(1,11)]
print list1
#生成奇数列表
print [x for x in range(1,11) if x %2==1]

#排序
a =[1,6,2,6,1,10]
b=[1,6,2,6,1,10]
a.sort()
b.reverse()
print a
print b


print "===========列表三种追加==============="
'''
1. 列表可包含任何数据类型的元素，单个列表中的元素无须全为同一类型。

2.  append() 方法向列表的尾部添加一个新的元素。只接受一个参数。

3.  extend()方法只接受一个列表作为参数，并将该参数的每个元素都添加到原有的列表中。
'''
#1 相加
list1 =[1,"2",a]
list2 = [6,]
list1=list1+list2
print list1
#2 extend
list1 = [1,2,3]
list2 = [3,5,6]
list1.extend(list2)
print list1
list1.extend("aaa")#自动转化成列表
#[1, 2, 3, 3, 5, 6, 'a', 'a', 'a']
list1.extend([1,2])
# list1.extend(-1.35) #TypeError: 'float' object is not iterable
# list1.extend(134)
print list1

#3 append
print list1.append(1)
print list1
list1.append([1,2,3])
print list1
# list1.append(1,2) #不支持多个数
# print list1