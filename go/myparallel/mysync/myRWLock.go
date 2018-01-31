package mysync

import (
	"sync"
	"fmt"
	"time"
)

var m *sync.RWMutex



func MyRWLock() {

	m = new(sync.RWMutex)

	go read(1)
	go read(2)


	//写的时候啥都不能干

	go write(3)

	go read(4)

	go write(5)



	time.Sleep(4 * time.Second)

}



func read(i int) {

	fmt.Println(i, "read start")



	m.RLock()

	fmt.Println(i, "reading")

	time.Sleep(1 * time.Second)

	m.RUnlock()



	fmt.Println(i, "read end")

}



func write(i int) {

	fmt.Println(i, "write start")



	m.Lock()

	fmt.Println(i, "writing")

	time.Sleep(1 * time.Second)

	m.Unlock()



	fmt.Println(i, "write end")

}