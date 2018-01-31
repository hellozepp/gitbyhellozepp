package myvar

import (
	"fmt"
	"strconv"
)

var (
	a1,_,c1=1,2,3
)

func Myvar()  {

	var i1 int32=123
	fmt.Println(i1)

	var i2=123
	fmt.Println(i2)

	i3:=123

	fmt.Println(i3)

	fmt.Println("========================1=======================")
	//========================================================================

	var a,_,c int=1,2,3
	fmt.Println(a,c)
	fmt.Println(a1,c1)
	fmt.Println("========================2=======================")
	//========================================================================
	var j=10
	fmt.Println("hello "+strconv.Itoa(j))
	j1,_:=strconv.Atoi("123")
	fmt.Println(j1)

	var k=1.1
	fmt.Println(int(k))

	fmt.Println("========================3=======================")
	//========================================================================
	type size int
	var s size=12
	fmt.Println(s)

	fmt.Println("========================4=======================")
	//========================================================================
	var f,g=1,"abc"
	fmt.Println(f,g)

	fmt.Println("========================5=======================")
	//========================================================================
	const z="abc"
	//zz:="abc"
	fmt.Println(z)
	const(
		z1="abc"
		z2=len(z1)//等同于写死３
		z3=123
		//z4=len(zz) //由于zz不是常量，编译时无法取得立即数，所以无法在编译的时候计算len，因此无法为常量赋值
	)
	fmt.Println(z1,z2,z3)
	const (
		k1=iota
		k2
		k3=100
		k4
		k5=iota
		k6
	)
	const (
		k11=iota
		k21
		k31
		k41=iota
	)
	fmt.Println(k1,k2,k3,k4,k5,k6)
	fmt.Println(k11,k21,k31,k41)

	fmt.Println("========================6=======================")
	//========================================================================

	/*

		二进制   十进制

            01100   12

            10110   22

		-----------------------

		二元位运算符  二进制   十进制    逻辑

			&       00100   4        相同位的两个数字­都为1，则为1；若有一个不为1，则为0。

			|       11110   30       相同位只要一个为1即为1。否则为0

			^       11010   26       相同位不同为1则为1，否则为0。

			&^      01000   8        如果第二个数是1，则强制把第一个数改成0，否则不变。

	*/
	fmt.Println(12 & 22)
	fmt.Println(12 | 22)
	fmt.Println(12 ^ 22)
	fmt.Println(12 &^ 22)

	fmt.Println("========================7=======================")
	//========================================================================
	f1, _ := strconv.ParseFloat("1.234", 64)
	fmt.Println(f1)

	i, _ := strconv.ParseInt("123", 0, 64)
	fmt.Println(i)

	d, _ := strconv.ParseInt("0x1c8", 0, 64)
	fmt.Println(d)

	u, _ := strconv.ParseUint("789", 0, 64)
	fmt.Println(u)

	kk, _ := strconv.Atoi("135")
	fmt.Println(kk)

	_, e := strconv.Atoi("wat")
	fmt.Println(e)

}
