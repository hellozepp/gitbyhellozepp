# coding=utf8
import random
import sys
#參數自動化
# 13002347570,00000000,0,00000000,67830053,16878319,2017-09-11 00:00:11,1505059211000,1505059212,0,430000,湖南省,430100,长沙市,786434,^,211,0:64:83373:786434:0:::31:430111:雨花区:19:,0,1505059211000,,_,8958043995223749683,湘AZ9328,黄色,重型自卸货车,12440,8350,2490,3450,TF-A6B
import math


# cat /opt/projects/python/iotestpy/mytest/mechineLearn/fileStore/clean_result|python /opt/projects/python/iotestpy/mytest/mechineLearn/Dbscan.py


class Tool:
    @staticmethod
    def tolongitude(longitude):  # 转化成经度
        return float(longitude) / 600000.0

    @staticmethod
    def tolatitude(latitude):  # 转化成纬度
        return float(latitude) / 600000.0

    @staticmethod
    def toseconds(timestamp):  # 转化成秒
        return float(timestamp) / 1000.0

    @staticmethod
    def getRad(d):
        return d * math.pi / 180.0

    @staticmethod
    def distance(long1, lati1, long2, lati2):  # 根据两个点的经纬度，计算两点之间的直线距离
        lng1 = Tool.tolongitude(long1)
        lat1 = Tool.tolatitude(lati1)
        lng2 = Tool.tolongitude(long2)
        lat2 = Tool.tolatitude(lati2)
        earth_radius = 6378137.0
        radLat1 = Tool.getRad(lat1)
        radLat2 = Tool.getRad(lat2)
        a = radLat1 - radLat2
        b = Tool.getRad(lng1) - Tool.getRad(lng2)
        s = 2 * math.asin(math.sqrt(
            math.pow(math.sin(a / 2), 2) + math.cos(radLat1) * math.cos(radLat2) * math.pow(math.sin(b / 2), 2)))
        s = s * earth_radius
        s = round(s * 10000) / 10000.0
        return s


def initNNeighbour(X, i, r):
    centre = X[i]  # 中心点
    lens = len(X[i])
    M_i = list()  # 初始化第i个cluster
    index = -1
    while (index < lens - 1):
        index += 1
        vec = X[index]
        if index == i:
            continue
        distance = Tool.distance(centre[0], centre[1], vec[0], vec[1])  # 计算向量差
        if distance <= r:  # 包含边界
            vec[2] = i  # 标记属于的集合
            # X[index]=vec
            M_i.append(i)
        else:
            vec[2] = -1  # 不在领域范围，跳过该点
            # X[index]=vec
    return M_i


def run():
    # todo -2:未访问 1~n:生成的聚簇 -1：不可达点
    X = list()  # 数据集合
    N = list()  # 邻域集合
    T = list()  # 生成的聚簇集合
    I = list()  # 下标集合
    density = 3
    r = 5.0
    # for line in sys.stdin:
    for line in open("/opt/projects/python/iotestpy/mytest/mechineLearn/fileStore/clean_result", "r",
                     encoding='UTF-8'):
        line = line.strip()
        seg = line.split(",")
        longitude = seg[4]
        latitude = seg[5]
        status = -2
        X.append([longitude, latitude, status])  # 迭代所有点进行初始化
    I = list(range(len(X)))
    while I:
        i = I[random.randint(0, len(I) - 1)]  # N随机选择的下标，代表i点
        I.remove(i)  # 随机选择角标并从集合中删除
        try:
            li1 = X[i]
        except (IndexError) as e:
            print(e)
        if int(li1[2]) == -2:  # 未处理点
            T = initNNeighbour(X, i, r)  # 返回噪点或m(i)的聚簇
            if len(T) < density:
                X.remove(li1)
                li1[2] = -1  # 暂时标记为 噪点
                X.append(li1)
                pass
                continue  # 领域集合密度不可达，选择下一个点
            else:
                X.remove(li1)
                li1[2] = i  # 归属为第i个聚类
                X.append(li1)
            # todo 迭代计算T聚簇 对T聚簇的每个点打label，并从T中删除
            while T:
                j = random.randint(0, len(T) - 1)
                N1 = T[j]
                T.remove(N1)
                try:
                    valX = X[N1]
                except (IndexError) as e:
                    print(e)
                # 发现X中未标记的点 和 密度不可达点
                if int(valX[2]) == -2 or int(valX[2]) == -1:
                    #N1[2] = i  # 标识所属聚簇
                    pass

                N_j = initNNeighbour(X, N1, r)  # N1为T集合j点存放X的下标
                if len(N_j) >= density:
                    # T = list(set(T).union(set(N_j)))
                    rem = X[N1]
                    X.remove(X[N1])
                    rem[2]=i # 标识所属聚簇
                    X.append(rem)
                    T = [val for val in T if val in N_j]
                    T = T.extend(N_j)
    # 输出数据集
    X1 = sorted(X, key=lambda l: int(l[2]))
    for i in X1:
        print(i)


if __name__ == '__main__':
    run()
