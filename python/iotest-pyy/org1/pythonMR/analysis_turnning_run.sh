#!/bin/bash

function get_month_ago(){
	month=${1:0:6}
    day="${month}01"
    month2=`date -d"$2 month ago ${day}" +%Y%m`
    echo $month2
}

EXEC_PATH=$(dirname "$0")
date=${1}
year=${date:0:4}
month=${date:4:2}
day=${date:6:2}
insurance_root=`cat ${EXEC_PATH}/config.cfg|sed s/[[:space:]]//g|awk -F"#" '{print $1}'|awk -F"=" '{if ($1 == "insurance_root") print $2}'`

month2=`get_month_ago $1 1`
month3=`get_month_ago $1 2`

HPHOME=/opt/cloudera/parcels/CDH-5.6.0-1.cdh5.6.0.p0.45
JAR_PACKAGE=/opt/cloudera/parcels/CDH-5.6.0-1.cdh5.6.0.p0.45/lib/hadoop-mapreduce/hadoop-streaming-2.6.0-cdh5.6.0.jar
    IN_PATH1=${insurance_root}/find_turnning/${year}${month}*/part*

    OUT_PATH=${insurance_root}/turning_anaylsis_month/${year}${month}${day}/

	MAP_FILE=${EXEC_PATH}/analysis_turnning_map.py
	RED_FILE=${EXEC_PATH}/analysis_turnning_red.py
	$HPHOME/bin/hadoop fs -rm -r   $OUT_PATH
	$HPHOME/bin/hadoop jar $JAR_PACKAGE \
    	-D mapred.job.queue.name=badm \
	-D mapred.job.name=online_job_${exec_file_name} \
	    -D map.output.key.field.separator=, \
    	-D num.key.fields.for.partition=1 \
        -D mapreduce.reduce.memory.mb=8092\
	    -D mapreduce.output.fileoutputformat.compress=true \
        -D mapreduce.output.fileoutputformat.compress.codec=com.hadoop.compression.lzo.LzopCodec \
		-numReduceTasks 4 \
        -input $IN_PATH1 \
	    -output $OUT_PATH \
    	-mapper $MAP_FILE \
	    -reducer $RED_FILE \
    	-file $MAP_FILE \
	    -file $RED_FILE \
	    -partitioner org.apache.hadoop.mapred.lib.KeyFieldBasedPartitioner
hadoop fs -ls  $OUT_PATH
