#!/usr/bin/env python
# coding=utf-8
import sys
import cx_Oracle

if __name__ == "__main__":
    with open("A") as f:  # 运营商
        with open("B") as f1:
            sumA, sumB = 0, 0
            conn = cx_Oracle.connect('reader/YqQFQJfHKcl4Y9kz@bigdata')  # 连接数据库
            for line in f:
                c = conn.cursor()  # 获取cursor
                c.execute(
                    ' select COUNT(VEHICLE_NO) from HYPT.Tb_Truck where VEHICLE_OWNER_PHONE =\'' + line.strip() + "\'")  # 使用cursor进行各种操作
                sumA += int(c.fetchone()[0])
                c.close()
            for line in f1:
                c = conn.cursor()  # 获取cursor
                c.execute(
                    ' select COUNT(VEHICLE_NO) from HYPT.Tb_Truck where VEHICLE_OWNER_PHONE =\'' + line.strip() + "\'")  # 使用cursor进行各种操作
                sumB += int(c.fetchone()[0])
                c.close()
            conn.close()
            print(str(sumA))
            print(str(sumB))
