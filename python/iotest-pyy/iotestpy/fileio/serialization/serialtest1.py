import pickle

outpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/outputp.txt"

person={"id":1,"name":"aaa","score":[100,98,99]}

pickled=pickle.dumps(person)

print(pickled)

print(pickle.loads(pickled))

# =======================================================================
print("=======================================================================")

with open(outpath,"wb") as f:
    pickle.dump(person,file=f)

with open(outpath,"rb") as f:
    print(pickle.load(file=f))