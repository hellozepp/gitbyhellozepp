import sys
inpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/input.txt"
f=open(inpath,'r')
arr=f.readlines()
print(arr)
f.close()

# =======================================================================
print("=======================================================================")
with open(inpath,'r') as f:
    while True:
        line=f.readline()
        if not line:
            break
        print(line,end="")

print()
# =======================================================================
print("=======================================================================")

with open(inpath) as f:
    for line in f:
        print(line,end="")

print()