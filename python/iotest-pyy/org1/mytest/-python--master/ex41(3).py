def printMax(x, y):
    '''打印两个数中的最大值。
两个值必须是整数。'''
    
    x = int(x) # 如果可能，转换为整数
    y = int(y)
    if x > y:
        print((x, 'MAX'))
    else:
        print((y, 'MAX'))
printMax(3, 5)
print((printMax.__doc__))
