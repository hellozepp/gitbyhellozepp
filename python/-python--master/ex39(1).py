ten_things = "Apples Oranges Crows Telephone Light Sugar"

print "Wait there's not 10 things in that list, let's fix that."

stuff = ten_things.split(' ') #Python split()通过指定分隔符对字符串进行切片，如果参数num 有指定值，则仅分隔 num 个子字符串
more_stuff = ["Day", "Night", "Song", "Frisbee", "Corn","Banana", "Girl", "Boy"]

while len(stuff) != 10:
    next_one = more_stuff.pop()  #pop() 函数用于移除列表中的一个元素（默认最后一个元素），并且返回该元素的值。
    print "Adding: ",next_one
    stuff.append(next_one)
    print "There's %d items now." % len(stuff)

print "There we go: ", stuff
print "Let's do sometings with stuff."

print stuff[1]
print stuff[-1]
print stuff.pop()
print ' '.join(stuff) #Python join() 方法用于将序列中的元素以指定的字符连接生成一个新的字符串。
print '#'.join(stuff[3:5])
print '##'.join(stuff[4])
