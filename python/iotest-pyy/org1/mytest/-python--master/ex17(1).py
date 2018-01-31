from sys import argv
from os.path import exists

from_file = input("From file:")
to_file = input("To file:")
script, from_file, to_file = argv, from_file, to_file
input = open(from_file) 
output = open(to_file, 'a')
output.write(input.read())
output.close()
input.close()
