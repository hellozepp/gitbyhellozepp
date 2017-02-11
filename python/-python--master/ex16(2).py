from sys import argv

filename = raw_input("Filename:")
filename = filename

print "We're going to erase %r." % filename

print "If you don't want that, hit CTRL-C (^C)."
print "If you do want that, hit RETURE."

raw_input("?")

print "Opening the file..."
target = open(filename,  'w')

print "Truncating the file. Goodbye!"#ex15_sample.txt
target.truncate()

print "Now I'm going to ask you for three lines."

line1 = raw_input("line 1:")
line2 = raw_input("line 2:")
line3 = raw_input("line 3:")

print "I'm going to write these to the file."

target.write(line1)
target.write("\n")
target.write(line2)
target.write("\n")
target.write(line3)
target.write("\n")

print "And finally, we close it."
target.close()

script, filename = argv, filename
txt = open (filename)

print "Here's your file %r:" % filename
print txt.read()
txt.close()
