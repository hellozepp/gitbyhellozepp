import os
print(os.name)
thisPath=os.path.abspath(".")
fileName = "创建的文件夹"
thisPath=os.path.join(thisPath,fileName)
if os.path.exists(thisPath):
    os.remove(thisPath+"/创建的文件")
    os.rmdir(thisPath)
os.mkdir(thisPath,0o777)
file =os.path.join(thisPath,"创建的文件")
touch = open(file,"w")
touch.write("a")
#工具
import shutil
# shutil.copyfile('/opt/projects/python/iotest-py/mytest/fileio/a', file)
print(os.path.abspath("/opt/projects/python/iotestpy/mytest/mechineLearn/fileStore/pima-indians-diabetes.txt"))
print(os.path.exists())
