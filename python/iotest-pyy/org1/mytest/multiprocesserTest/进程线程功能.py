from multiprocessing import Process
import threading
import time

lock = threading.Lock()


def run(info_list, n):
    lock.acquire()
    info_list.append(n)
    lock.release()
    print('%s\n' % info_list)


if __name__ == '__main__':
    info = []
    for i in range(10):
        # target为子进程执行的函数，args为需要给函数传递的参数
        p = Process(target=run, args=[info, i])
        p.start()
        p.join()
    time.sleep(1)  # 这里是为了输出整齐让主进程的执行等一下子进程
    print('------------threading--------------')
    for i in range(10):
        p = threading.Thread(target=run, args=[info, i])
        p.start()
        p.join()