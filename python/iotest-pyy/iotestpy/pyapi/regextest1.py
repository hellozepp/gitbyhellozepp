import re

# 将正则表达式编译成Pattern对象
pattern = re.compile(r"hello")

# 使用Pattern匹配文本，获得匹配结果，无法匹配时将返回None
match = pattern.match("hello world!")

if match:
    # 使用Match获得分组信息
    print(match.group())

#===========================================================
print("===========================================================")

# re.I(re.IGNORECASE): 忽略大小写（括号内是完整写法，下同）
# M(MULTILINE): 多行模式，改变"^"和"$"的行为（参见上图）
# S(DOTALL): 点任意匹配模式，改变"."的行为
# L(LOCALE): 使预定字符类 \w \W \b \B \s \S 取决于当前区域设定
# U(UNICODE): 使预定字符类 \w \W \b \B \s \S \d \D 取决于unicode定义的字符属性
# X(VERBOSE): 详细模式。这个模式下正则表达式可以是多行，忽略空白字符，并可以加入注释。以下两个正则表达式是等价的：

a = re.compile(r"""(\w+) 
                    (\w+)
                       (?P<sign>.*)""", re.X)

m = a.match(r"""hello 
                    world!
                    aaa""")
print(m.group())

a = 'This is the first line.\nThis is the second line.\nThis is the third line.'

q = re.match(r'This.*line.', a, flags=re.S)

print(q.group())

c = re.compile(r"(\w+) (\w+)(?P<sign>.*)")

m = c.match(r"hello world!")
print(m.group())

m = re.match(r"hello", "hello world!")
print(m.group())

#===========================================================
print("===========================================================")

m = re.match(r"(\w+) (\w+)(?P<sign>.*)", "hello world!")

print("m.string:", m.string)
print("m.re:", m.re)
print("m.pos:", m.pos)
print("m.endpos:", m.endpos)
print("m.lastindex:", m.lastindex)
print("m.lastgroup:", m.lastgroup)

print("m.group(1,2):", m.group(1, 2))
print("m.groups():", m.groups())
print("m.groupdict():", m.groupdict())
print("m.start(2):", m.start(2))
print("m.end(2):", m.end(2))
print("m.span(2):", m.span(2))
print(r'm.expand(r"\2 \1\3"):', m.expand(r"\2 \1\3"))

#===========================================================
print("===========================================================")
m = re.match(r"hello.*world", '''hello
world!''',re.DOTALL)
print(m.group())