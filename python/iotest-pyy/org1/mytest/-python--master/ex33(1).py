i = 0
number = []
nu = input("Please enter the number: ")
nu = int(nu)
while i < nu:
    print("At the top i is %d" % i)
    number.append(i)
    i = i + 1
    print("Nmubers now: ",number)
    print("At the bottom i is %d" % i)
print("The numbers: ")
for num in number:
    print(num)
print(number)
