#coding: utf-8
#将 读取文件 和 写入文件 写成一行
open("ex17(3)_sample.txt", "a").write(open("ex17(3).py", "r").read())
#没法写close了
