# 位置参数
print("{0} is {1} years old".format("Wilber", 28))
print("{} is {} years old".format("Wilber", 28))
print("Hi, {0}! {0} is {1} years old".format("Wilber", 28))

# 关键字参数
print("{name} is {age} years old".format(name="Wilber", age=28))

# 下标参数
li = ["Wilber", 28]
print("{0[0]} is {0[1]} years old".format(li))

# 填充与对齐
# ^、<、>分别是居中、左对齐、右对齐，后面带宽度
# :号后面带填充的字符，只能是一个字符，不指定的话默认是用空格填充
print('{:>8}'.format('3.14'))
print('{:<8}'.format('3.14'))
print('{:^8}'.format('3.14'))
print('{:0>8}'.format('3.14'))
print('{:a>8}'.format('3.14'))

# 浮点数精度
print('{:.4f}'.format(3.1415926))
print('{:0>10.4f}'.format(3.1415926))

# 进制
# b、d、o、x分别是二进制、十进制、八进制、十六进制
print('{:b}'.format(11))
print('{:d}'.format(11))
print('{:o}'.format(11))
print('{:x}'.format(11))
print('{:#x}'.format(11))
print('{:#X}'.format(11))

# 千位分隔符
print('{:,}'.format(15700000000))
print("-------------------------")
# 它通过{}和:来代替%。/
import functools
print("============字符串的拼接=============")
a = "hello world !"
print('1' + a)
a = "hello %s %d" % (1, 2)
print('2' + a)
print("hello {} {}".format("num1","num2"))
#py2会 print a #报错 找不到占位符位置
a = "hello {1} {0}".format("num1", "num2")
print('4' + a)  # 4hello num2 num2
a = "hello {value1} {value2}".format(value2="num2", value1="num1")
print('5' + a)

c = ",".join(["1", "2"])
print(c)
# 字符串的转换
a = 3
b = 3.3
c = "ccccccc"
li = [1, 2, 3]
print("=====通过位置==========")
fmt = "{0},,,{1}".format(12, 3)
print(fmt)

print("打散-----字符串打散")
c = list("1234")
print(c)
print("打散-----字符串组合")
c = functools.reduce(lambda x, y: x + y, c, "`asdfasdf")#跟前缀
type(c)
print(type(c))
print(c)
print("打散-----字符串打散成数字")

c = input("输入字符串序列>")
c = c.split(" ")
print(c)
c = [int(c[x]) for x in range(len(c))]
print(c)
print("打散-----整形列表转字符串")
list = [1, 2, 3, 4]
list = [str(list[x]) for x in range(len(list))]
print(list)
# list = functools.reduce(lambda x,y:x+y ,list)
# print(list)
# 或
list = "".join(list)
print(list)
print("字符串转数字列表")
str = "6,148,72,35,0,33.6,0.627,50,1"
str = eval("[" + str + "]")
type(str)
print(str)
#格式化字符串
string = "Hello\tWill\n"
print("%s" % string)#Hello	Will
print("%r" % string)#'Hello\tWill\n'

num = 100

print("%d to hex is %x" % (num, num))
print("%d to hex is %X" % (num, num))
print("%d to hex is %#x" % (num, num))
print("%d to hex is %#X" % (num, num))

# 浮点数
f = 3.1415926
print("value of f is: %.4f" % f)

# 指定宽度和对齐
students = [{"name":"Wilber", "age":27}, {"name":"Will", "age":28}, {"name":"June", "age":27}]
print("name: %10s, age: %10d" % (students[0]["name"], students[0]["age"]))
print("name: %-10s, age: %-10d" % (students[1]["name"], students[1]["age"]))
print("name: %*s, age: %0*d" % (10, students[2]["name"], 10, students[2]["age"]))

# dict参数
for student in students:
    print("%(name)s is %(age)d years old" % student)

#字符串模板 old==format
from string import Template
s = Template("Hi, $name! $name is learning $language") #通过%key访问字典
print(s.substitute(name="aa",language="cc"))


