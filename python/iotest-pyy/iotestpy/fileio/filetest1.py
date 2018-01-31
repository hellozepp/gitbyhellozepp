import sys
inpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/input.txt"
outpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/output.txt"

with open(inpath,'r',encoding='UTF-8',errors='ignore') as src,open(outpath,'w') as dest:
    context = src.read()
    dest.write(context)
    print(src.readable())
    print(src.writable())
