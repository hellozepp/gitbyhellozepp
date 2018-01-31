package mysync

import (
	"sync"
	"time"
	"fmt"
)

func MyCountDownLunch(){
	wg:=sync.WaitGroup{}
	wg.Add(10)

	for i:=0;i<10;i++{
		go func(i int) {
			time.Sleep(time.Second)
			fmt.Println("ok",i)
			wg.Done()
		}(i)
	}

	wg.Wait()

}
