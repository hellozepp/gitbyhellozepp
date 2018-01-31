import datetime,pytz
#pytz需要安装

tz=pytz.timezone("Asia/Shanghai")
d=datetime.datetime(year=1986, month=5, day=4, hour=0, minute=30, second=0,
                microsecond=78, tzinfo=tz)

print("年：{} 月：{} 日：{} 时：{} 分：{} 秒：{} 亚秒：{} 时区：{}".format(d.year,d.month,d.day,d.hour,d.minute,d.second,d.microsecond,d.tzinfo))


d=tz.normalize(d) #用来修正神奇的没听说过的夏令时

print("年：{} 月：{} 日：{} 时：{} 分：{} 秒：{} 亚秒：{} 时区：{}".format(d.year,d.month,d.day,d.hour,d.minute,d.second,d.microsecond,d.tzinfo))

#===========================================================
print("===========================================================")

from datetime import date,datetime

print(datetime.today())
print(datetime.now())
print(datetime.now().strftime('%Y-%m-%d %H-%M-%S'))

#===========================================================
print("===========================================================")

import time

s = datetime(2012,6,22,5,5,5)
print(time.mktime(s.timetuple()))

timeTuple = time.localtime(1340312705.0)
print(time.strftime('%Y-%m-%d %H-%M-%S',timeTuple))