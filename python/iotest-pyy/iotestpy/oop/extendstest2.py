from abc import abstractmethod, ABCMeta
from functools import total_ordering

class Person(metaclass=ABCMeta):
    def __init__(self,id,name):
        self.__id=id
        self.__name=name

    def __str__(self):
        return "id: "+str(self.__id)+" name: "+self.__name

    @abstractmethod
    def run(self):
        pass


@total_ordering  #有了这个仅仅实现大于和等于或者小于和等于就可以推算出所有的关系运算了
class Stu(Person):
    def __init__(self,id,name,score):
        super().__init__(id,name)
        self.__score=score

    def __str__(self):
        return super().__str__()+" score: "+str(self.__score)

    def run(self):
        print("stu running...")

    def __gt__(self, other):
        return self.__score > other.__score

    def __eq__(self, other):
        return self.__score == other.__score


if __name__=="__main__":

    s1=Stu(2,"bbb",98)
    print(s1)
    s1.run()

    s2=Stu(3,"ccc",100)

    print(s1>s2)

    print(s1 <= s2)

    print(s1==s2)