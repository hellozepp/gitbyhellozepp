stuff = {'name': 'Zed', 'age': 36, 'height': 6*12+2}
stuff[1] = "Wow" #插入值
stuff[2] = "Neato"
print("Stuff:",stuff)

stuff['city'] = "San Francisco"
print("City:",stuff['city'])

del stuff['city']
del stuff[1]
del stuff[2]

print("New stuff:",stuff)
