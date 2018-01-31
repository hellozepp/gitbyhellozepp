class MyIter:
    def __init__(self,id):
        self.__id=id
    def __iter__(self):
        print("执行了iter")
        return self
    def __next__(self):
        print("执行了next")
        if self.__id+1>10:
            raise StopIteration
        self.__id+=1
        return self.__id

myiter=MyIter(1)
print("==========")
for i in myiter:
    print(i,end=" ")



print("==========")
myiter=MyIter(1)
it=iter(myiter)
for i in it:
    print(i)

print("==========")
myiter=MyIter(1)
while True:
    try:
        i=next(myiter)
    except StopIteration:
        break
    print(i)
