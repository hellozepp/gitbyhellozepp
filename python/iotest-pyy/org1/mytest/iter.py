from collections import Iterable
from collections import Iterator

print(isinstance([1, 2, 3], Iterable))
print(isinstance({}, Iterable))
print(isinstance(123, Iterable))
print(isinstance('abc', Iterable))
print(isinstance([1, 2, 3], Iterator))

g = (x * x for x in range(10)) #generator
print(type(g))
print(isinstance(g, Iterable))
print(isinstance(g, Iterator))
for i in g:
    print(i)

def fib(limit):
    n, a, b = 0, 0, 1
    while n < limit:
        yield b
        a, b = b, a + b
        n += 1
    return 'done'

f = fib(6)
print(type(f))
print(isinstance(f, Iterable))
print(isinstance(f, Iterator))
for i in f:
    print(i)
