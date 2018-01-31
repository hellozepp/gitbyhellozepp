#!/bin/bash
#流程控制-----循环--until


i=0  
until [[ "$i" -gt 5 ]]    #大于5  
do  
    let "square=i*i"  
    echo "$i * $i = $square"  
    let "i++"  
done 
