#coding=utf-8
#方式1
readfile =open("/opt/projects/python/iotestpy/mytest/fileio/a")
writefile= open("/opt/projects/python/iotestpy/mytest/fileio/b","w")
line = readfile.readlines()
writefile.write(str(line))#格式是列表格式
# print(type(line))
print("写入完成")
readfile.close()
writefile.close()
