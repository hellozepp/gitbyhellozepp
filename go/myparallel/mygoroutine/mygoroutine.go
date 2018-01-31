package mygoroutine

import (
	"fmt"
	"time"
	"strconv"
)

func Mygoroutine(){
	c1:=make(chan bool)
	go myrun1(&c1)
	v,err:=<-c1
	fmt.Println(v,err)

	fmt.Println("========================1=======================")
	//========================================================================
	c2:=make(chan int,2)
	go myrun2(&c2)
	c2<-1
	c2<-2
	time.Sleep(3 * time.Second)
	val,_:=<-c2

	fmt.Println("res:",val)

	fmt.Println("========================2=======================")
	//========================================================================
	crw := make(chan int)
	go send(crw)
	go recv(crw)
	time.Sleep(3 * time.Second)

	fmt.Println("========================3=======================")
	//========================================================================
	c3:=make(chan int,2)
	go func() {
		c3<-1
		close(c3)
	}()
	for v:=range c3{
		fmt.Println(v)
	}

}
func myrun1(c *chan bool){
	fmt.Println("go myrun1")
	*c<-true
}

func myrun2(c *chan int){
	list:=make([]int,0)
	for i:=0;i<2;i++{

		v,_:=<-*c
		fmt.Println("myrun2:"+strconv.Itoa(v))
		list=append(list, v)
	}
	fmt.Println("-----")
	fmt.Println(list)
	*c<-0
}


//只能向chan里写数据
func send(c chan<- int) {
	for i := 0; i < 5; i++ {
		c <- i
	}
}
//只能取channel中的数据
func recv(c <-chan int) {
	for i := range c {
		fmt.Println(i)
	}
}