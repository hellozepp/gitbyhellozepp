#!/usr/bin/env bash
while [ $# != 0 ];do
echo "第一个参数为：$1,参数个数为：$#"
shift
done
#shift n后，前n位参数都会被销毁
