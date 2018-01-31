def filter_list(func,list1):
    result=[]
    for ele in list1:
        if func(ele):
            result.append(ele)
    return result

list1=["aaa","bbbbbb","ccc","aaabbbccc"]
print(filter_list(lambda ele:len(ele)>6,list1))
print(filter_list(lambda ele:'a' in ele,list1))



func=lambda x,y:{
    print("adfadf"),
    x+y
}

print(func(1,2))

print("*"*20)
s={print("1111"),print("2222")}
print(type(s))

