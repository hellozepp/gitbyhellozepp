#!/bin/bash
######################################
######################################
userPath=/user/h_zhanglin/match_locus
IN_PATH0=$userPath/201712/
OUT_PATH=$userPath/pathCount/
HPHOME=/opt/cloudera/parcels/CDH
JAR_PACKAGE=/opt/cloudera/parcels/CDH/lib/hadoop-mapreduce/hadoop-streaming.jar
MAP_FILE=map.py
RED_FILE=red.py
$HPHOME/bin/hadoop fs -rm -r $OUT_PATH

$HPHOME/bin/hadoop jar $JAR_PACKAGE \
        -D mapred.job.queue.name=bdev \
        -D stream.map.input.ignoreKey=true \
        -D map.output.key.field.separator=, \
        -D stream.non.zero.exit.is.failure=false \
        -D num.key.fields.for.partition=1 \
        -D mapreduce.output.fileoutputformat.compress=true \
        -D mapreduce.output.fileoutputformat.compress.codec=com.hadoop.compression.lzo.LzopCodec \
        -D mapreduce.map.memory.mb=4096 \
        -numReduceTasks 200 \
        -input $IN_PATH0 \
        -output $OUT_PATH \
        -mapper $MAP_FILE \
        -reducer $RED_FILE \
        -file $MAP_FILE \
        -file $RED_FILE
$HPHOME/bin/hadoop fs -ls $OUT_PATH
