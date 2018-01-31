#coding:utf-8
#循环语句
"""
for循环和while循环（在Python中没有do..while循环）:
循环类型	    描述
while 循环	在给定的判断条件为 true 时执行循环体，否则退出循环体。
for 循环	    重复执行语句
嵌套循环	    你可以在while循环体中嵌套for循环

"""
if True :
    print("you wro")
elif False:print("i win")
print("==========while==========")
count = 9
while (count < 9):
   print('The count is:', count)
   count = count + 1
   break
# else 中的语句会在循环正常执行完（即 for 不是通过 break 跳出而中断的）的情况下执行，while … else 也是一样。
else:print("Good bye,while!") #循环执行完后执行
print("==========for==========")
fruits = ["apple","banana","mango"]
for fruit in fruits:
    for x in fruit:
        print(x)
        break #结束一层循环
    print("this word is done")
else:print("bye for!")

#通过序列索引迭代
fruits = ['banana', 'apple', 'mango']
# print range(len(fruit))
for index in range(len(fruits)):#生成一个顺序序列
    print('当前水果 :', fruits[index])

print("Good bye!")

#pass 占位符
for x in "12 ":
    pass
    print("x")
else:print("finsh")
print("==========switch case==========")
def switcher(a):
    b={
        1:"one",
        2:"two"
    }
    return b.get(a)
print("case结果："+switcher(1))

list=[1,2,3,4,5,6,7,0,1]
sum = 0
var = [i for i in list if i != 1]
print(var)