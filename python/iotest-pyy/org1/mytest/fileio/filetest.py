#coding=utf-8
#方式1
readfile =open("/opt/projects/python/iotestpy/mytest/fileio/a")
writefile= open("/opt/projects/python/iotestpy/mytest/fileio/b","w")
while True:
    line = readfile.readline()
    writefile.write("'"+line+"',")
    if not line:
        break
    print(line)
print("写入完成")
readfile.close()
writefile.close()
print("----------------------")
readfile =open("/opt/projects/python/iotestpy/mytest/fileio/a")
for s in readfile:
    print(s)
readfile.close()
writefile.close()