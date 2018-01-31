package mysync

import (
	"sync"
	"time"
	"fmt"
)

func MyOnce() {

	o := &sync.Once{}

	go do(o)

	go do(o)

	time.Sleep(time.Second * 2)

}



func do(o *sync.Once) {

	fmt.Println("Start do")

	o.Do(func() {

		fmt.Println("Doing something...")

	})

	func(){
		fmt.Println("not once")
	}()

	fmt.Println("Do end")

}
