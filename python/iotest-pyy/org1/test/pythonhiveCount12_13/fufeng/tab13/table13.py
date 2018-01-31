#!/usr/bin/python
# -*- coding:utf-8
import calendar,datetime,time
import sys, os
from decimal import *
from imp import reload

getcontext().prec = 6
import datetime

# import pymysql


reload(sys)
sys.setdefaultencoding('utf8')


# =====分省统计=====
def countProv():
    provs = {'11': '北京', '12': '天津', '13': '河北', '14': '山西', '31': '上海', '32': '江苏',
             '33': '浙江', '34': '安徽', '35': '福建', '36': '江西', '37': '山东', '41': '河南',
             '42': '湖北', '43': '湖南', '44': '广东', '45': '广西', '46': '海南', '52': '贵州',
             '53': '云南', '51': '四川', '50': '重庆', '15': '内蒙古',
             '21': '辽宁', '22': '吉林', '23': '黑龙江', '61': '陕西', '62': '甘肃', '63': '青海',
             '64': '宁夏', '65': '新疆', '54': '西藏'}
    provMap = {}
    output1 = open("prov1.csv", 'a')
    for key in rows:  # 分成 省编码：list[]
        if provs.get(rows[key].get_provcode()) is None:
            continue
        if not provMap.get(provs.get(rows[key].get_provcode())):
            provMap[provs.get(rows[key].get_provcode())] = [rows.get(key), ]
        else:
            var = provMap.get(provs.get(rows[key].get_provcode()))
            var.append(rows.get(key))
            provMap[provs.get(rows[key].get_provcode())] = var

    for key1 in provs:
        ro = provMap.get(provs[key1])
        if not ro:
            ro = []
        litter_lt_1000 = []
        litter_lt_2000 = []
        litter_lt_3000 = []
        litter_lt_5000 = []
        litter_gt_5000 = []
        # 统计1省的几类数据
        for r in ro:
            if r.get_litter() < 1000:
                litter_lt_1000.append(r)
            elif r.get_litter() >= 1000 and r.get_litter() < 2000:
                litter_lt_2000.append(r)
            elif r.get_litter() >= 2000 and r.get_litter() < 3000:
                litter_lt_3000.append(r)
            elif r.get_litter() >= 3000 and r.get_litter() < 5000:
                litter_lt_5000.append(r)
            else:
                litter_gt_5000.append(r)
        res = countConsumer(litter_lt_1000)
        res = provs[key1] + "," + res
        res = res.encode('utf-8')
        output1.write(res)
        output1.flush()
        res = countConsumer(litter_lt_2000)
        output1.write(res)
        output1.flush()
        res = countConsumer(litter_lt_3000)
        output1.write(res)
        output1.flush()
        res = countConsumer(litter_lt_5000)
        output1.write(res)
        output1.flush()
        res = countConsumer(litter_gt_5000)
        output1.write(res + "\n")
        output1.flush()
    output1.close()

def queryData(monthRange, year, month,day):
    file = open("./base/query.sql")
    sql = file.readline()
    start_data_time = datetime.datetime(int(year), int(month), int(day))
    end_data_time = datetime.datetime(int(year), int(month), int(day)) + datetime.timedelta(days=monthRange - 1)


    start_data_time_str1=start_data_time.strftime("%Y%m%d")
    end_data_time_str1=end_data_time.strftime("%Y%m%d")
    start_query_time1=start_data_time_str1 + '000000'
    end_query_time1=end_data_time_str1 + '235959'

    start_data_time_str2 = start_data_time.strftime("%Y-%m-%d")
    end_data_time_str2 = end_data_time.strftime("%Y-%m-%d")
    start_query_time2 = start_data_time_str2 + ' 00:00:00'
    end_query_time2 = end_data_time_str2 + ' 23:59:59'


    sql = sql.replace("{1}", start_query_time1).replace("{2}", end_query_time1).replace("{3}", start_query_time2).replace("{4}",end_query_time2)

    print(sql)
    os.popen("cat >./temp/hive.ql<<EOF\nset mapred.job.queue.name=bdev;\n" + sql + "\nEOF\n").read()
    os.popen("hive -f ./temp/hive.ql>>./temp/resultSet;").read()
    print("SUCCESS")
    print("=============================")

def queryAllDay(start,end):
    datestart=datetime.datetime.strptime(start,'%Y-%m-%d')
    dateend=datetime.datetime.strptime(end,'%Y-%m-%d')
    daylist=[]
    while datestart<dateend:
        datestart+=datetime.timedelta(days=1)
        daylist.append(datestart)

    return len(daylist)+1

def queryDayDataNew(year,month,day):
    current_month = month
    if month in ['01', '02', '03']:
        month = 1
    elif month in ['04', '05', '06']:
        month = 4
    elif month in ['07', '08', '09']:
        month = 7
    elif month in ['10', '11', '12']:
        month = 10
    start = str(year)+"-"+str(month)+"-1"
    end = str(year)+"-"+str(current_month)+"-"+str(day)
    monthRange = queryAllDay(start,end)
    queryData(monthRange, int(year), int(month),int("1"))

if __name__ == '__main__':
    argDate = sys.argv[1]
    in_hdfs_path = sys.argv[2]
    out_hdfs_path = sys.argv[3]
    seq = argDate.split("-")
    year = seq[0]
    month = seq[1]
    day = seq[2]
    queryDayDataNew(year, month,day)
    
    os.system('hadoop fs -rm -r -f '+in_hdfs_path+'/resultSet')
    os.system('hadoop fs -put ./temp/resultSet '+in_hdfs_path+';')
    os.system('sh ./mr/mr.sh '+in_hdfs_path+"/resultSet "+out_hdfs_path)
    os.system('hadoop fs -text '+out_hdfs_path+"/* > ./temp/result1.csv;")
    os.system('cp ./base/head.csv ./temp/result.csv;cat ./temp/result1.csv>>./temp/result.csv;')

