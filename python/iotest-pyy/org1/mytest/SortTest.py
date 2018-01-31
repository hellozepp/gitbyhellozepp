#coding= utf-8
#range创建列表 用法
a = list(range(0,2))#代表从0到2(不包括2)
print(a)
print(list(range(1,5,2))) #代表从1到5，间隔2(不包含5)
# [1, 3]
print(list(range(5))) #代表从0到5(不包含5)
# [0, 1, 2, 3, 4]
print(list(range(0,8,-1)))#[]
print(list(range(8,0,-1)))#[8, 7, 6, 5, 4, 3, 2, 1] #不包括0 range开区间
print(list(range(8,0)))#[]
#冒泡
array = [1, 2, 5, 3, 6, 8, 4]
print(list(range(len(array)-1,0,-1))) # [6, 5, 4, 3, 2, 1]
print("--------------------")
for i in range(len(array) - 1, 0, -1):
    for j in range(0, i):
        if array[j] > array[j + 1]:
            array[j], array[j + 1] = array[j + 1], array[j]
print(array)

#列表
print("===========列表表达式===============")
#格式：表达式 for 变量 in 迭代器
list1=[x for x in range(1,11)]
print(list1)
#生成奇数列表
print([x for x in range(1,11) if x %2==1])

#排序
a =[1,6,2,6,1,10]
b=[1,6,2,6,1,10]
a.sort()
b.reverse()
print(a)
print(b)