#coding: utf-8
from sys import argv
# exists将文件名字符串作为参数，如果文件存在的话，它将返回True
from os.path import exists
# script, from_file, to_file = argv, raw_input("from_file:"), raw_input("to_file:")
script, from_file, to_file = argv, "ex17.py","ex17_sample.txt"
print("Copying from %s to %s" % (from_file, to_file))
# we could do these two on one line too, how?
input = open(from_file)
indata = input.read()
print("The input file is %d bytes long" % len(indata))
print("Does the output file exist? %r" % exists(to_file))
print("Ready, hit RETURN to continue, CTRL-C to abort.")
input()
output = open(to_file, 'a')#追加
output.write(indata)

print("Alright, all done.")
output.close()
input.close()
# I'm going to write these to the file.
# I'm going to write these to the file.
# I'm going to write these to the file.
# I'm going to write these to the file.
# I'm going to write these to the file.
# I'm going to write these to the file.
# I'm going to write these to the file.
# I'm going to write these to the file.
# I'm going to write these to the file.