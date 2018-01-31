package mysys

import (
	"syscall"
	"unsafe"
	"fmt"
)

/*
func Syscall(trap, a1, a2, a3 uintptr) (r1, r2 uintptr, err Errno)
func Syscall6(trap, a1, a2, a3, a4, a5, a6 uintptr) (r1, r2 uintptr, err Errno)
func RawSyscall(trap, a1, a2, a3 uintptr) (r1, r2 uintptr, err Errno)
func RawSyscall6(trap, a1, a2, a3, a4, a5, a6 uintptr) (r1, r2 uintptr, err Errno)
其中，Syscall 和 RawSyscall 的区别如下：（以6结尾的一样）
从源码可以看出，Syscall 开始和结束，分别调用了 runtime 中的进入系统调用和退出系统调用的函数，
这就说明，系统调用被 runtime 运行时（调度器）管理，系统调用可以在任何 goroutine 中执行；
而 RawSyscall 并没有，因此它可能会阻塞，导致整个程序阻塞。我们应该总是使用 Syscall，
RawSyscall 存在的意义是为那些永远不会阻塞的系统调用准备的，比如 Getpid。
我们自己的程序需要时，应该用 Syscall。
 */
func MySyscall(){
	syscall.Chmod("/disk/mygopath/src/iotestgo/res/myfile.txt",0777)

	fmt.Println("========================1=======================")
	//========================================================================

	var _p0 *byte
	_p0, err := syscall.BytePtrFromString("/disk/mygopath/src/iotestgo/res/input.txt")
	if err != nil {
		return
	}
	var i int=-0x64
	_, _, e1 := syscall.Syscall6(syscall.SYS_FCHMODAT, uintptr(i), uintptr(unsafe.Pointer(_p0)), uintptr(0555), uintptr(0), 0, 0)
	if e1 != 0 {
		fmt.Println(e1)
	}
}
