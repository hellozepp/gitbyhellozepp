#!/usr/bin/env python
# coding=utf-8
import sys

import os


def fun():
    for line in sys.stdin:
        split = line.strip().split("\t")
        if len(split) < 2:
            continue
        vehicleNO =  split[0].split("_")[0].split("@")[0]
        often = split[0].split("_")[1]
        if split[1]:
            count = len(split[1].split(","))
            print(often+"\t"+str(count)+","+vehicleNO)

if __name__ == "__main__":
    fun()
