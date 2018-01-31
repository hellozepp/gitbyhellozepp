from functools import reduce
print("============reduce==========")
li=[1,2,3,4,5]
print( reduce(lambda x,y:x+y, li) )
# x开始的时候被赋值为10，然后依次
print( reduce(lambda x,y:x+y, li ,10) )


#map
print("============map==========")
l = [1,2,3]
new_list = list(map(lambda i: i+1, l))
print(new_list)
# Py3里，外面需要套个list：
# 这是为了让里面的值给显示出来，要不然你会得到这是个map函数
# 而不是里面的值。
# Py2的童鞋不虚

# 我们也可以把两个数组搞成一个单独的数组
l2 = [4,5,6,7,8]
new_list = list(map(lambda x,y: x+y, l, l2))
print(new_list)

print("============filter==========")
print( list(filter(lambda x:x>5 ,l2)) )
