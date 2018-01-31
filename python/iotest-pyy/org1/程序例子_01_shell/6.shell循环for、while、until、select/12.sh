#!/bin/bash
#流程控制-----循环--循环控制符break和continue

#break
sum=0  
for (( i=1; i <= 100; i++))  
do   
    let "sum+=i"  
  
    if [ "$sum" -gt 1000 ]  
    then  
        echo "1+2+...+$i=$sum"  
        break  
    fi  
done  

#continue
m=1  
for (( i=1; i < 100; i++ ))  
do  
    let "temp1=i%7"         #被7整除  
   
    if [ "$temp1" -ne 0 ]  
    then  
        continue  
    fi  
      
    echo -n "$i  "  
      
    let "temp2=m%7"          #7个数字换一行  
      
    if  [ "$temp2" -eq 0 ]  
    then  
        echo ""  
    fi  
      
    let "m++"  
done  

