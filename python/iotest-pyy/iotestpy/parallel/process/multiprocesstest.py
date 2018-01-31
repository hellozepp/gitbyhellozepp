from multiprocessing import Process


def func(name):
    print('hello', name)

p = Process(target=func, args=("aaa",))
p.start()
p.join()  # 等待进程执行完毕

