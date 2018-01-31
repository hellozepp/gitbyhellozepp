#!/usr/bin/env bash
echo 'table2开始统计'
yesterday=`date +"%Y-%m-%d %H:%M:%S"  -d '-24hour' `
v_year=${yesterday:0:4}
v_month=${yesterday:5:2}
v_day=${yesterday:8:2}
echo $yesterday
echo ${v_year}${v_month}${v_day}
