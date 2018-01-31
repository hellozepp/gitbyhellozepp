#!/bin/bash
#流程控制-----循环--for
#./9.sh 1 2 3 4

for varible1 in {1..5}  
#for varible1 in 1 2 3 4 5  
do  
     echo "Hello, Welcome $varible1 times "  
done  

#==============================================
sum=0
for i in {1..10..2}  #step==2( 1 3 5 7 9) #没起作用
do
    let "sum=sum+i"
done  
      
echo "sum=$sum"  

#==============================================
for file in $( ls )  #相当于`` 执行
#for file in *  
do  
   echo "file: $file"  
done 

#==============================================
echo "number of arguments is $#"  
  
echo "What you input is: "  
  
for argument in "$@"  
do  
    echo "$argument"  
done  

#也可以这样写
echo "number of arguments is $#"  
  
echo "What you input is: "  
  
for argument  
do  
    echo "$argument"  
done 

#=================================================
for((integer = 1; integer <= 5; integer++))  
do  
    echo "$integer"  
done 

sum=0  

#=================================================
for(( i = 1; i <= 10; i = i + 2 ))  
do  
     let "sum += i"  
done  
  
echo "sum=$sum" 

