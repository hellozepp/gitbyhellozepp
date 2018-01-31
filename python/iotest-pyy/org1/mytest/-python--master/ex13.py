#coding:utf-8
from sys import argv
#argv 获取绝对路径
first = input("Name: ")
second = input("Name: ")
third = input("Name: ")

script, first, second, third = argv, first, second, third

print("Your first variable is:", first)
print("The script is called: ", script)
#The script is called:  ['/opt/projects/python/pydemo/-python--master/ex13.py']
print("Your second variable is:", second)
print("Your third variable is:", third)
