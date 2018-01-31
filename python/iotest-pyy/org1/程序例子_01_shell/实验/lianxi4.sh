#!/usr/bin/env bash
#  传递两个整数给脚本，让脚本分别计算并显示这两个整数的和，差，积，商
echo $@
echo "$1 + $2="$[$1+$2]
echo "$1 - $2="$[$1-$2]
echo "$1 * $2="$[$1*$2]
echo "$1 / $2="$[$1/$2]
#-----------------------------------------------------------
#作业一：写一个脚本：
#       1.创建目录/tmp/scripts
#       2.切换工作目录至此目录中
#       3.复制/etc/pam.d目录至当前目录，并重命名为test
#       4.将当前目录的test及其里面的文件和子目录的属主改为redhat
#       5.将test及其子目录中的文件的其它用户的权限改为没有任何权限
#   答案：
       mkdir -v /tmp/scripts
       cd /tmp/scripts
       cp -r /etc/pam.d ./test
       chown -R redhat ./test
       chmod -R o=--- ./test
#-----------------------------------------------------------

#作业二：写一个脚本
#       1.显示当前系统日期和时间，而后创建目录/tmp/lstest
#       2.切换工作目录至/tmp/lstest
#       3.创建目录a1d，b56e，6test
#       4.创建空文件xy，x2y，732
#       5.列出当前目录下以a，x或者6开头的文件或目录
#       6.列出当前目录下以字母开头，后跟一个任意数字，而后跟任意长度字符的文件或目录
#   答案：
       date
       mkdir -pv /tmp/lstest
       cd /tmp/lstest
       mkdir a1d b56e 6test
       touch xy x2y 732
       ls [ax6]*
       ls [[:alpha:]][[:digit:]]*
#-----------------------------------------------------------

#作业三：写一个脚本
#        添加10个用户user1到user10，但要求只有用户不存在的情况下才能添加
       for I in `seq 1 10`;do
       cut -d: -f1 /etc/passwd |grep "user$I" 2>>/tmp/etc.err || useradd user$I
       done
#-----------------------------------------------------------

#作业四：写一个脚本
#       通过ping命令测试192.168.0.151到192.168.0.254之间的所有主机是否在线
#       如果在线，就显示“ip is up”
#       如果不在线，就显示“ip is down”
#      答案： #!/bin/bash
       for I in `seq 151 254`;do
       ping -c1 -w1 192.168.0.$I &>/dev/null && echo "192.168.0.$I is up" ||  echo "192.168.0.$I is down"
       done
