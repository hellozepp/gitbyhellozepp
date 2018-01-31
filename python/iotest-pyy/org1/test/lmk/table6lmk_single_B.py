#!/usr/bin/env python
# coding:utf-8
#shell 并集 comm a b -1 -2 >c
import sys

reload(sys)
sys.setdefaultencoding('utf-8')

outputPath = "table6lmk_single_B.csv"
# outputPath = "table6lmk_single_C.csv"


def run():
    resSet = {}
    dict = {}
    cardTypeDict = {}  # lmk_both_single_main lmk_main lmk_single
    single = set([])
    main = set([])
    single_only = set([])
    main_only = set([])
    single_main = set([])
    checkSet = set([])

    with open("lmk_main", "r") as main_f:
        with open("lmk_single", "r") as single_f:
            with open("lmk_B", "r") as file:
                with open("lmk_one_city") as lmk_one_city:
                    with open("lmk_zhuan_same_city") as lmk_zhuan_same_city:
                        with open("lmk_other_diff_city") as lmk_other_diff_city:
                            with open("lmk_other_same_city") as lmk_other_same_city:
                                with open("lmk_zhuan_diff_city") as lmk_zhuan_diff_city:
                                    for line in main_f:
                                        main.add(line.strip())
                                    for line in single_f:
                                        single.add(line.strip())
                                    main_only = main - single
                                    single_main = single & main
                                    single_only = single - single_main

                                    for line in file:
                                        dict.setdefault(line.strip().split("@")[0])
                                    else:
                                        print("dict len is:", len(dict))
                                    lambd = lambda a, b: a in b
                                    # 主副卡
                                    count = 0
                                    for line in lmk_one_city:
                                        if lambd(line.strip().split("@")[0], dict) and lambd(line.strip().split("@")[0],
                                                                                             main_only):
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
                                    else:
                                        print(str(count))
                                    count = 0
                                    for line in lmk_zhuan_same_city:
                                        if line.strip().split("@")[0] in dict and lambd(line.strip().split("@")[0],
                                                                                        main_only):
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
                                    else:
                                        print(str(count))
                                    count = 0
                                    for line in lmk_zhuan_diff_city:
                                        if line.strip().split("@")[0] in dict and lambd(line.strip().split("@")[0],
                                                                                        main_only):
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
                                    else:
                                        print(str(count))
                                    count = 0
                                    for line in lmk_other_same_city:
                                        if line.strip().split("@")[0] in dict and lambd(line.strip().split("@")[0],
                                                                                        main_only):
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
                                    else:
                                        print(str(count))
                                    count = 0
                                    for line in lmk_other_diff_city:
                                        if line.strip().split("@")[0] in dict and lambd(line.strip().split("@")[0],
                                                                                        main_only):
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
                                    else:
                                        print(str(count))
                                    with open(outputPath, "w") as f:
                                        f.write("仅持主副卡\n")
                                        for key in resSet:
                                            f.write(key + "," + str(resSet.get(key)) + "\n")
                                        resSet.clear()
                                    lmk_zhuan_diff_city.seek(0)
                                    lmk_other_same_city.seek(0)
                                    lmk_other_diff_city.seek(0)
                                    lmk_zhuan_same_city.seek(0)
                                    lmk_one_city.seek(0)

                                    # 单卡
                                    count = 0
                                    for line in lmk_one_city:
                                        if lambd(line.strip().split("@")[0], dict) and lambd(line.strip().split("@")[0],
                                                                                             single_only):
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
                                    else:
                                        print(str(count))
                                    count = 0
                                    for line in lmk_zhuan_same_city:
                                        if line.strip().split("@")[0] in dict and lambd(line.strip().split("@")[0],
                                                                                        single_only):
                                            count += 1
                                            if line.strip().split("@")[0] in checkSet:
                                                print ("lmk_zhuan_same_city重复车：" + line.strip().split("@")[0])
                                                continue
                                            else:
                                                checkSet.add(line.strip().split("@")[0])
                                            if not resSet.get("2固定（省内）"):
                                                resSet["2固定（省内）"] = 1
                                            else:
                                                resSet["2固定（省内）"] = resSet.get("2固定（省内）") + 1
                                    else:
                                        print(str(count))
                                    count = 0
                                    for line in lmk_zhuan_diff_city:
                                        if line.strip().split("@")[0] in dict and lambd(line.strip().split("@")[0],
                                                                                        single_only):
                                            count += 1
                                            if line.strip().split("@")[0] in checkSet:
                                                print ("lmk_zhuan_diff_city重复车：" + line.strip().split("@")[0])
                                                continue
                                            else:
                                                checkSet.add(line.strip().split("@")[0])
                                            if not resSet.get("3固定（跨省）"):
                                                resSet["3固定（跨省）"] = 1
                                            else:
                                                resSet["3固定（跨省）"] = resSet.get("3固定（跨省）") + 1
                                    else:
                                        print(str(count))
                                    count = 0
                                    for line in lmk_other_same_city:
                                        if line.strip().split("@")[0] in dict and lambd(line.strip().split("@")[0],
                                                                                        single_only):
                                            count += 1
                                            if line.strip().split("@")[0] in checkSet:
                                                print ("lmk_other_same_city重复车：" + line.strip().split("@")[0])
                                                continue
                                            else:
                                                checkSet.add(line.strip().split("@")[0])
                                            if not resSet.get("4散兵（省内）"):
                                                resSet["4散兵（省内）"] = 1
                                            else:
                                                resSet["4散兵（省内）"] = resSet.get("4散兵（省内）") + 1
                                    else:
                                        print(str(count))
                                    count = 0
                                    for line in lmk_other_diff_city:
                                        if line.strip().split("@")[0] in dict and lambd(line.strip().split("@")[0],
                                                                                        single_only):
                                            count += 1
                                            if line.strip().split("@")[0] in checkSet:
                                                print ("lmk_other_diff_city重复车：" + line.strip().split("@")[0])
                                                continue
                                            else:
                                                checkSet.add(line.strip().split("@")[0])
                                            if not resSet.get("5散兵（跨省）"):
                                                resSet["5散兵（跨省）"] = 1
                                            else:
                                                resSet["5散兵（跨省）"] = resSet.get("5散兵（跨省）") + 1
                                    else:
                                        print(str(count))
                                    with open(outputPath, "a") as f:
                                        f.write("仅持单卡\n")
                                        for key in resSet:
                                            f.write(key + "," + str(resSet.get(key)) + "\n")
                                        resSet.clear()
                                    lmk_zhuan_diff_city.seek(0)
                                    lmk_other_same_city.seek(0)
                                    lmk_other_diff_city.seek(0)
                                    lmk_zhuan_same_city.seek(0)
                                    lmk_one_city.seek(0)
                                    print ("the check size :" + str(len(checkSet)))
                                    # both
                                    count = 0
                                    for line in lmk_one_city:

                                        if lambd(line.strip().split("@")[0], dict) and lambd(line.strip().split("@")[0],
                                                                                             single_main):
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
                                    else:
                                        print(str(count))
                                    count = 0
                                    for line in lmk_zhuan_same_city:
                                        if line.strip().split("@")[0] in dict and lambd(line.strip().split("@")[0],
                                                                                        single_main):
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
                                    else:
                                        print(str(count))
                                    count = 0
                                    for line in lmk_zhuan_diff_city:
                                        if line.strip().split("@")[0] in dict and lambd(line.strip().split("@")[0],
                                                                                        single_main):
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
                                    else:
                                        print(str(count))
                                    count = 0
                                    for line in lmk_other_same_city:
                                        if line.strip().split("@")[0] in dict and lambd(line.strip().split("@")[0],
                                                                                        single_main):
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
                                    else:
                                        print(str(count))
                                    count = 0
                                    for line in lmk_other_diff_city:
                                        if line.strip().split("@")[0] in dict and lambd(line.strip().split("@")[0],
                                                                                        single_main):
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
                                    else:
                                        print(str(count))
                                    with open(outputPath, "a") as f:
                                        f.write("同时持有单卡、主副卡\n")
                                        for key in resSet:
                                            f.write(key + "," + str(resSet.get(key)) + "\n")
                                        resSet.clear()


if __name__ == "__main__":
    run()
