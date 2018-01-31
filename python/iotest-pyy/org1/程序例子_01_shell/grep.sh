#!/usr/bin/env bash
echo 在多个文件中查找 并匹配上下两行
grep -m1 -C1 "sed" log.txt
echo ========================
echo 输出除之外的所有行 -v 选项
grep  -v "sed" log.txt --color=auto
echo ========================
echo 使用正则表达式 -E 选项
grep -E "[1-9]+" log.txt --color=auto
echo ========================
echo 只输出文件中匹配到的部分 -o 选项
echo this is a test line. | grep -o -E "[a-z]+\."
echo ========================
echo 统计文件或者文本中包含匹配字符串的行数 -c 选项
grep -c -E "^sed$" log.txt
echo ========================
echo 输出包含匹配字符串的行数 -n 选项
grep "sed" -n log.txt