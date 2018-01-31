class Some:
    __slots__ = ['a','b','d']

s=Some()
s.a="aaa"
s.b="bbb"
# s.__slots__.append("c")
print(s.__slots__)

# s.c="xxx" #此属性由于slots没有预先配置，因此不可加入
s.d="xxx"

print("="*50+"1")
#=======================================================

class Some:
    __slots__ = ['a','b','__dict__']

s=Some()
s.a="aaa"
s.b="bbb"

s.c="xxx"


print(s.a+"\t"+s.b+"\t"+s.c)
print(Some.__dict__)
