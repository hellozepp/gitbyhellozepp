package mytcp

import (
	"fmt"
	"net"
	"os"
)

func MyTcpClient() {
	var buf [512]byte
	service := "localhost:5000"
	tcpAddr, err := net.ResolveTCPAddr("tcp4", service)
	checkErrcli(err)
	conn, err := net.DialTCP("tcp", nil, tcpAddr)
	defer conn.Close()
	checkErrcli(err)
	rAddr := conn.RemoteAddr()
	n, err := conn.Write([]byte("Hello server!"))
	checkErrcli(err)
	n, err = conn.Read(buf[0:])
	checkErrcli(err)
	fmt.Println("Reply from server ", rAddr.String(), string(buf[0:n]))
	os.Exit(0)
}

func checkErrcli(err error) {
	if err != nil {
		fmt.Fprintf(os.Stderr, "Fatal error: %s", err.Error())
		os.Exit(1)
	}
}