stuff = {'name': 'Zed', 'age': 36, 'height': 6*12+2}

print(stuff['name'])

print(stuff['age'])

print(stuff['height'])

stuff['city'] = "San Francisco" #给字典里添加内容

print(stuff['city'])

stuff = {'Zed':'name', 'age': 36, 'height': 6*12+2} #当时不太会使用字典，就换了位置试一下

print(stuff['Zed'])

stuff = {'name':'Zed', 'age':'36', 'height': 6 * 12 +2} #这两行我故意调换位置
print(stuff)

stuff = {'age':'36', 'height': 6 * 12 +2, 'name':'Zed'}
print(stuff)
