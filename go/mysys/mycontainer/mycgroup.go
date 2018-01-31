package mycontainer

import (
	"os"
	"os/exec"
	"syscall"
	"fmt"
	"io/ioutil"
	"strconv"
	"path"
)

//pid mount隔离 已经很像一个完整的系统了
//执行go run main.go run sh
//进去后看内存free -m 发现用量已经被限制了

const cgroupMemoryHierarchyMount = "/sys/fs/cgroup/memory"

func MyCgrouptest() {

	if len(os.Args) < 2 {
		fmt.Printf("missing commands")
		return
	}
	switch os.Args[1] {
	case "run":
		run4()
	case "child":
		child4()
	default:
		fmt.Printf("wrong command")
		return
	}
}
func run4() {
	fmt.Println("================")
	cmd := exec.Command("/proc/self/exe", append([]string{"child"}, os.Args[2:]...)...)
	cmd.SysProcAttr = &syscall.SysProcAttr{
		Cloneflags: syscall.CLONE_NEWUTS | syscall.CLONE_NEWPID | syscall.CLONE_NEWNS,
	}
	cmd.Stdin = os.Stdin
	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr
	//
	if err := cmd.Start(); err != nil {
		fmt.Println("ERROR", err)
		os.Exit(1)
	} else {
		//得到fork出来进程映射在外部命名空间的pid
		fmt.Printf("%v", cmd.Process.Pid)
		// 在系统默认创建挂载了memory subsystem的Hierarchy上创建cgroup
		os.Mkdir(path.Join(cgroupMemoryHierarchyMount, "testmemorylimit"), 0755)
		// 将容器进程加入到这个cgroup中
		err1:=ioutil.WriteFile(path.Join(cgroupMemoryHierarchyMount, "testmemorylimit", "tasks") , []byte(strconv.Itoa(cmd.Process.Pid)), 0644)
		// 限制cgroup进程使用
		err2:=ioutil.WriteFile(path.Join(cgroupMemoryHierarchyMount, "testmemorylimit", "memory.limit_in_bytes") , []byte("1m"), 0644)
		fmt.Println(err1,err2)
		}
	cmd.Process.Wait()
}

func child4(){
	fmt.Println("+++++++++++++++++++")
		//容器进程
		fmt.Printf("current pid %d", syscall.Getpid())
		fmt.Println()

		cmd := exec.Command(os.Args[2], os.Args[3:]...)
		cmd.SysProcAttr = &syscall.SysProcAttr{
		}
		cmd.Stdin = os.Stdin
		cmd.Stdout = os.Stdout
		cmd.Stderr = os.Stderr

		if err := cmd.Run(); err != nil {
			fmt.Println(err)
			os.Exit(1)
		}
}