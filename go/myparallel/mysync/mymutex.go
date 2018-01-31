package mysync

import (
	"sync"
	"time"
	"fmt"
)

func MyMutx() {
	var mutex sync.Mutex
	count := 0

	for r := 0; r < 50; r++ {
		go func() {
			mutex.Lock()
			count += 1
			mutex.Unlock()
		}()
	}

	time.Sleep(time.Second)
	fmt.Println("the count is : ", count)
}