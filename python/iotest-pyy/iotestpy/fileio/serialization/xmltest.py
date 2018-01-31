inpath="/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/employees.xml"

from xml.dom import minidom
doc = minidom.parse(inpath)

root = doc.documentElement

employees = root.getElementsByTagName("employee")

for employee in employees:
    print("-------------------------------------------")
    print(employee.nodeName)
    print(employee.toxml())

    nameNode = employee.getElementsByTagName("name")[0]
    print(nameNode.childNodes)
    print(nameNode.nodeName + ":" + nameNode.childNodes[0].nodeValue)
    ageNode = employee.getElementsByTagName("age")[0]
    print(ageNode.childNodes)
    print(ageNode.nodeName + ":" + ageNode.childNodes[0].nodeValue)

    print("-------------------------------------------")
    for n in employee.childNodes:
        print(n)
