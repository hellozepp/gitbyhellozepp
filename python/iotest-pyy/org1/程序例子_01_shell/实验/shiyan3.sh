#!/usr/bin/env bash
#练习三：写一个脚本
#      1.设定变量file的值为/etc/passwd
#      2.使用循环读取文件/etc/passwd的第2,4,6,10,13,15行，并显示其内容
#      3.把这些行保存至/tmp/mypasswd文件中
file="/etc/passwd"
for I in 2 4 6 10 13 15;do
exec 3>/tmp/mypasswd
line=`head -$I $file | tail -1`
echo "$line"
echo "$line" >&3
exec 3>&-
done