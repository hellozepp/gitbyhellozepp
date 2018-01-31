#coding: utf-8
# Open a file
fo = open("foo.txt", "r+")
print("Name of the file: ", fo.name)

# Assuming file has following 5 lines
# This is 1st line
# This is 2nd line
# This is 3rd line
# This is 4th line
# This is 5th line

line = fo.readline()
print("Read Line: %s" % (line))

# Now truncate remaining file.
fo.truncate()
# truncate() 方法用于截断文件，如果指定了可选参数 size，
# 则表示截断文件为 size 个字符。 如果没有指定 size，则从当前位置起截断；截断之后 size 后面的所有字符被'删除'。
# Try to read file now
line = fo.readline()
print("Read Line: %s" % (line))

# Close opend file
fo.close()
