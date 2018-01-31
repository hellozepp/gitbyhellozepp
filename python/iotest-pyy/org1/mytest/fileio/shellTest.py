#coding:utf-8
import os

if __name__ == '__main__':
   os.system("ls") #返回0 1
   print("-----------------ok1")
   a = os.popen('help').read().split("\n")
   for s in a:
       print(s)
       print("-----------------ok2")
