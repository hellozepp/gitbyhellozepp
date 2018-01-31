#coding= utf-8
people = 30
cars = 40
buses = 15
#not 非，
print(not True)
a= not 1
print(a)
if cars > people:
    print("We should take the cars.")
elif cars < people:
    print("We should not take the cars.")
else:
    print("We can't decide.")

if buses > cars:
    print("That's too many buses.")
elif buses < cars:
    print("Maybe we could take the buses.")
else:
    print("We still can't decide.")
if people > buses:
    print("Alright, let's just take the buses.")
else:
    print("Fine, let's stay home then.")

if cars > people and buses < cars:
    print("True")
elif cars < people and buses > cars:
    print("False")
else:
    print("I can't decide.")
