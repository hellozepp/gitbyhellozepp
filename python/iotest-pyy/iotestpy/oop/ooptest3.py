class Person:

    def __init__(self,id,name):
        print("Person init")
        self.__id=id
        self.__name=name

    @staticmethod
    def run():
        print("runing...")

    @classmethod      #比staticmethod默认多传入一个类类型
    def newInstance(clz,id,name):
        print("classmethod: "+str(clz))
        return clz(id,name)

    def __str__(self):
        return "str id: "+str(self.__id)+" name: "+self.__name

if __name__ == "__main__":
    Person.run()
    p=Person.newInstance(2,"ccc")
    # p=eval("Person").newInstance(2,"ccc")

    print("="*50)

    a=1
    print("1: "+str(type(a)))
    print("1: "+str(a.__class__))
    print("1: " + str(type(a.__class__)))
    print(type(Person))
    print(type(p))
    print(p.__class__)

    print(p)