package mycontainer

import (
	"os"
	"os/exec"
	"syscall"
	"fmt"
	//"github.com/sirupsen/logrus"
)

//pid mount隔离 已经很像一个完整的系统了
//执行go run main.go run sh 发现系统彻底独立出来了
func MyPid() {
	if len(os.Args) < 2 {
		fmt.Printf("missing commands")
		return
	}
	switch os.Args[1] {
	case "run":
		run3()
	case "child":
		child3()
	default:
		fmt.Printf("wrong command")
		return
	}
}
func run3() {
	fmt.Printf("Setting up...")
	cmd := exec.Command("/proc/self/exe", append([]string{"child"}, os.Args[2:]...)...)
	cmd.Stdin = os.Stdin
	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr
	cmd.SysProcAttr = &syscall.SysProcAttr{
		Cloneflags: syscall.CLONE_NEWUTS| syscall.CLONE_NEWPID | syscall.CLONE_NEWNS,
	}
	check3(cmd.Run())
}
func child3() {
	fmt.Printf("Running %v", os.Args[2:])
	cmd := exec.Command(os.Args[2], os.Args[3:]...)
	cmd.Stdin = os.Stdin
	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr
	check3(syscall.Sethostname([]byte("xxx")))
	check3(syscall.Chroot("/data/busybox"))
	check3(os.Chdir("/"))
	// func Mount(source string, target string, fstype string, flags uintptr, data string) (err error)
	// 前三个参数分别是文件系统的名字，挂载到的路径，文件系统的类型
	check3(syscall.Mount("proc", "proc", "proc", 0, ""))
	check3(syscall.Mount("tempdir", "temp", "tmpfs", 0, ""))
	check3(cmd.Run())
	check3(syscall.Unmount("proc", 0))
	check3(syscall.Unmount("temp", 0))
}

func check3(err error) {
	if err != nil {
		fmt.Println(err)
	}
}