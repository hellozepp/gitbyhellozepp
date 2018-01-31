#!/bin/bash
#变量和引用--环境变量
#命令行 定义以后必须得export才能在 脚本 中调用,只能在一个同一个shell进程调到
export DOMAIN="chinaitlab.com"
echo $DOMAIN
echo '#显示环境变量 environment 环境'
env
#清除环境变量

unset DOMAIN
echo $DOMAIN
