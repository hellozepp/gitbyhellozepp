class Person:
    X=1
    def __init__(self,id,name):
        self.id=id
        self.name=name

    def xxx(self):
        print(self.id)

    def __str__(self):
        return "str id: "+str(self.id)+" name: "+self.name

    def __repr__(self):
        return "repr id: " + str(self.id) + " name: " + self.name

if __name__ == "__main__":
    p1=Person(1,"aaa")
    Person.xxx(p1)
    p1.xxx()
    print(p1)
    print(str(p1))
    print(repr(p1))
    print("id: "+str(p1.id)+" name: "+p1.name)
    print(Person.__dict__)
    p=Person(1,"aaa")
    p.X=2
    print(p.X)
    print(p.__dict__)
    print(Person.X)