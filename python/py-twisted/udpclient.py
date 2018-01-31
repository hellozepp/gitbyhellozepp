#!/usr/bin/env python
# -*- coding: utf-8 -*-
from twisted.internet import epollreactor

epollreactor.install()

from twisted.internet.protocol import DatagramProtocol
from twisted.internet import reactor


class Helloer(DatagramProtocol):
    def startProtocol(self):
        host = "127.0.0.1"
        port = 9999

        self.transport.connect(host, port)
        print "now we can only send to host %s port %d" % (host, port)
        self.transport.write("hello")  # no need for address，不需要地址

    def datagramReceived(self, data, (host, port)):
        print "received %r from %s:%d" % (data, host, port)

    # Possibly invoked if there is no server listening on the
    # address to which we are sending.如果发送到的地址，没有人监听，可能会调用以下函数。
    def connectionRefused(self):
        print "No one listening"


# 0 means any port, we don't care in this case; 0表示任何端口，这种情形下我们
h=Helloer()

reactor.listenUDP(0, h)
reactor.run()

