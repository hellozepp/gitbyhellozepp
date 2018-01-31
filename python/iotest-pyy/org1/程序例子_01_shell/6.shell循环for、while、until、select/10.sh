#!/bin/bash
#流程控制-----循环--while
#./10.sh 1 2 3 4

sum=0  
i=1  
while(( i <= 10 ))  
do  
     let "sum+=i"  
     let "i += 2"     
done  
  
echo "sum=$sum" 

#===========================================
echo "Please input the num(1-10) "  
read num  
  
while [[ "$num" != 4 ]] #不是数字报错
do   
   if [ "$num" -lt 4 ]  
   then  
        echo "Too small. Try again!"  
        read num  
   elif [ "$num" -gt 4 ]  
   then  
         echo "To high. Try again"   
         read num  
   else  
       exit 0  
    fi  
done   
  
echo "Congratulation, you are right! " 

#===============================================
echo "number of arguments is $#"  
  
echo "What you input is: "  
  
while [[ "$*" != "" ]]  
do  
    echo "$1"  
    shift  
done  
echo $0 #路径名
echo "生成连续数组系列："
a=($(seq  1 3 10))
echo ${a[1]}
 echo ${a[@]}