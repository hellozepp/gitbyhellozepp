#!/usr/bin/env bash
#练习一：写一个脚本
#       1.设定变量FILE的值为/etc/passwd
#       2.依次向/etc/passwd中的每个用户问好，并且说出对方的ID是什么
#        形如：（提示：LINE=`wc -l /etc/passwd | cut -d" " -f1`)
#         Hello,root，your UID is 0.
#       3.统计一个有多少个用户
file="/etc/passwd"
       LINES=`wc -l $file | cut -d" " -f1`
       for I in `seq 1 $LINES`;do
       userid=`head -$I $file | tail -1 |cut -d: -f3`
       username=`head -$I $file | tail -1 |cut -d: -f1`
       echo "hello $username,your UID is $userid"
       done
       echo "there are $LINES users"

