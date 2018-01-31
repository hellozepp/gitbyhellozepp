import logging
import traceback

import sys
from contextlib import contextmanager


try:
    a=1/0
except ZeroDivisionError as err:
    print(err)
    # traceback.print_exc()
    # print(sys.exc_info())
    # print(sys.exc_traceback)

print("ok")

# ==========================================================
print("==================1=======================")

class MyException(Exception):
    def __init__(self,msg):
        super().__init__(msg)

a=1
try:
    if a==1:
        raise MyException("错了错了错了")
except Exception as err:
    logging.getLogger(__name__).log(logging.ERROR,"错了")
else:
    print("else")
finally:
    print("finally")

# ==========================================================
print("==================2=======================")

class Res:
    def __init__(self,name):
        self.name=name

    def __enter__(self):
        print(self.name+" enter")
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        print(self.name+" exit")
        return False

try:
    with Res("withtest") as res:
        print(res.name)
        raise MyException("错了错了错了")
except Exception:
    print("错了")

# ==========================================================
print("==================3=======================")
#  with语句中EXPR部分必须是一个包含__enter__()和__exit__()方法的对象，也就是Context Manager
@contextmanager
def xxx111(ex):
    try:
        yield
    except ex as e:
        print(e)

a=0
with xxx111(MyException),Res("withtest") as res:
    if a==0:
        raise MyException("错了错了错了")


# ==========================================================
print("===================4======================")

from contextlib import suppress

a=0
with suppress(MyException):
    if a==0:
        raise MyException("错了错了错了")


# ==========================================================
print("===================5======================")

@contextmanager
def closing(thing):
    try:
        yield thing
    finally:
        thing.close()

class Some:
    def __init__(self,name):
        self.name=name
    def close(self):
        print(self.name+" close")

with closing(Some("some")) as res:
    print(res.name)

# ==========================================================
print("===================6======================")

from contextlib import closing

class Some2:
    def __init__(self,name):
        self.name=name
    def close(self):
        print(self.name+" close")

with closing(Some2("some2")) as res:
    print(res.name)

