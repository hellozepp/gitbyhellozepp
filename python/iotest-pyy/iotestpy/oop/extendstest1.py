class Person:
    def __init__(self,id,name):
        self.__id=id
        self.__name=name

    def __str__(self):
        return "id: "+str(self.__id)+" name: "+self.__name


class Stu(Person):
    def __init__(self,id,name,score):
        super().__init__(id,name)
        self.__score=score

    def __str__(self):
        return super().__str__()+" score: "+str(self.__score)

if __name__=="__main__":
    p=Person(1,"aaa")
    print(p)

    s=Stu(2,"bbb",98)
    print(s)