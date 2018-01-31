# /bin/sh
start_date=`date "+%Y-%m-%d %H:%M:%S"`
echo "===================start count table12 data[${1}]====================="
echo "start_time[${start_date}]"
lm_date=`date -d "${1}" "+%Y-%m-%d"`
path=/home/h_tianfufeng/table13/
mr_input_path=/user/h_tianfufeng/temp/resultSet
mr_output_path=/user/h_tianfufeng/temp/table13
mr_output_path2=/user/h_tianfufeng/temp/table13_final
source /etc/profile
echo "lmk_date: " ${lm_date}
rm -rf ${path}data/*
sh ${path}mr/mr.sh ${mr_input_path} ${mr_output_path} ${mr_output_path2}
hadoop fs -text ${mr_output_path2}/* > ${path}temp/result1.csv
cp ${path}base/head.csv ${path}temp/result.csv
cat ${path}temp/result1.csv >> ${path}temp/result.csv
cp ${path}temp/result.csv  ${path}data/result${lm_date}.csv
rm -rf ${path}/temp/*
end_date=`date  "+%Y-%m-%d %H:%M:%S"`
echo "end_time[${end_date}]"
echo "======================================================================="
