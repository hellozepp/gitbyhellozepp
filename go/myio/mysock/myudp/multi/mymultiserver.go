package multi

import (
	"net"
	"fmt"
)

func MyMultiServer() {
	//如果第二参数为nil,它会使用系统指定多播接口，但是不推荐这样使用
	addr, err := net.ResolveUDPAddr("udp", "224.0.0.250:9981")
	if err != nil {
		fmt.Println(err)
	}
	listener, err := net.ListenMulticastUDP("udp", nil, addr)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Printf("Local: <%s> \n", listener.LocalAddr().String())
	data := make([]byte, 1024)
	for {
		n, remoteAddr, err := listener.ReadFromUDP(data)
		if err != nil {
			fmt.Printf("error during read: %s", err)
		}
		fmt.Printf("<%s> %s\n", remoteAddr, data[:n])
	}
}
