#!/usr/bin/python
# -*- coding:utf-8
import calendar
import sys, os
from decimal import *

import datetime

# import pymysql


reload(sys)
sys.setdefaultencoding('utf8')
to_file = None

pro_data_list = []
pro_user_set = set()
pro_card_number = 0


class Lmk:
    amount = None  # 交易金额
    cardno = None  # 联名卡卡号
    litter = None  # 升
    provcode = None
    userId = None
    getpref = None  # 积分(返利金额)
    # 添加 消费笔数
    consumptionCount = 0

    def get_consumptionCount(self):
        return self.consumptionCount

    def set_consumptionCount(self, consumptionCount):
        self.consumptionCount = consumptionCount

    def get_amount(self):
        return self.amount

    def get_cardno(self):
        return self.cardno

    def get_litter(self):
        return self.litter

    def get_provcode(self):
        return self.provcode

    def get_userId(self):
        return self.userId

    def get_getpref(self):
        return self.getpref

    def set_amount(self, amount):
        self.amount = amount

    def set_cardno(self, cardno):
        self.cardno = cardno

    def set_litter(self, litter):
        self.litter = litter

    def set_provcode(self, provcode):
        self.provcode = provcode

    def set_userId(self, userId):
        self.userId = userId

    def set_getpref(self, getpref):
        self.getpref = getpref


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


# =====统计消费账户数(个）=====
def countConsumer(list):
    consumerDict = set()
    # 消费卡数（个）===len(list)
    consumptionCount = 0  # 消费笔数
    oilMassCount = 0  # 持卡消费量(万升)
    amountCount = 0  # 消费金额（万元）
    getprefCount = 0  # 返利（万元）
    for row in list:
        consumerDict.add(row.get_userId())
        consumptionCount += row.get_consumptionCount()
        oilMassCount += row.get_litter()
        amountCount += row.get_amount()
        getprefCount += row.get_getpref()
    if amountCount:
        amountCount = float(amountCount / 10000)
    if oilMassCount:
        oilMassCount = float(float(oilMassCount) / 10000)
    if getprefCount:
        getprefCount = float(float(getprefCount) / 10000)
        percent = float(getprefCount) / float(amountCount)
        percent = float('%.2f' % percent)
    else:
        percent = 0
    return str(len(consumerDict)) + "," + str(len(list)) + "," + str(consumptionCount) + "," \
           + str(oilMassCount) + "," + str(amountCount) + "," + str(getprefCount) \
           + "," + str(percent) + ","


# 放所有消费记录
rows = {}


def queryData(monthRange, year, month):
    for j in range(1, monthRange + 1):
        file = open("query.sql")
        datatime = datetime.date(year=year, month=month, day=j)
        datatimeStr = datatime.strftime("%Y%m%d")
        startTime = datatimeStr + '000000'
        endTime = datatimeStr + '235959'
        datatimeStr1 = datatime.strftime("%Y-%m-%d")
        startTime1 = datatimeStr1 + ' 00:00:00'
        endTime1 = datatimeStr1 + ' 23:59:59'
        now = datetime.datetime.now()
        while 1:
            sql = file.readline()
            if not sql:
                break
            print("==================")
            print("while")
            sql = sql.replace("{1}", startTime).replace("{2}", endTime).replace("{3}", startTime1).replace("{4}",
                                                                                                           endTime1)
            print(sql)
            os.popen("cat >hive.ql<<EOF\nset mapred.job.queue.name=bdev;\n" + sql + "\nEOF\n").read()
            os.popen("hive -f hive.ql>>resultSet;").read()
            print("SUCCESS")
            print("=============================")
        result = open("resultSet", "r")
        for d in result:
            d = d.split("\t")
            row = Lmk()
            if "NULL" == d[0].strip():
                d[0] = "0"
            row.set_amount(Decimal(d[0].strip()))
            row.set_cardno(d[1].strip())
            if "NULL" == d[2].strip():
                d[2] = "0"
            row.set_litter(Decimal(d[2]))
            row.set_provcode(str(d[3]))
            row.set_userId(d[4].strip())
            if "NULL" == d[5].strip():
                d[5] = "0"
            row.set_getpref(Decimal(d[5]))
            row.set_consumptionCount(1)
            if row.get_amount() == 0 or row.get_litter() == 0 or row.get_cardno() == 0:
                continue
            if not rows.get(d[1]):
                rows[d[1]] = row
            else:
                var = rows.get(d[1].strip())
                var.set_amount(var.get_amount() + Decimal(d[0].strip()))
                var.set_litter(var.get_litter() + Decimal(d[2].strip()))
                var.set_getpref(var.get_getpref() + Decimal(d[5].strip()))
                var.set_consumptionCount(var.get_consumptionCount() + 1)
                rows[d[1]] = var

        litter_lt_1000 = []
        litter_lt_2000 = []
        litter_lt_3000 = []
        litter_lt_5000 = []
        litter_gt_5000 = []
        # 统计1天的几类数据
        for r in rows:
            if rows[r].get_litter() > 0 and rows[r].get_litter() < 1000:
                litter_lt_1000.append(rows[r])
            elif rows[r].get_litter() >= 1000 and rows[r].get_litter() < 2000:
                litter_lt_2000.append(rows[r])
            elif rows[r].get_litter() >= 2000 and rows[r].get_litter() < 3000:
                litter_lt_3000.append(rows[r])
            elif rows[r].get_litter() >= 3000 and rows[r].get_litter() < 5000:
                litter_lt_5000.append(rows[r])
            elif rows[r].get_litter() >= 5000:
                litter_gt_5000.append(rows[r])
        res = countConsumer(litter_lt_1000)
        output = open("result1.csv", 'a')
        output.write(str(datatime) + "," + res)
        res = countConsumer(litter_lt_2000)
        output.write(res)
        res = countConsumer(litter_lt_3000)
        output.write(res)
        res = countConsumer(litter_lt_5000)
        output.write(res)
        res = countConsumer(litter_gt_5000)
        output.write(res + "\n")
        output.flush()
        output.close()
        os.system("rm -rf resultSet;")
        if now.strftime('%Y%m%d') <= datatimeStr:
            break


def queryDayData1(year, month):
    count = 3
    queryDayData(year, month, count)
    countProv()


# =====统计数据=====
def queryDayData(year, month, count):
    if count <= 0:
        return
    if month is 1:
        queryDayData(year - 1, 12, count - 1)
        day, monthRange = calendar.monthrange(year, month)
        queryData(monthRange, year, month)
    else:
        queryDayData(year, month - 1, count - 1)
        day, monthRange = calendar.monthrange(year, month)
        queryData(monthRange, year, month)


if __name__ == '__main__':
    os.system("rm -rf result.csv hive.ql prov.csv;rm -rf result1.csv prov1.csv resultSet;")
    argDate = sys.argv[1]
    seq = argDate.split("-")
    year = int(seq[0])
    month = int(seq[1])
    queryDayData1(year, month)
    # queryData(2017, 12)
    os.system('cp ./head.csv result.csv;cat ./result1.csv>>result.csv;')
    os.system('cp ./head.csv prov.csv;cat ./prov1.csv>>prov.csv;')
