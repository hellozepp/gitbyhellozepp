#!/usr/bin/python3

#coding=utf-8

from ctypes import *
import os
# 参数为生成的.so文件所在的绝对路径
libtest = cdll.LoadLibrary(os.getcwd() + "/sotest.so")
# 直接用方法名进行调用
str=libtest.display("aaa".encode())
print(str)
rst = string_at(str, -1)
print("---:"+rst.decode("utf-8"))

print()

display = libtest.display
display.argtypes = [POINTER(c_char)] # 参数类型，为char指针
display.restype = c_char_p # 返回类型，同样为char指针
res = display("aaa".encode())
print(res)
print(libtest.add(2,10))