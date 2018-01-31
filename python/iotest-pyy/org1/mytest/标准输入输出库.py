import sys

 #strip默认删除空白符（包括'\n', '\r',  '\t',  ' ')
print(">>>")
#没有代码提示
read=sys.stdin.readline().strip()
print(read.split())#默认只切空格
# 在Python 3.2.3中  input和raw_input 整合了，没有了raw_input
# raw_input(">>>")

#等价
input(">>>")


sys.stdout.write(read+'\n')
#等价
print('hello')

print("----------------------")
print("\t\"")

