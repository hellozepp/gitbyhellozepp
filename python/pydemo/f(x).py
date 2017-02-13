#coding: utf-8
#函数在被调用修改引用会同时修改外部该属性的引用值

# 可写函数说明
def changeme(mylist):
    "修改传入的列表"
    mylist.append([1, 2, 3, 4]);
    print "函数内取值: ", mylist
    return
# 调用changeme函数
mylist = [10, 20, 30];
changeme(mylist);
print "函数外取值: ", mylist

#参数名可以不一致
# 可写函数说明
def printme(str):
    "打印任何传入的字符串"
    print str;
    return;


# 调用printme函数
printme(str="My string");

print "=============匿名函数========="
#lambda 匿名函数
# 虽然lambda函数看起来只能写一行，却不等同于C或C++的内联函数，后者的目的是调用小函数时不占用栈内存从而增加运行效率
sum = lambda arg1, arg2 : arg1 + arg2
sub = lambda arg1, arg2 : arg1 - arg2
multi = lambda arg1 , arg2 : arg1 * arg2
div = lambda arg1 , arg2 :arg1 / arg2
print sum(3,5), sub(3,5), multi(3,5), div(3,5)


print "===========返回值=============="
#返回值：return语句[表达式]退出函数，选择性地向调用方返回一个表达式。不带参数值的return语句返回None。
print ("----- 返回值测试：----".decode("utf-8"), "haha")
print ("----- 返回值测试：----".decode("utf-8")+ "haha")

def xiaozhang(*args):
    arg1,arg2,arg3 = args
    sum = arg1 +arg2 +arg3
    return sum
return1  = xiaozhang(1,2,3)
print (return1)

#全局变量
Money = 2000
def AddMoney():
    # 想改正代码就取消以下注释:
    # global Money
    # Money = Money + 1 #error
    Money = 1
    print Money
AddMoney()
print Money

#内置模块
print("内置模块")
# 导入内置math模块 返回的列表容纳了在一个模块里定义的所有模块，变量和函数。
import math

content = dir(math)

print content;

# try/except
try:
    fh = open("testfile", "w")
    fh.write("这是一个测试文件，用于测试异常!!")

except IOError:#1.可以不写异常类型 2.可以接受多个类型
    print "Error: 没有找到文件或读取文件失败"

else:
    print "内容写入文件成功"
    fh.close()
finally:
        print "关闭文件"
        fh.close()



#调取异常参数
def temp_convert(var):
    try:
        return int(var)
    except ValueError, Argument:
        print "参数没有包含数字\n", Argument

# 调用函数
temp_convert("xyz");


#自己触发异常
def functionName( level ):
    if level < 1:
        raise Exception("Invalid level!", level)
        # 触发异常后，后面的代码就不会再执行


#自定义异常类
class Networkerror(RuntimeError):
    def __init__(self, arg):
        self.args = arg
try:
    raise Networkerror("Bad hostname")
except Networkerror, e:
    print e.args