# coidng=utf-8
import os

import sklearn

try:
    import cPickle as pickle
except ImportError:
    import pickle

class Dataset:
    x = []
    y = []
    def __init__(self):
        pass

    def load_data(self, path):
        if os.path.exists(path):
            for data in open(path):
                data = data.replace("\n", "")#去掉readline的/n
                data = data.strip()
                print(data)
                x = data[0:-2]
                y = int(data[-1])
                self.x += eval("[" + x + "]")
                self.y.append(y)
            print("原始数据为：\n", self.x)
            print("label为：", self.y)
        else :
            print("路径不存在")
            return

    def get_train_test_set(self, ratio):
        n_train=int(len(self.x)*ratio)
        x_train=self.x[:n_train]
        x_text=self.x[n_train:]
        n_train=int(len(self.y)*ratio)
        y_train = self.y[:n_train]
        y_text = self.y[n_train:]
        return x_train,x_text,y_train,y_text
#持久化为json'
f=open("/opt/projects/python/iotestpy/mytest/mechineLearn/fileStore/01","wb+")
dataset = Dataset()
dataset.load_data(os.path.abspath("/opt/projects/python/iotestpy/mytest/mechineLearn/fileStore/pima-indians-diabetes.txt"))
pickle.dump(dataset.get_train_test_set(0.7),f)


#加载
f=open("/opt/projects/python/iotestpy/mytest/mechineLearn/fileStore/01","rb")
x_train,x_text,y_train,y_text=pickle.load(f)
print("训练集数据：\n",x_train)
print("训练集label：\n",y_train)
print("测试集数据：\n",x_text)
print("测试集label：\n",y_text)

# x= sklearn.metrics.auc(x_train, x_text, reorder=False)
# print(x)
# y= sklearn.metrics.auc(y_train, y_text, reorder=False)




