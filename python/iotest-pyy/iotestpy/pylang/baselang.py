#!/usr/bin/python3

#coding=utf-8

#这是个注释

print('''
这个是doc\n''')
print("""
这个是doc\n""")
'''
这个是多行注释\n
'''
import json
from pprint import pprint

"""
这个是多行注释 \n
"""

pprint(str.__dict__)
print("这个是不换行的",end=" ")
print("helloworld!! %s" %12)


from iotestpy.pylang.str import aaa
# aaa.fun() #不掉也会打finish

# from iotestpyy.pylang.pkg import hello
# print("+++++: "+hello.xxx())
#
# import pylang.pkg.hello
# print("+++++: "+iotestpy.pylang.pkg.hello.xxx())
import json
a = {'name': 'wang', 'age': 29}
print(json.dumps(a),type(a))

import keyword
print(keyword.kwlist)
# pretty print
pprint(keyword.kwlist)


name=input("请输入姓名: ")
print("您的输入是: "+name)

import sys

from sys import path

pprint(path)
print(r"aaa\nbbb")#转义字符失效
print(R"aaa\nbbb")

print(u"我")#Unicode java、python3、go |ascii Python2、c =》基本码   我
print(U"我".encode("utf-8"))#b'\xe6\x88\x91'

print(b"abc".decode("utf-8"))#byte new String()


sys.exit(100)