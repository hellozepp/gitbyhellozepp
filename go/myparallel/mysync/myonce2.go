package mysync

import (
	"sync/atomic"
	"sync"
	"fmt"
	"time"
)

type Once struct {
	m    sync.Mutex
	done uint32
}

func (o *Once) Do(f func()) {
	if atomic.LoadUint32(&o.done) == 1 {
		return
	}

	o.m.Lock()
	defer o.m.Unlock()
	if o.done == 0 {
		f()
		atomic.StoreUint32(&o.done, 1)
	}
}

type Once2 struct {
	done int32
}

func (o *Once2) Do2(f func()) {
	if atomic.LoadInt32(&o.done) == 1 {
		return
	}
	// Slow-path.
	if atomic.CompareAndSwapInt32(&o.done, 0, 1) {
		f()
	}
}


func MyOnce2() {

	o := &Once{}

	go do2(o)

	go do2(o)

	time.Sleep(time.Second * 2)

	fmt.Println("========================1=======================")
	//========================================================================

	o3 := &Once2{}

	go do3(o3)

	go do3(o3)

	time.Sleep(time.Second * 2)

}

func do2(o *Once) {

	fmt.Println("Once Start do")

	o.Do(func() {

		fmt.Println("Once Doing something...")

	})

	func(){
		fmt.Println("Once not once")
	}()

	fmt.Println("Once Do end")

}

func do3(o *Once2) {

	fmt.Println("Once2 Start do")

	o.Do2(func() {

		fmt.Println("Once2 Doing something...")

	})

	func(){
		fmt.Println("Once2 not once")
	}()

	fmt.Println("Once2 Do end")

}