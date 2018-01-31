#!/usr/bin/env bash
echo "参数个数为：$#,其中："
for i in $(seq 1 $#)
do
  eval j=\$$i
  echo "第$i 个参数($"$i")：$j"
done

shift 3

echo "执行shift 3操作后："
echo "参数个数为：$#,其中："
for i in $(seq 1 $#)
do
  #通过eval把i变量的值($i)作为变量j的名字
  eval j=\$$i
  echo "第$i 个参数($"$i")：$j"
done