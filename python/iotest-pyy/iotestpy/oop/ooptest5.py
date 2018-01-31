class Some:
    def __new__(clz, name):
        print("new: "+name,clz)
        return object.__new__(clz)
        # return None

    def __init__(self,name):
        print("init: "+name)

    def __del__(self):
        print("del")
    
    def xxx(self):
        pass

class Logger:
    __loggers={}
    def __new__(clz,name):
        if name not in clz.__loggers:
            logger=object.__new__(clz)
            clz.__loggers[name]=logger
            return logger
        return clz.__loggers[name]

    def __init__(self,name):
        if name not in vars(self):
            self.name=name

    def log(self,message):
        print("{name}:{message}".format(name=self.name,message=message))

if __name__ == "__main__":
    s=Some("aaa")
    print(s)
    s.xxx()
    del s
    

    print("="*50)

    logger1=Logger("Test1")
    logger2 = Logger("Test2")
    logger3 = Logger("Test1")

    logger1.log("打印日志")
    logger2.log("打印日志")
    logger3.log("打印日志")

