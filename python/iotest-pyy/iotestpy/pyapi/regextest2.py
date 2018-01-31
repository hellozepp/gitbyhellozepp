import re

p = re.compile(r'(\w+) (\w+)(?P<sign>.*)', re.DOTALL)

print("p.pattern:", p.pattern)
print("p.flags:", p.flags)
print("p.groups:", p.groups)
print("p.groupindex:", p.groupindex)

#===========================================================
print("===========================================================1")

# 将正则表达式编译成Pattern对象
pattern = re.compile(r'world')

# 使用search()查找匹配的子串，不存在能匹配的子串时将返回None
# 这个例子中使用match()无法成功匹配
match = pattern.search('hello world!')

if match:
    # 使用Match获得分组信息
    print(match.group())

#===========================================================
print("===========================================================2")

p = re.compile(r'\d+')
print(p.split('one1two2three3four4'))

#===========================================================
print("===========================================================3")

p = re.compile(r'\d+')
print(p.findall('one1two2three3four4'))

#===========================================================
print("===========================================================4")

p = re.compile(r'\d+')
for m in p.finditer('one1two2three3four4'):
    print(m.group())

#===========================================================
print("===========================================================5")

p = re.compile(r'(\w+) (\w+)')
s = 'i say, hello world!'

print(p.sub(r'\2 \1', s))


def func(m):
    return m.group(1).title() + ' ' + m.group(2).title()


print(p.sub(func, s))


#===========================================================
print("===========================================================6")

p = re.compile(r'(\w+) (\w+)')
s = 'i say, hello world!'

print(p.subn(r'\2 \1', s))


def func(m):
    return m.group(1).title() + ' ' + m.group(2).title()


print(p.subn(func, s))