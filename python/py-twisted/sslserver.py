# -*- coding:utf-8 –*-

from twisted.internet import epollreactor

epollreactor.install()

from twisted.protocols.basic import LineOnlyReceiver
from twisted.internet.protocol import Factory, Protocol
from twisted.internet import reactor, ssl

sslContext = ssl.DefaultOpenSSLContextFactory(
    './private.pem',  # 私钥
    './cert.crt',  # 公钥
)

class TcpServerHandle(Protocol):

    # 新的连接建立
    def connectionMade(self):
        print 'connectionMade'

    # 连接断开
    def connectionLost(self, reason):
        print 'connectionLost'

    # 接收到新数据
    def dataReceived(self, data):
        print 'dataReceived', data
        self.transport.write('你好')

factory = Factory()
factory.protocol = TcpServerHandle
reactor.listenSSL(8080, factory, sslContext)
reactor.run()
