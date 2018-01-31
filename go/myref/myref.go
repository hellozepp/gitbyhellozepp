package myref

import (
	"reflect"
	"fmt"
	"strconv"
)

type person struct{
	int
	name string
}

func (p person)Dis(){ //*student不属于student 仅属于*student对象
	fmt.Println(p)
}

type student struct {
	person
	age int
	Sex int
}
func (s student)Sayhello(toname string)(string,int){ //如果方法不是大写第一个字母的公开方法，是无法被反射获取的
	return s.name+" say hello to "+toname,1
}

func (s *student)Dis(){ //*student不属于student 仅属于*student对象
	fmt.Println(s)
}
func Myref() {
	s:=student{person:person{int:1,name:"aaa"},age:22}
	t:=reflect.TypeOf(s)
	v:=reflect.ValueOf(s)

	fmt.Println(t)//获取字段属性以及字段相关的东西
	fmt.Println(v)//获取字段的值以及值相关的东西

	fmt.Println("========================1=======================")
	//========================================================================
	for i:=0;i<t.NumField();i++{
		key:=t.Field(i)
		val:=v.Field(i)
		fmt.Println(key.Name,key.Type,"|",val)
	}

	fmt.Println("======")

	for i:=0;i<t.NumMethod();i++{  //仅能获取非指针对象的引用方法
		m:=t.Method(i)
		fmt.Println(m.Name,m.Type)
	}

	fmt.Println("========================2=======================")
	//========================================================================
	t1:=reflect.TypeOf(&s)
	v1:=reflect.ValueOf(&s)
	fmt.Println(t1)
	fmt.Println(v1)

	fmt.Println("======")

	if k:=t1.Kind();k==reflect.Struct{
		for i:=0;i<t1.NumField();i++{
			key:=t1.Field(i)
			val:=v1.Field(i)
			fmt.Println(key.Name,key.Type,"|",val)
		}
	}

	for i:=0;i<t1.NumMethod();i++{ //可以获取所有方法，但是不能用指针获取属性
		m:=t1.Method(i)
		fmt.Println(m.Name,m.Type)
	}


	fmt.Println("========================3=======================")
	//========================================================================
	fmt.Println(t.FieldByName("person"))
	fmt.Println(t.FieldByIndex([]int{0}))
	fmt.Println(t.FieldByIndex([]int{0,0}),t.FieldByIndex([]int{0,1}))
	m2, _ :=t.MethodByName("Sayhello")
	fmt.Println(m2)

	fmt.Println("========================4=======================")
	//========================================================================
	x:=123
	vx:=reflect.ValueOf(&x)
	vx.Elem().SetInt(333)
	fmt.Println(x)

	fmt.Println("======")

	s11:=student{person:person{int:1,name:"aaa"},age:22,Sex:1}
	fmt.Println(s11)
	v11:=reflect.ValueOf(&s11)
	v11.Elem().FieldByName("age").CanSet()//小写是只读
	fmt.Println(v11.Elem().FieldByName("Sex").CanSet())//大写才是读写
	if v11.Elem().FieldByName("age").CanSet(){
		v11.Elem().FieldByName("age").SetInt(99)
	}
	if v11.Elem().FieldByName("Sex").CanSet(){
		v11.Elem().FieldByName("Sex").SetInt(2)
	}
	fmt.Println(s11)

	fmt.Println("======")

	fv := reflect.ValueOf(prints)
	params := make([]reflect.Value,1)  //参数
	params[0] = reflect.ValueOf(20)   //参数设置为20
	rs := fv.Call(params)              //rs作为结果接受函数的返回值
	fmt.Println("result:",rs[0].Interface().(string)) //当然也可以直接是rs[0].Interface()

	fmt.Println("======")

	params1 := make([]reflect.Value,1)  //参数
	params1[0] = reflect.ValueOf("ppp")   //参数设置为20
	b := reflect.ValueOf(s11).MethodByName("Sayhello").Call(params1)
	fmt.Println(b[0],"|",b[1])

	b1 := reflect.ValueOf(&s11).MethodByName("Dis").Call([]reflect.Value{})
	fmt.Println(b1)

	fmt.Println("========================5=======================")
	//========================================================================

	// TypeOf
	str := "this is string"
	fmt.Println(reflect.TypeOf(str)) // output: "string"

	fmt.Println("======")

	// object TypeOf
	a := new(person)
	a.name = "xxx"
	typ := reflect.TypeOf(a)
	fmt.Println(typ)        // output: "*myref.person"
	fmt.Println(typ.Elem()) // output: "myref.person"

	// reflect.Type Base struct
	fmt.Println(typ.NumMethod())                   // 1
	fmt.Println(typ.Method(0))                     // {GetName  func(*myref.person) <func(*myref.person) Value> 0}
	fmt.Println(typ.Name())                        // ""
	fmt.Println(typ.PkgPath())                     // ""
	fmt.Println(typ.Size())                        // 8
	fmt.Println(typ.String())                      // *myref.person
	fmt.Println(typ.Elem().String())               // myref.person
	fmt.Println(typ.Elem().FieldByIndex([]int{0})) // {int go.builtin int  0 [0] true}
	fmt.Println(typ.Elem().FieldByName("name"))    // {name iotestgo/myref string  8 [1] false} true

	fmt.Println(typ.Kind() == reflect.Ptr)                              // true
	fmt.Println(typ.Elem().Kind() == reflect.Struct) // true

	fmt.Println("======")

	fmt.Println(reflect.TypeOf(12.12).Bits()) // 64, 因为是float64


	fmt.Println("======")

	cha := make(chan int)
	fmt.Println(reflect.TypeOf(cha).ChanDir()) // chan

	var fun func(x int, y ...float64) string
	var fun2 func(x int, y float64) string
	fmt.Println(reflect.TypeOf(fun).IsVariadic())  // true
	fmt.Println(reflect.TypeOf(fun2).IsVariadic()) // false
	fmt.Println(reflect.TypeOf(fun).In(0))         // int
	fmt.Println(reflect.TypeOf(fun).In(1))         // []float64
	fmt.Println(reflect.TypeOf(fun).NumIn())       // 2
	fmt.Println(reflect.TypeOf(fun).NumOut())      // 1
	fmt.Println(reflect.TypeOf(fun).Out(0))        // string


	fmt.Println("======")

	mp := make(map[string]int)
	mp["test1"] = 1
	fmt.Println(reflect.TypeOf(mp).Key()) //string

	arr := [1]string{"test"}
	fmt.Println(reflect.TypeOf(arr).Len()) // 1

}
func prints(i int) string {
	fmt.Println("i =",i)
	return strconv.Itoa(i)
}