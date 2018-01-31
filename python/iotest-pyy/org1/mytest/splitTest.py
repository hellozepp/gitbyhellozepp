str = "1\t2\t3"
word,count=str.rsplit('\t',1)
print(word)
print(count)
str = ","
print(len(str.split(",")))
str = "1,"
print(len(str.split(",")))
str = ",,"
print(len(str.split(",")))
str = ""
print(len(str.split(",")))