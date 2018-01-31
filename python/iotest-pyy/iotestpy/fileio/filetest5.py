import os
import sys
inpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/input2.txt"
outpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/output2.txt"

sys.stdin=open(inpath)
print(input())

# =======================================================================
print("=======================================================================")

with open(outpath,"w") as f:
    print("你好世界aaaaa！",file=f)