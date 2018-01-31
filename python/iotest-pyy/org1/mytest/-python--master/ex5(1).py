#(*^__^*)coding: utf-8
import datetime
PRINT = "Hello \nWorld!"
print("%s" % PRINT)
print("%r" % PRINT) #多了单引号
print("%r" % 1) #int是没有变化
d = datetime.date.today()
print(d)
print("%r" % d)
# %r打印时能够重现它所代表的对象
