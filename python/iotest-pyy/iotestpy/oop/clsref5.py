#!/usr/bin/env python
# -*- coding: utf-8 -*-

#===========eval===============================

x = 7
print(eval( '3 * x' ))

print("="*50+"1")
#===========exec===============================
# 单行语句字符串
exec("print('Hello world')")

#  多行语句字符串
exec(
"""
for i in range(5):
       print(i)
""")


print("="*50+"2")
#===========可求值表达式=========================
# compile的三个参数都是必需的，第一参数代表了要编译的Python代码。
# 第二个参数通常被置为空串，该参数代表了存放代码对象的文件的名字(字符串类型)。
# 最后的参数是个字符串，用来表明代码的类型。有三个可能值：
# 'eval'	可求值的表达式[和eval()一起使用]
# 'single'	单一可执行语句[和exec一起使用]
# 'exec'	可执行与剧组[和exec一起使用]
eval_code = compile('10-2','','eval')
print(eval(eval_code))

single_code = compile('print("Hello world")','','single')
exec(single_code)

exec_code = compile("""
req = int(input('请输入一个数：'))
for i in range(req):
    print(i)
""",'','exec')
exec(exec_code)

print("="*50+"3")
#===========执行文件=========================

f = open('__init__.py') # open the file
arr=f.readlines()
exec("\n".join(arr))



print("="*50+"4")
#===========执行文件=========================
a=1
exec(
"""
a=1999
""")
print(a)



