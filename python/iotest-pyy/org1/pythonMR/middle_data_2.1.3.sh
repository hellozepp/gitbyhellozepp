#!/bin/bash
echo "========== cron task execute start " `date "+%Y-%m-%d %H:%M:%S"`
#trackinputpathprefix=/datasource/freight_track/ # 轨迹输入路径前缀
#datafiltermrpath=/home/hadoop/crontab/datafilter_timing

year=$3
month=$2
day=$1
numReduceTasks=30

#input=/bigdata/dev/mapred/warehouse/zhangbo/BaseGuijiFilted/${year}/${month}/${day}/orgin_data_tainan/
input=/datasource/freight_track/${year}/${month}/${day}.txt*
#input=/user/h_lipeng/test_dir/datasource/truck_freight/2014/12/01/
#output=/user/h_lipeng/middle_data/BaseGuiji/${year}/${month}/${day}/
output=/bigdata/product/mapred/warehouse/BaseGuiji/${year}/${month}/${day}/

dicpath=/user/h_lipeng/test_dir/static_data/part-00000.lzo
hadoop fs -rm -r $output

hadoop jar middle-data-2.1.3.jar org.ctfo.job.base.MiddleData \
    -D mapreduce.job.queuename=badm \
    -D mapreduce.job.inputformat.class=com.hadoop.mapreduce.LzoTextInputFormat \
    -D mapreduce.output.fileoutputformat.compress=true \
    -D mapreduce.output.fileoutputformat.compress.codec=com.hadoop.compression.lzo.LzopCodec \
    -libjars lib/common-util.jar,lib/data-parse-2.3.1.jar,lib/GpsConverter-1.0.jar \
    $input $output  ${year}-${month}-${day} $numReduceTasks $dicpath
hadoop fs -ls $output

    #-D mapreduce.job.inputformat.class=com.hadoop.mapreduce.LzoTextInputFormat \
    #/datasource/freight_track/${year}/${month}/${day}/ 
# generate lzo index 
echo "=========== generate lzo index start " `date "+%Y-%m-%d %H:%M:%S"`
hadoop jar hadoop-lzo.jar com.hadoop.compression.lzo.DistributedLzoIndexer -D mapreduce.job.queuename=badm $output
echo "=========== generate lzo index end " `date "+%Y-%m-%d %H:%M:%S"`

#done
