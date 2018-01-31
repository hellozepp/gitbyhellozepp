from twisted.internet import epollreactor

epollreactor.install()

from twisted.internet.protocol import DatagramProtocol
from twisted.internet import reactor

from socket import SOL_SOCKET, SO_BROADCAST

class EchoClientDatagramProtocol(DatagramProtocol):
    strings = [
        "Hello, world!",
        "What a fine day it is.",
        "Bye-bye!"
    ]

    def startProtocol(self):
        self.transport.socket.setsockopt(SOL_SOCKET, SO_BROADCAST, True)
        self.transport.connect("255.255.255.255", 8000)
        self.sendDatagram()

    def sendDatagram(self):
        if len(self.strings):
            datagram = self.strings.pop(0)
            self.transport.write(datagram)
        else:
            reactor.stop()

    def datagramReceived(self, datagram, host):
        print 'Datagram received: ', repr(datagram)
        self.sendDatagram()

def main():
    protocol = EchoClientDatagramProtocol()
    #0 means any port
    t = reactor.listenUDP(0, protocol)
    reactor.run()

if __name__ == '__main__':
   main()