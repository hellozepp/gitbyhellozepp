#coding=utf-8
from sys import argv

#����Ҫ��ȡ���ļ���
filename = input("Filename:")
#��ѹ
script, filename = argv, filename
#��������ļ�
txt = open (filename)
#����������ļ���
print("Here's your file %r:" % filename)
#�ļ�����
print(txt.read())
#�ٴζ�ȡ�ļ�����
print("Type the filename again:")
file_again = input("> ")
txt_again = open(file_again)
print(txt_again.read())
