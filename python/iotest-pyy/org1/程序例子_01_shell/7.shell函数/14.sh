#!/bin/bash
#函数

#shell中函数的定义格式如下：
#函数名(){
#    command1
#    command2
#    ...
#    commandN
#    [ return value ]
#}

#function 函数名(){
#    command1
#    command2
#    ...
#    commandN
#    [ return value ]
#}

demoFun(){
    echo "This is your first shell function!"
}
echo "Function begin..."
demoFun
echo "Function end!"

#=================================================
#!/bin/bash
funWithReturn(){
    echo "The function is to get the sum of two numbers..."
    echo -n "Input first number: "
    read aNum
    echo -n "Input another number: "
    read anotherNum
    echo "The two numbers are $aNum and $anotherNum !"
    return $(($aNum+$anotherNum))
}
funWithReturn
echo "The sum of two numbers is $? !"


#=============================================
#向函数传递参数
funWithParam(){
    echo "The value of the first parameter is $1 !"
    echo "The value of the second parameter is $2 !"
    echo "The value of the tenth parameter is $10 !"
    echo "The value of the tenth parameter is $10 !"
    echo "The value of the eleventh parameter is $11 !"
    echo "The amount of the parameters is $# !"
    echo "The string of the parameters is $* !"
}
funWithParam 1 2 3 4 5 6 7 8 9 34 73


