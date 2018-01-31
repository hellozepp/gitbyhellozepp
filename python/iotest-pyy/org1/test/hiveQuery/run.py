#!/usr/bin/python
# -*- coding:utf-8
import sys, os
from decimal import *
import pymysql
from hive_service import ThriftHive
from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

def hiveQuery(sql):
    tSocket = TSocket.TSocket('10.60.32.100', 10000)
    tTransport = TTransport.TBufferedTransport(tSocket)
    protocol = TBinaryProtocol.TBinaryProtocol(tTransport)
    client = ThriftHive.Client(protocol)
    tTransport.open()
    client.execute(sql)
    return client.fetchAll()

def queryData():
    file = open("query.sql","r")
    sql = file.readline()
    result =hiveQuery(sql)

if __name__ == '__main__':
    queryData()
