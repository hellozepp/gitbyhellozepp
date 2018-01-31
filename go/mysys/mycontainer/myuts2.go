package mycontainer

import (
	"os"
	"os/exec"
	"syscall"
	"fmt"
	//"github.com/sirupsen/logrus"
)

//UTS隔离
//执行go run main.go run sh 发现直接就把虚拟容器的host改了
func MyUts2() {
	if len(os.Args) < 2 {
		fmt.Printf("missing commands")
		return
	}
	switch os.Args[1] {
	case "run":
		run2()
	case "child":
		child2()
	default:
		fmt.Printf("wrong command")
		return
	}
}
func run2() {
	fmt.Printf("Setting up...")
	cmd := exec.Command("/proc/self/exe", append([]string{"child"}, os.Args[2:]...)...)
	cmd.Stdin = os.Stdin
	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr
	cmd.SysProcAttr = &syscall.SysProcAttr{
		Cloneflags: syscall.CLONE_NEWUTS,
	}
	check2(cmd.Run())
}
func child2() {
	fmt.Printf("Running %v", os.Args[2:])
	cmd := exec.Command(os.Args[2], os.Args[3:]...)
	cmd.Stdin = os.Stdin
	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr
	check2(syscall.Sethostname([]byte("xxx")))
	check2(cmd.Run())
}

func check2(err error) {
	if err != nil {
		fmt.Println(err)
	}
}