print(type(range(10)))

# 平方表
square_table = []
for i in range(5000):
    square_table.append(i * i)
for i in range(5):
    print(square_table[i])
    
square_generator = (x * x for x in range(50000))
print(type(square_generator))
for i in range(5):
    print(next(square_generator))

def fib(limit):
    n, a, b = 0, 0, 1
    while n < limit:
        yield b
        a, b = b, a + b
        n += 1

import traceback
f = fib(5)
print(type(f))
print(next(f))
print(next(f))
print(next(f))
print(next(f))
print(next(f))
print("『==========』")
try:
    print(next(f))
except StopIteration:
    traceback.print_exc()
for i in fib(5):
    print(i)
