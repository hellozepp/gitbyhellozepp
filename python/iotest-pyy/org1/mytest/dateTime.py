import datetime
now = datetime.datetime.now()
print(now)
now = now.strftime('%Y-%m-%d')
print(now=="2017-11-26")
print(type(now))

datatimeStr = datetime.date(year=2017,month=12,day=1).strftime("%Y%m%d")
print(type(datatimeStr))

print( datetime.datetime.now().strftime('%Y%m%d') <= datatimeStr)