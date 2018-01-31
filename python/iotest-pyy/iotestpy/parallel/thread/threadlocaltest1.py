import threading

local = threading.local()
local.tname = "xxx"

def func(info):
    local.tname = info
    print(local.tname)

t1 = threading.Thread(target=func, args=['funcA'])
t2 = threading.Thread(target=func, args=['funcB'])

t1.start()
t1.join()

t2.start()
t2.join()

print(local.tname)