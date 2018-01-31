#!/usr/bin/env bash
echo 1 ${0}
echo 2 ${0#*/} # #删除左边到截断处 X
echo 3 ${0##*/} #右边开始遍历，到/处  #3 截断.sh
echo 4 ${0%/*} # %右边遍历，到/处
echo 5 ${0%%/*} #删除全部，匹配左边/* 找到了/opt/projects/python/iotest-py/程序例子_01_shell/1.shell变量/截断.sh X