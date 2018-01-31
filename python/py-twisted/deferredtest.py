#!/usr/bin/env python
# -*- coding: utf-8 -*-
from twisted.internet import reactor, defer
from twisted.python import failure

d=defer.Deferred()

def one(str):
    print "hello "+str
    return str+" one"

def two(str):
    print "hello " + str
    return str + " two"

def err(f):
    print "err",f

d.addCallback(one)
d.addCallback(two)
d.addErrback(err)

i=int(input("请输入１或其他数字："))
if i==1:
    d.callback("xxx")
if i==2:
    reactor.callLater(2,d.callback,"ggg")
    reactor.run()
else:
    f=failure.Failure(Exception("ttt"))
    d.errback(f)
