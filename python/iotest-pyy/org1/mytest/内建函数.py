#coding=utf-8
import time
print(time.time())#1504421484.471333
print(time.localtime())
#time.struct_time(tm_year=2017, tm_mon=9, tm_mday=3, tm_hour=14, tm_min=51, tm_sec=24, tm_wday=6, tm_yday=246, tm_isdst=0)
for i in range(3):
    time.sleep(0.5)
    print("Tick!")
import datetime
print("today is: ", datetime.date.today())#2017-09-03
print("now is: ", datetime.datetime.now())#2017-09-03 14:53:18.142574
datetime1=datetime.date(2016,6,4)
print("type:",type(datetime1),datetime1)
print(datetime.time(14,00))
# 计算昨天和明天的日期
import datetime
today = datetime.date.today()
yesterday = today - datetime.timedelta(days=1)
tomorrow = today + datetime.timedelta(days=1)
print(yesterday,today,tomorrow)

# enumerate函数
print("enumerate函数================")
l = [1,2,3]
# enumerate会将数组或列表组成一个索引序列。使我们再获取索引和索引内容的时候更加方便如下：
for index,text in enumerate(l):
   print(index ,text)

#v集合collections模块
print("集合collections模块================")
from collections import namedtuple
Point = namedtuple('Point', ['x', 'y'])
p = Point(1, 2)
print(p.x)
print(p.y)

from collections import deque
q = deque(['a', 'b', 'c'])
q.append('x')
q.appendleft('y')
print(q)

from collections import defaultdict
dd = defaultdict(lambda: 'N/A')
dd['key1'] = 'abc'
print(dd['key1']) # key1存在
print(dd['key2']) # key2不存在，返回默认值 N/A

from collections import OrderedDict
d = dict([('a', 1), ('b', 2), ('c', 3)])
print(d) # dict的Key是无序的，{'a': 1, 'c': 3, 'b': 2}
od = OrderedDict([('a', 1), ('b', 2), ('c', 3)])
print(od) # OrderedDict的Key是有序的，OrderedDict([('a', 1), ('b', 2), ('c', 3)])

from collections import Counter
c = Counter()
for ch in 'programming':
    c[ch] = c[ch] + 1
print(c) #Counter({'g': 2, 'm': 2, 'r': 2, 'a': 1, 'i': 1, 'o': 1, 'n': 1, 'p': 1})
print("迭代器模块================")
import itertools
for i in zip(itertools.count(1), ['a', 'b', 'cc',"cc"]):
    print(i)
