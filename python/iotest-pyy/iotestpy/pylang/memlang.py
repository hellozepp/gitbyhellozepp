#coding=utf-8

i=10
j=10
print(id(i))
print(id(j))

mylist=[1,2,3,4,5]
mylist1=[1,2,3,4,5]

print(id(mylist))
print(id(mylist1))

t1=(1,2,3,4,5)
t2=(1,2,3,4,5)
print(id(t1))
print(id(t2))
print("=========================0===========================")
print("测试赋值")
li1 = [1,2,3]
li2 = li1
print(id(li1)==id(li2))
li1 = {1,2,3}
li2 = li1
print(id(li1)==id(li2))
li1.add("abc")
print(li2)
#=====================================================
print("=========================1===========================")

def change1(t):
    print(id(t))

def change2(t):
    t[2]=100
    print(id(t))

def change3(t):
    # t[2]=100 #不可变
    print(id(t))

def change4(t):
    t.add("4")
    print(id(t))

def change5(t):
    t["c"]=100
    print(id(t))

i=10
change1(i)
print(id(i))
print("------------2---------------")

mylist=[1,2,3,4,5]
change2(mylist)
print(id(mylist))
print(mylist)
print("------------3---------------")

t1=(1,2,3,4,5)
change3(t1)
print(id(t1))
print(t1)

print("------------4---------------")

t1={"1","2","3"}
change4(t1)
print(id(t1))
print(t1)

print("------------5---------------")

t1={"a":"1","b":"2","c":"3"}
change5(t1)
print(id(t1))
print(t1)