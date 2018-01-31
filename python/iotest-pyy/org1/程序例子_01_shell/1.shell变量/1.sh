#!/bin/bash
#变量和引用--本地变量

#对变量赋值：
a="hello world"
# 现在打印变量a的内容：
echo "A is:"
echo $a             #echo ${a}与之结果相同
echo ${a}

#================================================

#使用花括号避免变量名与其他文字混淆
num=2
echo "this is the $numnd"
echo "this is the ${num}nd" #注意括号的位置
echo 'this is the ${num}nd'


#================================================
echo "=================数学运算==============="
#let表示数学运算
#expr用于整数值运算，每一项用空格隔开
#$[]将中括号内的表达式作为数学运算先计算结果再输出。

var=1
var=$var+1
echo $var

var=1
let "var+=1"
echo $var

var=1
var=$[ $var + 1 ]
echo $var 
echo '-------expr--------'
var=1  
var=`expr $var+1.5`     #注意加号两边的空格，否则还是按照字符串的方式赋值。
echo $var

var=1  
var=`expr $var+ 1`
echo $var
echo 'echo $var 1' $var 1

#==============================================
#显示本地变量
#set
#清除本地变量
echo '清除本地变量'
unset var
echo $var

