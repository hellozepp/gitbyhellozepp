#!/usr/bin/env python
#--*-- coding:utf-8 --*--

import sys


def run():
    for line in sys.stdin:
        line = line.strip()
        print(line)


if __name__ == '__main__':
    run()
