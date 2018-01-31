#!/bin/bash
#运算符和表达式

#let
var=1
let "var+=1"
echo $var

#(())  (())的使用方法与let完全相同
var=1
((var+=1))
echo $var

#$[]
var=1
var=$[$var+1]
echo $var        #输出2

#expr
var=1
var=`expr $var + 1`
echo $var

#bc(可以进行浮点数计算)
var=1
var=`echo "$var+1"|bc`
echo $var

var=3.14
var=`echo "$var*3"|bc`
echo $var

#awk(可以进行浮点数计算)
#1)awk支持除微操作运算符之外的所有运算符
#2)awk内置有log、sqr、cos、sin等等函数
var=1
var=`echo "$var 1"|awk '{printf("%g",$1*$2)}'`
echo $var

var=3.14
var=`echo "$var 2"|awk '{printf("%g",sin($1/$2))}'`
echo $var

#===============================================

#运算符
#算术运算符(+、-、*、/) 
#按位运算符(~、<<、>>、&、|、^) 
#逻辑运算符(&&、||、 > 、== 、<、!=) 
#赋值运算符(=、+=、-=、*=、/=、%=、&=、^=、|=、<<=、>>=)

#表达式
echo "#$[]：可以接受不同基数的数字的表达式"
echo $[10+1] #（输出：11）
echo "$[2+3],$HOME" #（输出：5,/root）
echo $[2<<3],$[8>>1] #（输出：16,4） 
echo $[2>3],$[3>2] #（输出：0,1 表达式为false时输出0，为true时输出1）

#字符表达式
#字符表达式：直接书写，采用单引号，双引号引起来。 
echo " $HOME，That is your root directory." 
echo ' $HOME，That is your root directory. '


