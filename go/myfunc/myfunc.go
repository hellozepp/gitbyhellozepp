package myfunc

import (
	"fmt"
	"strconv"
)

func Myfunc(){  //公有函数
	res1,_:=myfun1(1,2,"3")
	fmt.Println(res1)

	fmt.Println("======")

	res2,_:=myfun2(4,5,"6")
	fmt.Println(res2)

	fmt.Println("======")

	res3,_:=myfun3("6",1,2,3,4,5)
	fmt.Println(res3)
	fmt.Println("========================1=======================")
	//========================================================================
	a:=1
	b:=2
	c:=[]int{1,2}
	myfun31(c,a,b)//a,b拷贝到新的栈后被组装成了切片，并非真的传入了切片
	fmt.Println(a,b,c)

	fmt.Println("========================2=======================")
	//========================================================================
	var add= func(a,b int)(int) { //函数是类型
		return a+b
	}
	fmt.Println(add(1,2))

	fmt.Println("======")

	var opt= func(a,b int,myfunc func(int,int)(int))(int) { //参数是函数
		return myfunc(a,b)
	}
	fmt.Println(opt(1,2,add))

	fmt.Println("======")

	var cl= func(x int)(func(int)(int)) { //返回值是函数，典型案例，闭包
		return func(y int)(int){
			x++
			return x+y
		}
	}
	mycl1:=cl(1)
	m1:=mycl1(1)
	m2:=mycl1(1)
	mycl2:=cl(1)
	m3:=mycl2(1)
	fmt.Println(m1,m2,m3)

	fmt.Println("========================3=======================")
	//========================================================================
	type funcc func(int,int)(int)  //定义函数类型
	var opt1= func(a,b int,myfunc funcc)(int) {
		return myfunc(a,b)
	}
	fmt.Println(opt1(1,2,add))

	fmt.Println("======")

	var funptr=new(func(int,int)(int)) //定义函数指针
	//不可以如下定义
	//funptr=new(funcc)//funcc!=func(int,int)(int)
	funptr=&add
	fmt.Println(opt1(1,2,*funptr))

	fmt.Println("======")
	var opt2= func(a,b int,myfunc *funcc)(int) {
		return (*myfunc)(a,b)
	}
	var ff funcc=add //如果想用自定义类型，必须明确类型名，
	// 如果写成var ff=add也就是自动推导的话，系统不会识别这个add是funcc类型，只会识别它是func(int,int)(int)
	//funptr=new(funcc)//funcc!=func(int,int)(int)
	fmt.Println(opt2(1,2,&ff))

}

func myfun1(a,b int,c string)(int,error){ //私有函数
	d,err:=strconv.Atoi(c)
	return a+b+d,err
}

func myfun2(a,b int,c string)(e int,err error){ //私有函数
	d,err:=strconv.Atoi(c)
	e= a+b+d
	return
}

func myfun3(c string,a... int)(e int,err error){ //私有函数
	d,err:=strconv.Atoi(c)
	for _,v:=range a{
		d=d+v
	}
	e=d
	return
}

func myfun31(c []int,a... int){ //私有函数
	c[0]=123
	a[0]=123
}


