from sys import argv
files = input("File Name:")
script, input_file = argv, files

#定义函数，打印读取的文件
def print_all(f):
    print(f.read(),"\n===============================")

#查找文件行数
def rewind(f):
    f.seek(0)
#定义函数，并打印文件行数和对应内容
def print_a_line(line_count,  f):
    print(line_count, f.readline())


current_file = open(input_file)
print("First let's print the whole file:\n")
print_all(current_file)
print("Now let's rewind, kind of like a tape.")
rewind(current_file)
print("Let's print three lines:")
current_line = 1
print_a_line(current_line, current_file)
current_line = current_line + 1
print_a_line(current_line, current_file)
current_line = current_line + 1
print_a_line(current_line, current_file)
