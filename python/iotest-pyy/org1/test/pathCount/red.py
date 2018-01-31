#!/usr/bin/env python
# coding=utf-8
import sys


def fun():
    offen = ""
    total = 0
    vehicles = ""
    word = None
    for line in sys.stdin:
        word,count = line.strip().rsplit("\t",1)
        num = count.split(",")[0]
        vehicle = count.split(",")[1]
        if offen == word:
            total += int(num)
            vehicles+=","+vehicle
        else:
            if offen:
                print(offen + "\t" + str(total)+"\t"+vehicles)
            offen = word
            vehicles =vehicle
            total = int(num)
    if offen == word:
        print( offen+ "\t" + str(total)+"\t"+vehicles)


if __name__ == "__main__":
    fun()
