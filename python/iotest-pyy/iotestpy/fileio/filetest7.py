import os
import sys
inpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/input2.txt"
outpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/output2.txt"

from io import FileIO,BufferedReader,TextIOWrapper

with BufferedReader(FileIO(inpath,'r')) as f:
    print(f.read().decode("utf-8"))

# =======================================================================
print("=======================================================================")

with TextIOWrapper(BufferedReader(FileIO(inpath,'r')),"utf-8") as f:
    print(f.read())

# =======================================================================
print("=======================================================================")

import io

b=io.BytesIO(b'\xe4\xbd\xa0\xe5\xa5\xbd\xe4\xb8\x96\xe7\x95\x8c\xef\xbc\x81')
print(b.read().decode("utf-8"))

b.seek(3)
b.write(b'\xe4\xbd\xa0')
b.seek(0)
print(b.read(9).decode("utf-8"))
print(b.getvalue().decode("utf-8"))
b.close()

# =======================================================================
print("=======================================================================")

s=io.StringIO()

s.write("你好abc\n")
s.write("世界abc")
print(s.getvalue())
s.close()