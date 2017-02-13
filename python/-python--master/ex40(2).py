stuff = {'name': 'Zed', 'age': 36, 'height': 6*12+2}
stuff['city'] = "San Francisco"
print "City:",stuff['city']
stuff[1] = "Wow"
stuff[2] = "Neato"
print "Stuff:",stuff

del stuff['city']
del stuff[1]
del stuff[2]

print "New stuff:",stuff
