#coding: utf-8
from sys import argv

filename = raw_input("��Ҫ�������ļ���:")
script, filename = argv, filename

print "We're going to erase %r." % filename
print "If you don't want that, hit CTRL-C (^C)."
print "If you do want that, hit RETURE."

raw_input("?")

print "Opening the file..."
target = open(filename,  'w')

print "Truncating the file. Goodbye!"
target.truncate()

print "Now I'm going to ask you for three lines."

line1 = raw_input("line 1:")
line2 = raw_input("line 2:")
line3 = raw_input("line 3:")

print "I'm going to write these to the file."

formatter = "%s %s %s"
target.write(formatter % (line1, line2, line3))
target.write("\n")

print "And finally, we close it."
target.close()
