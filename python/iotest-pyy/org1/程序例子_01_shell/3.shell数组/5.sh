#!/bin/bash
#数组

#定义数组
array_name=(1 2 3 4)
array_name[0]=5

echo ${array_name[0]}
#使用@符号可以获取数组中的所有元素
echo ${array_name[@]}

#取得数组元素的个数
echo ${#array_name[@]}
echo ${#array_name[*]}
# 取得数组单个元素的长度
str=("abc" "defgh")
echo ${#str[1]}
