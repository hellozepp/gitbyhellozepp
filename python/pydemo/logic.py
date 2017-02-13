#coding: utf-8
#Python程序语言指定任何非0和非空（null）值为true，0 或者 null为false。
if(1-1):
    print "this is true"
else:print "this is false"
if(False):
    print "this is true"
else:
    print "this is false"

'''# python 并不支持 switch 语句，所以多个条件判断，只能用 elif 来实现，如果判断需要多个条件需同时判断时，可以使用 or （或），
表示两个条件有一个成立时判断条件成功；使用 and （与）时，表示只有两个条件同时成立的情况下，判断条件才成功。 '''
def xiaoming(args):
    name = "xiaoming"
    age  = 18
    sex  = "boy"
    mathematicsScore = args
    if(mathematicsScore>=90):print "优秀"
    elif(mathematicsScore >=60 and mathematicsScore <=90):
        print "及格"
    elif(mathematicsScore < 60):print "补考"
xiaoming(60)