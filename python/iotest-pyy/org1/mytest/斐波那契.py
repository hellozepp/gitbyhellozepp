def fibo():
    list=[0.0,1.0]
    i=0
    while(1):
        i+=1
        list.append(list[i-1]+list[i])
        if(i!=1 and round(list[i-1]/list[i],3)==0.618):
            return [list[i-1],list[i]]
print(fibo())