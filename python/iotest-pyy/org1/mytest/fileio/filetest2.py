#coding=utf-8
def withopen1():
    writefile= open("/opt/projects/python/iotestpy/mytest/fileio/b","w")
    for line in open("/opt/projects/python/iotestpy/mytest/fileio/a"):
        writefile.write(line)
    print("写入完成")
    writefile.close()
#with open
def withopen2():
    with open("/opt/projects/python/iotestpy/mytest/fileio/a") as out:
        with open("/opt/projects/python/iotestpy/mytest/fileio/b","w")as fin:
            for line in out :
                fin.write(line)
                if not line:
                    break
            print("ok")
#with open2
def withopen3():
    with open("/opt/projects/python/iotestpy/mytest/fileio/a") as out:
        with open("/opt/projects/python/iotestpy/mytest/fileio/b","w")as fin:
            for line in out :
                fin.write(line)
                if not line:
                    break
            print("ok")
def withopen4():
    with open("/opt/projects/python/iotestpy/mytest/fileio/a","w")as f:
        print("hahahha",file=f)
    print("ok")
withopen4()

# f = open('EDC.jpg', 'rb')
# print(f.read())
# 输出 '\xff\xd8\xff\xe1\x00\x18Exif\x00\x00...' # 十六进制表示的字节

print("测试decode-------------")
f = open('b', 'rb')
u = f.read().decode('utf-8')
print(u)