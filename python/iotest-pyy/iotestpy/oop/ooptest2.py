class Person:
    def __init__(self,id,name):
        self.__id=id
        self.__name=name

    @property
    def name(self):
        print("xxxxx")
        return self.__name

    @name.setter
    def name(self,name):
        print("yyyyy")
        self.__name=name

    def __str__(self):
        return "str id: "+str(self.__id)+" name: "+self.__name

    def __repr__(self):
        return "repr id: " + str(self.__id) + " name: " + self.__name

    def xxx(self):
        pass


if __name__ == "__main__":
    p1=Person(10,"aaa")
    #print("id: "+str(p1.__id))#AttributeError: 'Person' object has no attribute '__id'
    print("id: "+str(p1._Person__id)) #实际上没有真正的隐藏掉
    p1.name="bbb"
    print("name: "+p1.name)
    print(p1)

    print(Person.__dict__)

    print(p1.__dict__)
    print("-----------vars(p1)---------")
    print(vars(p1))
