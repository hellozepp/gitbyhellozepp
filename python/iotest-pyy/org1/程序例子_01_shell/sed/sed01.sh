#!/usr/bin/env bash
#coding=utf8
#创建测试文本
#cat >person.txt<<EOF
#101,oldboy,CEO
#102,zhangyao,CTO
#103,Alex,COO
#104,yy,CFO
#105,feixue,CIO
#EOF
cat >test.txt<<EOF
a
b
a
EOF

echo "============增 a i==========="
sed  '2a 106,dandan,CSO' person.txt #不指定行数 默认所有行
echo "-----------------------------"
sed '2i 106,dandan,CSO' person.txt
echo "============删 ==========="
sed '2d' person.txt
echo "-------------2----------------"
sed '2,5d' person.txt
echo "--------------3---------------"
sed '1~3d' person.txt #等差序列
echo "--------------4---------------"
sed '2,$d' person.txt #$代表最后一行
echo "--------------5---------------"
sed '2,+3d' person.txt
#地址用逗号分隔的，n1,n2可以用数字、正则表达式、或二者的组合表示。
#例子：
#　　　10{sed-commands}        对第10行操作
#　　　10,20{sed-commands}     对10到20行操作,包括第10,20行
#　　　10，+20{sed-commands}   对10到30(10+20)行操作,包括第10,30行
#　　　1~2{sed-commands}       对1,3,5,7,……行操作
#　　　10，${sed-commands}     对10到最后一行($代表最后一行)操作,包括第10行
#    /oldboy/{sed-commands}         对匹配oldboy的行操作
#    /oldboy/,/Alex/{sed-commands}  对匹配oldboy的行到匹配Alex的行操作
#    /oldboy/,${sed-commands}       对匹配oldboy的行到最后一行操作
#    /oldboy/,10{sed-commands}      对匹配oldboy的行到第10行操作，注意：如果前10行没有匹配到oldboy，sed软件会显示10行以后的匹配oldboy的行，如果有。
#    1,/Alex/{sed-commands}         对第1行到匹配Alex的行操作
#    /oldboy/,+2{sed-commands}      对匹配oldboy的行到其后的2行操作
echo "============改  输出==========="
echo "--------------c 用新行取代旧行---------------"

#c 用新行取代旧行
sed '2c balabala' person.txt
echo "--------------s 匹配每行第一个值 g匹配所有---------------"
#sed软件替换模型(方框▇被替换成三角▲)
#默认sed软件是对模式空间(内存中的数据)操作，而-i选项会更改磁盘上的文件内容。
sed 's#zhangyao#zhanglin#g' person.txt
echo "--------------2---------------"
sed 2s#zhangyao#zhanglin#g person.txt
echo "-------------3---------------"
x=a
y=b
sed 's#$x#$y#g' test.txt #''不会输出变量
echo "-------------4---------------"
eval sed 's#$x#$y#g' test.txt
sed "s#$x#$y#g" test.txt
sed s#$x#$y#g test.txt
echo "-------------5---------------"
#\( \)的功能可以记住正则表达式的一部分，其中，\1为第一个记住的模式即第一个小括号中的匹配内容
echo I am oldboy teacher. |sed 's#^.*am \([a-z].*\) tea.*$#\1#g'
echo "-------------ç---------------"
echo I am oldboy teacher. |sed -r 's#^.*am ([a-z].*) tea.*$#\1#g'
echo "-------------ç---------------"
echo I am oldboy teacher. |sed -r 's#I (.*) (.*) teacher.#\1\2#g'
echo "-------------ç---------------"
sed '1,3s#C#--&--#g' person.txt #→此处&等于C
echo "-------------ç---------------"
rm -rf stu_102999_1_finished.jpg stu_102999_2_finished.jpg stu_102999_3_finished.jpg stu_102999_4_finished.jpg stu_102999_5_finished.jpg
#touch stu_102999_{1..5}_finished.jpg
touch stu_102999_1_finished.jpg stu_102999_2_finished.jpg stu_102999_3_finished.jpg stu_102999_4_finished.jpg stu_102999_5_finished.jpg
#即删除文件名的_finished
#-r 识别扩展正则()不用加\,否则报错
ls *.jpg|sed -r "s#^(.*)_finished.*#mv & \1.jpg#g"|bash
echo "============查 输出==========="
sed -n '2p' person.txt #-n 忽略默认的sed的输出
echo "-------------2---------------"
sed -n '2,3p' person.txt
echo "-------------3---------------"
sed -n '/CTO/,/CFO/p' person.txt
echo "-------------3---------------"
sed -n '/feixue/,2p' person.txt
#→特殊情况，前两行没有匹配到feixue，就向后匹配，如果匹配到feixue就打印此行。
echo "-------------3---------------"
#[:space:] 匹配空白字符，包括空格，tab
sed s#[[:space:]]##g person.txt