#!/usr/bin/env python
# coding:utf-8
import sys

reload(sys)
sys.setdefaultencoding('utf-8')

outputPath = "table6hy_c.csv"


def run():
    resSet = {}
    dict = {}
    checkSet = set([])
    with open("hy_C", "r") as file:
        with open("hy_one_city") as hy_one_city:
            with open("hy_zhuan_same_city") as hy_zhuan_same_city:
                with open("hy_other_diff_city") as hy_other_diff_city:
                    with open("hy_other_same_city") as hy_other_same_city:
                        with open("hy_zhuan_diff_city") as hy_zhuan_diff_city:
                            for line in file:
                                dict.setdefault(line.strip())
                            else:
                                print("dict len is:", len(dict))
                            count = 0
                            for line in hy_one_city:
                                if line.strip() in dict:
                                    count += 1
                                    if line.strip().split("@")[0] in checkSet:
                                        print ("lmk_one_city重复车：" + line.strip().split("@")[0])
                                        continue
                                    else:
                                        checkSet.add(line.strip().split("@")[0])
                                    if not resSet.get("1本地运营"):
                                        resSet["1本地运营"] = 1
                                    else:
                                        resSet["1本地运营"] = resSet.get("1本地运营") + 1
                            else:print(str(count))
                            count = 0
                            for line in hy_zhuan_same_city:
                                if line.strip() in dict:
                                    count += 1
                                    if line.strip().split("@")[0] in checkSet:
                                        print ("lmk_one_city重复车：" + line.strip().split("@")[0])
                                        continue
                                    else:
                                        checkSet.add(line.strip().split("@")[0])
                                    if not resSet.get("2固定（省内）"):
                                        resSet["2固定（省内）"] = 1
                                    else:
                                        resSet["2固定（省内）"] = resSet.get("2固定（省内）") + 1
                            else:print(str(count))
                            count = 0
                            for line in hy_zhuan_diff_city:
                                if line.strip() in dict:
                                    count += 1
                                    if line.strip().split("@")[0] in checkSet:
                                        print ("lmk_one_city重复车：" + line.strip().split("@")[0])
                                        continue
                                    else:
                                        checkSet.add(line.strip().split("@")[0])
                                    if not resSet.get("3固定（跨省）"):
                                        resSet["3固定（跨省）"] = 1
                                    else:
                                        resSet["3固定（跨省）"] = resSet.get("3固定（跨省）") + 1
                            else:print(str(count))
                            count = 0
                            for line in hy_other_same_city:
                                if line.strip() in dict:
                                    count += 1
                                    if line.strip().split("@")[0] in checkSet:
                                        print ("lmk_one_city重复车：" + line.strip().split("@")[0])
                                        continue
                                    else:
                                        checkSet.add(line.strip().split("@")[0])
                                    if not resSet.get("4散兵（省内）"):
                                        resSet["4散兵（省内）"] = 1
                                    else:
                                        resSet["4散兵（省内）"] = resSet.get("4散兵（省内）") + 1
                            else:print(str(count))
                            count = 0
                            for line in hy_other_diff_city:
                                if line.strip() in dict:
                                    count += 1
                                    if line.strip().split("@")[0] in checkSet:
                                        print ("lmk_one_city重复车：" + line.strip().split("@")[0])
                                        continue
                                    else:
                                        checkSet.add(line.strip().split("@")[0])
                                    if not resSet.get("5散兵（跨省）"):
                                        resSet["5散兵（跨省）"] = 1
                                    else:
                                        resSet["5散兵（跨省）"] = resSet.get("5散兵（跨省）") + 1
                            else:print(str(count))
    with open(outputPath, "w") as f:
        for key in resSet:
            f.write(key + "," + str(resSet.get(key))+"\n")


if __name__ == "__main__":
    run()
