#!/usr/bin/env bash
#!/bin/bash
#流程控制-----循环--select结构
#./13.sh aaa bbb ccc ddd eee

#select带参数列表
echo "What is your favourite color? "  
  
select color in "red" "blue" "green" "white" "black"  
do   
    break  
done  
  
echo "You have selected $color" 

#===============================================
#select不带参数列表
echo "What is your favourite color? "  
  
select color1  
do   
    break  
done  
  
echo "You have selected $color1"  
