#coding:utf-8
from sys import argv
from os.path import exists

script, from_file, to_file = argv
#ValueError: need more than 1 value to unpack
print("Copying from %s to %s" % (from_file, to_file))
# we could do these two on one line too, how?
input = open(from_file)
indata = input.read()
print("The input file is %d bytes long" % len(indata))
print("Does the output file exist? %r" % exists(to_file))
print("Ready, hit RETURN to continue, CTRL-C to abort.")
input()
output = open(to_file, 'w')
output.write(indata)

print("Alright, all done.")
output.close()
input.close()