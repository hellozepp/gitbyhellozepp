import csv

inpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/inputcsv.txt"
outpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/outputcsv.txt"
outpath2="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/outputdict.txt"

with open(inpath) as f:
    for row in csv.reader(f,delimiter=","):
        print(row)

with open(inpath) as fi:
    with open(outpath,"w") as fo:
        rows=csv.reader(fi)
        csv.writer(fo).writerows(rows)

# =======================================================================
print("=======================================================================")

person=["id,name","1,aaa","2,bbb"]
for row in csv.DictReader(person):
    print(row)

person=["1,aaa","2,bbb"]
for row in csv.DictReader(person,fieldnames=["id","name"]):
    print(row)

person=[{"id":1,"name":"aaa"},{"id":2,"name":"bbb"}]

with open(outpath2,"w") as f:
    writer=csv.DictWriter(f,fieldnames=["id","name"])
    writer.writeheader()
    writer.writerows(person)




