
from twisted.internet import epollreactor

epollreactor.install()

from twisted.internet.protocol import DatagramProtocol
from twisted.internet import reactor


class Echo(DatagramProtocol):
    def datagramReceived(self, data, (host, port)):
        print "received %r from %s:%d" % (data, host, port)
        self.transport.write(data, (host, port))


reactor.listenUDP(9999, Echo())
reactor.run()