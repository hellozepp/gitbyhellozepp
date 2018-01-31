#!/bin/bash
#字符串

#单引号
#1)单引号里的任何字符都会原样输出；
#2)单引号字串中不能出现单引号（对单引号使用转义符后也不行）。
str='this is a string'

#双引号
#1)被双引号括住的内容，将被视为字符串。它防止通配符扩展，但允许变量扩展（这点与单引数的处理方式不同）。
#2)双引号里可以出现转义字符
your_name='qinjx'
str="Hello, I know your are \"$your_name\"! \n"
echo $str

echo "#拼接字符串"
your_name="qinjx"
greeting_1="hello, ${your_name} !"
greeting="hello, "$your_name" !"
echo $greeting $greeting_1

#获取字符串长度
string="abcd"
echo ${#string}                 #输出 4

#提取子字符串
string="alibaba is a great company"
echo ${string:1:4}              #注意：下标从0开始计算 闭区间

#反引号，将命令内容执行返回
echo $(pwd)
echo `pwd`

