import sys
inpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/input.txt"
outpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/output.txt"

f=open(inpath,'r')
print(f.tell())
print(f.read(1))
print(f.read(1))
print(f.tell())
print(f.seek(4))
print(f.read(1))
f.close()

# =======================================================================
print("=======================================================================")

f=open(outpath,'r+b')
f.seek(2)
f.write(b'0')
f.flush()
f.seek(0)
print(f.read())
f.close()
