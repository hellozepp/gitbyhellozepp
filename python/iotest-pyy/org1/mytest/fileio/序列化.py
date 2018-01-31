try:
    import cPickle as pickle
except ImportError:
    import pickle

# 此处定义一个dict字典对象
d = dict(name='思聪', age=29, score=80)
str = pickle.dumps(d) # 调用pickle的dumps函数进行序列化处理
print(str)

f = open('dump.txt', 'wb')
pickle.dump(d, f)
f.close() # 最后关闭掉文件资源
f = open('dump.txt', 'rb') # 设定文件选项模式为rb
d = pickle.load(f) # 调用load做反序列处理过程
f.close() # 关闭文件资源
print(d)
print('name is %s' % d['name'])

import json

# 定义dict字典对象
d1 = dict(name='小王', age=20, score=80)
str = json.dumps(d1)  # 调用json的dumps函数进行json序列化处理
print(str)

# 调用json的loads函数进行反序列化处理
d2 = json.loads(str)