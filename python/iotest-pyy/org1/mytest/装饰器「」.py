from functools import wraps


def hello(fn1):
    # @wraps(fn1)#加注解会改变装饰类为本类对象
    def wrapper():
        '''help doc'''
        print("hello, %s" % fn1.__name__)
        fn1()
        print("goodby, %s" % fn1.__name__)

    return wrapper


@hello
def foo():
    '''foo help doc'''
    print("i am foo")
    pass


foo()
print("======================")
print(foo.__name__)
print(foo.__doc__)