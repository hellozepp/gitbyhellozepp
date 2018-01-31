#!/usr/bin/env python
# coding=utf-8
import sys
import cx_Oracle

if __name__ == "__main__":
    colors = {"1": '黄色',
              "2": '黄色',
              "3": '黑色',
              "4": '白色',
              "9": '其他'
              }
    with open("phoneNumber") as f:  # 运营商
            sumA, sumB = 0, 0
            conn = cx_Oracle.connect('reader/YqQFQJfHKcl4Y9kz@bigdata')  # 连接数据库
            for line in f:
                c = conn.cursor()  # 获取cursor
                c.execute(' select VEHICLE_NO,VEHICLE_COLOR from HYPT.Tb_Truck where VEHICLE_OWNER_PHONE =\'' + line.strip() + "\'")  # 使用cursor进行各种操作
                result = c.fetchall()
                if result:
                    for i in result:
                        if i[1] == None:
                            color = '1'
                        else:
                            color = i[1]
                        try:
                            print(i[0] + "@" + colors[color])
                        except:
                            print(i[0] + "@" + str(i[1]))
            conn.close()
