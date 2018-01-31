import os
import sys
inpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/input.txt"
outpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/output.txt"

context=None
with open(inpath,'rb') as f:
    context=f.read()
    print(context)

l=list(context)
print(l)

# =======================================================================
print("=======================================================================")

arr=bytearray(os.path.getsize(inpath))

with open(inpath,'rb') as f:
    f.readinto(arr)

print(arr[0])
print(arr)
print(bytes(arr))
print(arr.decode("utf-8"))
