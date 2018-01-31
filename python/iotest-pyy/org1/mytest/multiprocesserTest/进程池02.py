from multiprocessing import Pool
import time


def f(x):
    print (x * x)
    time.sleep(2)
    return x * x


if __name__ == '__main__':
    '''定义启动的进程数量'''
    pool = Pool(processes=5)
    res_list = []

    for i in range(10):
        '''以异步并行的方式启动进程，如果要同步等待的方式，可以在每次启动进程之后调用res.get()方法，也可以使用Pool.apply'''
        res = pool.apply_async(f, [i, ])
        res_list.append(res)#注册监听
    pool.close()
    pool.join()
    for r in res_list:
        print ("result", (r.get(timeout=5)) )#get方法回掉