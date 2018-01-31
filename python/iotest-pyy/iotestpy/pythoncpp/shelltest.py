import os

result=os.popen("bash s.sh")
str=result.readline().rstrip("\n")
print("hello:",str)

str=result.readline().rstrip("\n")
print("hello:",str)