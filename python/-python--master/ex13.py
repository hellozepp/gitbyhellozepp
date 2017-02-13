from sys import argv
#argv 获取绝对路径
first = raw_input("Name: ")
second = raw_input("Name: ")
third = raw_input("Name: ")

script, first, second, third = argv, first, second, third

print "The script is called: ", script
print "Your first variable is:", first
print "Your second variable is:", second
print "Your third variable is:", third
