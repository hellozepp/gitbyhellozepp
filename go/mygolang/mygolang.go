package mygolang

import (
	"fmt"
	"strconv"
)

func Mygolang(){
	var i string
	fmt.Scanln(&i)
	j:=100
	if j,_:=strconv.Atoi(i);j<5{ //if支持一个初始化表达式
		fmt.Println(j,"<5")
	}else if j<10 {
		fmt.Println(j,"<10")
	}else{
		fmt.Println(j,"else")
	}
	fmt.Println(j)

	fmt.Println("========================1=======================")
	//========================================================================
	k:=0
	for{
		if k>=3{
			break
		}
		fmt.Println(k)
		k++
	}

	fmt.Println("======")

	k=0
	for k<3{
		fmt.Println(k)
		k++
	}

	fmt.Println("======")

	for k=0;k<3;k++{
		fmt.Println(k)
	}

	fmt.Println("========================2=======================")
	//========================================================================
	j1,_:=strconv.Atoi(i)
	switch j1 {
	case 0:
		fmt.Println("00000")
	case 1:
		fmt.Println("11111")
		fallthrough
	case 2:
		fmt.Println("22222")
	default:
		fmt.Println("default")

	}

	fmt.Println("======")

	switch j2:=j1; {
	case j2<5:
		fmt.Println("<5")
	case j2<10:
		fmt.Println("<10")
		fallthrough
	case j2<20:
		fmt.Println("<20")
	default:
		fmt.Println("default")

	}

	fmt.Println("========================3=======================")
	//========================================================================
	xxx:
		for i:=1;i<10;i++{
			for j:=1;j<10;j++{
				if i+j==5{
					break xxx
				}
				fmt.Println(i+j)
			}
			fmt.Println("{{{")
		}
		fmt.Println("xxx")

		fmt.Println("=======")

	xxx1:
		for i:=1;i<3;i++{
			for j:=1;j<3;j++{
				if i+j==5{
					continue xxx1
				}
				fmt.Println(i+j)
			}
			fmt.Println("{{{1")
		}
		fmt.Println("xxx1")

	fmt.Println("========================4=======================")
	//========================================================================
	aaa:
		fmt.Scanln(&i)
		jj,_:=strconv.Atoi(i)
		if jj==0{
			goto aaa
		}else{
			goto bbb
		}
		fmt.Println("-----")
		bbb:
			fmt.Println(jj)

	fmt.Println("========================５=======================")
	//========================================================================
	var ptr *int=&jj
	fmt.Println(ptr,*ptr)
}
