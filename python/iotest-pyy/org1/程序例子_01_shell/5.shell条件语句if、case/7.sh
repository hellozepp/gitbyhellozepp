#!/bin/bash
#流程控制-----"if" 表达式


a=10
b=20
echo '[ $a == $b ]:'[ $a == $b ]
echo '[ $a -gt $b ]:'[ $a -gt $b ]
if [ $a == $b ]
    then
       echo "a is equal to b"
    elif [ $a -gt $b ]
    then
       echo "a is greater than b"
    elif [ $a -lt $b ]
    then
       echo "a is less than b"
    else
       echo "None of the condition met"
fi

echo '1#============================================'
#条件测试
#如果测试结果为真，则该命令的Exit Status为0，
#如果测试结果为假，则命令的Exit Status为1
VAR=2
test $VAR -gt 1
echo 'test $VAR -gt 1 ' $?


test $VAR -gt 3
echo "test VAR -gt 3  "$?

[ $VAR -gt 3 ]
echo '[ $VAR -gt 3 ] ' $?

echo "2#============================================"
if test $[2*3] -eq $[1+5]; then echo 'The two numbers are equal!'; fi;

#if ; then echo "1";else echo "2"; #if条件为表达式
#fi

num1=$[2*3]
num2=$[1+5]
if test ${num1} -eq $[num2]
then
    echo 'The two numbers are equal!'
else
    echo 'The two numbers are not equal!'
fi

echo '3#============================================'
#测试文件状态
#-a 文件存在 0 不存在1
#-b 文件存在并且是块文件
#-c 文件存在并且是字符文件
#-d 文件存在并且是目录
#-s 文件长度大于0、非空
#-f 文件存在并且是正规文件
#-u 文件有suid位设置
#-w 文件存在并且可写
#-r 文件存在并且可读
#-x 文件存在并且可执行
#-L 文件存在并且符号连接
[ -f asfasfsadf.sh ]
echo $?
[ -d 7.sh ]
echo $?
[ -x 7.sh ]
echo $?

#===========================================
#测试时使用逻辑操作符
#[ ! EXPR ]!表示逻辑反
#[ EXPR1 -a EXPR2 ]-a表示逻辑与
#[ EXPR1 -o EXPR2 ]-o表示逻辑或
[ -f 7.sh -a -x 7.sh ]
echo $?

echo "4#==========================================="
#字符串测试
#[ -z STRING ]	如果STRING的长度为零则为真
#[ -n STRING ]	如果STRING的长度非零则为真
#[ STRING1 = STRING2 ]	如果两个字符串相同则为真
#[ STRING1 != STRING2 ]	如果字符串不相同则为真
test "string"
echo $? #0
test -n "string"
echo $? #0
test "string" = "string"
echo $? #0
echo string #string
[ -z string ]
echo $? #
[ string != string ]
echo $?

echo "+++++++++++++++++++++++++++++++++++++"
#测试数值
#[ ARG1 OP ARG2 ]ARG1和ARG2应该是整数或者取值为整数的变量
#-eq 数值相等。
#-ne 数值不相等。
#-gt 第一个数大于第二个数。
#-lt 第一个数小于第二个数。
#-le 第一个数小于等于第二个数。
#-ge 第一个数大于等于第二个数。
value=15
[ $value -eq 15 ]
echo $?

[ $value -eq 16 ]
echo $?

#管道, 重定向和 backtick
#管道(|) 将一个命令的输出作为另外一个命令的输入。
grep "hello" file.txt | wc -l

#重定向(<和>)
#2>a.txt      表示将错误信息输出到文件a.txt中
#2>1           把标准错误stderr重定向到文件1中
#2>&1          将错误信息重定向到标准输出
#>  写入文件并覆盖旧文件
#>> 加到文件的尾部，保留旧文件内容。
ls 1>/dev/null 2>/dev/null
ls >/dev/null 2>&1

#、1>/dev/null 2>&1的含义
#1>/dev/null 正确命令输入到黑洞
#> 代表重定向到哪里，例如：echo "123" > /home/123.txt
#1 表示stdout标准输出，系统默认值是1，所以">/dev/null"等同于"1>/dev/null"
#2 表示stderr标准错误
#& 表示等同于的意思，2>&1，表示2的输出重定向等同于1
val=15
expr $val + 1 > /dev/null 2>&1
#如果返回值为0，证明这是一个数，其他则表明为非数值。
echo 'expr $val + 1 > /dev/null 2>&1      '$?
val='aaaaaaa'
expr $val  > /dev/null 2>&1 #应该输出aaaaa，结果不输出
#如果返回值为0，证明这是一个数，其他则表明为非数值。
echo 'expr $val  > /dev/null 2>&1      '$?
#快捷操作符：&&和||
#&& 与操作
#这里 && 就是一个快捷操作符，如果左边的表达式为真则执行右边的语句。
[ -f "/etc/shadow" ] && echo "This computer uses shadow passwors"

#|| 或操作：
#该脚本首先判断mailfolder是否可读。如果可读则打印该文件中的"From" 一行。如果不可读则或操作生效，打印错误信息后脚本退出。
mailfolder=/Users/docker
[ -r "$mailfolder" ]||{ echo "Can not read $mailfolder" ; exit 2; }  #使用花括号以匿名函数的形式将两个命令放到一起作为一个命令使用。
echo "$mailfolder has mail from:"
grep "^From " $mailfolder


 if test ! -h ../../Home;
 then echo '文件不存在，或者存在不为软连接';fi