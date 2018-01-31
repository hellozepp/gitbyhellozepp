# -*- coding:utf-8 –*-
from twisted.internet import epollreactor

epollreactor.install()
import threading
from twisted.protocols.basic import LineOnlyReceiver
from twisted.internet.protocol import Factory, Protocol, ClientFactory
from twisted.internet import reactor, ssl


class Echo(Protocol):
    def __init__(self):
        self.connected = False

    def connectionMade(self):
        self.connected = True

    def dataReceived(self, data):
        print data.decode('utf8')


class EchoClientFactory(ClientFactory):
    def __init__(self):
        self.protocol = None

    def startedConnecting(self, connector):
        print 'Started to connect.'

    def buildProtocol(self, addr):
        print 'Connected.'
        self.protocol = Echo()
        return self.protocol

    def clientConnectionLost(self, connector, reason):
        print 'Lost connection.  Reason:', reason

    def clientConnectionFailed(self, connector, reason):
        print 'Connection failed. Reason:', reason

import time
import datetime

bStop = False
def routine(factory):
    while not bStop:
        if factory.protocol and factory.protocol.connected:
            factory.protocol.transport.write("hello, I'm %s %s\n" % ("aaa", datetime.datetime.now()))
        time.sleep(1)

host = "127.0.0.1"
port = 8007
factory = EchoClientFactory()
reactor.connectTCP(host, port, factory)
threading.Thread(target=routine, args=(factory,)).start()
reactor.run()