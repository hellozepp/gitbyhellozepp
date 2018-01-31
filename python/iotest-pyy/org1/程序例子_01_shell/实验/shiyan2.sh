#!/usr/bin/env bash
#练习二：写一个脚本
#      1.切换工作目录至/var
#      2.依次向/var目录中的每个文件或子目录问好，形如：
#        （提示：for FILE in /var/*;或for FILE in `ls /var`;)
var='/var'
let "num=0"
for i in `ls $var`
do
echo "hello $i"
num=$[num+1]
done
echo "文件总数为："$num