package mycontainer

import (
	"os"
	"os/exec"
	"syscall"
	"fmt"
)

//UTS隔离
//执行go run main.go run sh
//验证可以用ls -l /proc/$$/ns，新的sh和原来的sh uts不一样了
//在新sh中执行hostname xxx更改当前的hostname, 可以看到这里的hostname已经被改成了xxx, 但是原来的sh中依然不变
func MyUts() {
	if len(os.Args) < 2 {
		fmt.Println("missing commands")
		return
	}
	switch os.Args[1] {
	case "run":
		run()
	default:
		fmt.Println("wrong command")
		return
	}
}
func run() {
	fmt.Printf("Running %v", os.Args[2:])
	cmd := exec.Command(os.Args[2], os.Args[3:]...)
	cmd.Stdin = os.Stdin
	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr
	cmd.SysProcAttr = &syscall.SysProcAttr{
		Cloneflags: syscall.CLONE_NEWUTS,
	}
	check(cmd.Run())
}
func check(err error) {
	if err != nil {
		fmt.Println(err)
	}
}