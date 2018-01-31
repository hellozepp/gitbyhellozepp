import shelve

outpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/outputs.txt"

person=shelve.open(outpath)
person["id"]=1
person["name"]="aaa"
person["score"]=[100,99,98]

person.close()

person=shelve.open(outpath)
print(person["score"])
person.sync()
print(person["score"])

person.close()


