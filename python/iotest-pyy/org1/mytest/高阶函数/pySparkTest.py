# spark 特点;1、内存存中间结果和总结果，可以不用hdfs，rdd可以cache到内存中
#             2、RDD高阶函数
#             3.惰性计算，触发action（group count 。。。）才追溯结果
import sys
from operator import add
from pyspark import SparkContext
sc = SparkContext()
lines = sc.textFile("stormofswords.csv")
counts = lines.flatMap(lambda x: x.split(',')) \
              .map(lambda x: (x, 1)) \
              .reduceByKey(add)
output = counts.collect()
output = filter(lambda x:not x[0].isnumeric(), sorted(output, key=lambda x:x[1], reverse = True))
for (word, count) in output[:10]:
    print("%s: %i" % (word, count))

sc.stop()