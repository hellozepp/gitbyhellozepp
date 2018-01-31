from functools import reduce


def inc(x):
    def incx(y):
        return x + y

    return incx


inc2 = inc(2)
inc5 = inc(5)

print(inc2(5))  # 输出 7
print(inc5(5))  # 输出 10

print((lambda x: x * 2)(4))
print('1.....["qi", "yue", "July"])')
name_len = list(map(len, ["qi", "yue", "July"]))
print(name_len)


def toUpper(item):
    return item.upper()

print('2.....["qi", "yue", "July"])')
upper_name = map(toUpper, ["qi", "yue", "July"])
print(list(upper_name))


items = [1, 2, 3, 4, 5]
squared = list(map(lambda x: x**2, items))
print(squared)

number_list = range(-5, 5)
less_than_zero = list(filter(lambda x: x < 0, number_list))
print(less_than_zero)

def add(x,y): return x + y
print(reduce(add, range(1, 5)))
print(reduce(add, range(1, 5), 10))
