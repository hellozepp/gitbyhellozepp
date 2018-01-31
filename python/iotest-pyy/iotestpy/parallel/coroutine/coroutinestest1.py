import asyncio

import time


async def cor1():
    print("COR1 start")
    print(await cor2())
    print("COR1 end")
    return "xxxxxx"


async def cor2():
    time.sleep(0.5)  # 0.5秒
    print("COR2")
    return "xxx"


loop = asyncio.get_event_loop() #asyncio启动默认的event loop
print(loop.run_until_complete(cor1())) #这个函数是阻塞执行的，直到所有的异步函数执行完成，
loop.close() #关闭event loop。