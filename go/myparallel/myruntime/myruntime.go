package myruntime

import (
	"fmt"
	"runtime"
)

func Myruntime(){

	runtime.GOMAXPROCS(runtime.NumCPU()) //多核处理
	c1:=make(chan bool,10)
	for i:=0;i<10;i++{
		go func(i int) {
			sum:=0
			for j:=0;j<1000000;j++{
				sum+=j
			}
			fmt.Println(i)
			c1<-true
		}(i)
	}

	for i:=0;i<10;i++{
		<-c1
	}
}
