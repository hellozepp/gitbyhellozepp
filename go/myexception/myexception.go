package myexception

import (
	"fmt"
	"errors"
)

type Myerr struct {
	str string
}
func (e *Myerr)Error()string{
	return e.str
}

func Myexception(){

	f1:= func(i int)(int,error) {
		return i+1,errors.New("xxx")
	}
	v,err:=f1(1)
	fmt.Println(v,err)

	fmt.Println("========================1=======================")
	//========================================================================
	f2:= func(i int)(int,error) {
		err:=new(Myerr)
		err.str="ppp"
		return i+1,err
	}
	v2,err2:=f2(1)
	fmt.Println(v2,err2)

	fmt.Println("========================2=======================")
	//========================================================================

	//testexception1()
	//testexception21()
	testexception22()

	fmt.Println("========================3=======================")
	//========================================================================
	testexception3()

	fmt.Println("========================4=======================")
	//========================================================================
	defer rec() //rec必须使用defer运行，因为只有这样才能有：注册（类似于try{）--＞异常-->defer执行（相当于｝）-->recover（相当于catch）的效果
	pan()

}

func testexception1(){  //相当于不写try catch
	funca()
	funcb1()
	funcc()
}
func testexception21(){ //相当于b21里面写了try catch,但是写错了
	funca()
	funcb21()
	funcc()
}

func testexception22(){ //相当于b21里面写了try catch
	funca()
	funcb22()
	funcc()

}
func testexception3(){
	defer func() {
		err:=recover()
		if err!=nil{
			fmt.Println(err)
		}
	}()
	funca()
	funcb1()
	funcc()

	//分析：
	/*
	1.将 func() {
		err:=recover()
		if err!=nil{
			fmt.Println(err)
		}
	}()压入栈中
	2.执行funca()
	3.执行funcb1(),由于funcb1()抛出了错误，因此函数结束，开始弹栈
	4.弹出１，执行１

	 */

}

func funca(){
	fmt.Println("AAAAA")
}
func funcb1(){
	panic("B error")
}

func funcb21(){
	panic("B error")
	defer func() {
		err:=recover()
		if err!=nil{
			fmt.Println(err)
		}
	}()

	//分析：
	/*
	panic("B error")
	try{}catch(e){}
	 */
}

func funcb22(){
	defer func() {
		err:=recover()
		if err!=nil{
			fmt.Println(err)
		}
	}()
	panic("B error")
	//分析：
	/*

	try{
		panic("B error")
	}catch(e){}
	 */
}
func funcc(){
	fmt.Println("CCCCC")
}



func pan(){
	panic("xxx")
}

func rec(){
	err:=recover()
	fmt.Println(err)
}