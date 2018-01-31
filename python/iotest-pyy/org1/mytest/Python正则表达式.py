#coding=utf-8
print("#====================match==================")
import re
print(re.match('cc', 'cca.aacaccccacccc ,.,cc').span())#不加span返回match对象 #(0, 2)
print(re.match("1","1.cc"))#<_sre.SRE_Match object; span=(0, 1), match='1'>

print((re.match('www', 'www.runoob.com').span()))  # 在起始位置匹配(0, 3)
print((re.match('com', 'www.runoob.com')))         # 不在起始位置匹配,,,只能匹配开始 X

m = re.match(r'(\w+) (\w+)(?P<sign>.*)', 'hello world!')
print(m.group("sign"))#找不到报错 ：!

print("m.string:", m.string)
print("m.re:", m.re)#re.compile('(\\w+) (\\w+)(?P<sign>.*)')
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
print(r"m.expand(r'\2 \1\3'):", m.expand(r'\2 \1\3'))
print("#==================== findall==================")
# re.compile(strPattern[, flag]):
"""
re.I	使匹配对大小写不敏感
re.L	做本地化识别（locale-aware）匹配
re.M	多行匹配，影响 ^ 和 $
re.S	使 . 匹配包括换行在内的所有字符
re.U	根据Unicode字符集解析字符。这个标志影响 \w, \W, \b, \B.
re.X	该标志通过给予你更灵活的格式以便你将正则表达式写得更易于理解。

"""
#模式对象r
pattern1 = re.compile(r"""\d#整数部分
.#小数点 
\d * #小数部分
""", re.X)
import re
text = "JGood is a handsome boy, he is cool, clever, and so on...1.3333"
print(text)
print(re.findall(r'\w*oo\w*', text))    #查找所有包含'oo'的单词
print(re.findall(pattern1, text))    #查找所有包含pattern

print("#====================search==================")

line = """Cats are smarter 
       than dogsCats are smarter 
       than dogs"""
# re.match只匹配字符串的开始，如果字符串开始不符合正则表达式，则匹配失败，函数返回None；而re.search匹配整个字符串，直到找到一个匹配。
searchObj = re.search(r'(.*) are (.*?) .*', line, re.M | re.I)
# 编号0代表整个匹配的子串；不填写参数时，返回group(0)；没有截获字符串的组返回None；截获了多次的组返回最后一次截获的子串。
print(searchObj.group())
print(searchObj.group(0))#group(0)，都表示整个所匹配
print(searchObj.groups())#返回所有组  ，组合成一个Tuple类型的值
print(searchObj.group(0,))#

reNamedGroupTestStr = u'标签：<a href="/tag/情侣电话粥/">情侣电话粥</a>';

# 1. (?P=name)
# 此处就是通过 (?P=name)的方式，来引用，正则表达式中，前面已经命名tagName的group的
foundTagA = re.search(u'.+?<a href="/tag/(?P<tagName>.+?)/">(?P=tagName)</a>', reNamedGroupTestStr);
print(
"foundTagA=", foundTagA);  # foundTagA= <_sre.SRE_Match object at 0x00876D60>

if (foundTagA):
    # 2. mateched.group(name)
    # 可以通过之前给group命的名，来获得匹配到的值
    namedGroupStr = foundTagA.group("tagName");
    print(
    "namedGroupStr=", namedGroupStr);  # namedGroupStr= 情侣电话粥

    # 4. \g<name> in re.sub()
    # 在re.sub()中，通过\g<name>的方式，引用前面已经命名为name的group的值
substitutedStr = re.sub(u'.+?<a href="/tag/(?P<tagName>.+?)/">(?P=tagName)</a>', u'所捕获的tag值为：\g<tagName>',
                        reNamedGroupTestStr);
print(
"Original string=%s, after substituted=%s" % (reNamedGroupTestStr,
                                              substitutedStr));
# Original string=标签：<a href="/tag/情侣电话粥/">情侣电话粥</a>, after substituted=所捕获的tag值为：情侣电话粥

#====================替换匹配项==================

phone = "2004-959-559 # 这是一个国外电话号码"
print(phone)
# 删除字符串中的 Python注释
num = re.sub(r'#.*$', "", phone)
print("电话号码是: ", num)

# 删除非数字(-)的字符串
num = re.sub(r'\D', "", phone)
print("电话号码是 : ", num)


# 将匹配的数字乘于 2
def double(matched):
    value = int(matched.group('value'))
    return str(value * 2)
s = 'A23G4HFD567'
print((re.sub('(?P<value>\d+)', double, s)))