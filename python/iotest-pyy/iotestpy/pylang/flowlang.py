#coding=utf-8
a=0
# if a<5 and a>1:
if 1<a<5:
        print("1-5")
elif a<10:
    print("<10")
else:
    print(">=10")
print("=======================1=============================")
#=====================================
while True:
    a=a+1
    if a%2==0:
        break
        # continue
else:
    print("xxx")

print(a)
print("=======================2=============================")
#=====================================
while a<5:
    a=a+1
else:
    print(a)

print("========================3============================")
#=====================================
mylist=[1,2,3,4,5]
for i in mylist:
    print(i)
else:
    print(i)

print("======================4==============================")
#=====================================
mylist=[1,2,3,4,5]
for i in range(len(mylist)):
    print(mylist[i])
else:
    print(i)

print("========================5============================")
#=====================================
for i in range(0,10,2):  #range(10)  range(0,10)
    print(i)
else:
    print(i)


print("========================6============================")
#=====================================
for i in range(1,10):
    for j in range(1,i+1):
        print(str(j)+"*"+str(i)+"="+str(i*j)+"\t",end="")
    else:
        print();

print("========================7============================")
#=====================================
print([i for i in range(10)])

[print(i) for i in range(10)]
print("========================8============================")
#=====================================

[print(''.join([str(j)+"*"+str(i)+"="+str(i*j)+"\t" for j in range(1,i+1)])) for i in range(1,10)]