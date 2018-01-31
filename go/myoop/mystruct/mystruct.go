package mystruct

import "fmt"

func Mystruct() {
	type person struct{
		id int
		name string
	}
	var p1=person{1,"aaa"}
	var p2=person{}
	p2.id=2
	p2.name="bbb"
	fmt.Println(p1,p2)

	fmt.Println("========================1=======================")
	//========================================================================
	var p3=new(person)
	p3.id=3
	p3.name="ccc"
	(*p3).id=3
	(*p3).name="ccc"
	fmt.Println(p3,*p3)

	fmt.Println("========================2=======================")
	//========================================================================
	var tmpperson= struct {
		id int
		name string
	}{1,"aaa"}
	fmt.Println(tmpperson)

	fmt.Println("======")

	var tmppersonptr= &struct {
		id int
		name string
	}{1,"aaa"}
	fmt.Println(tmppersonptr)
	fmt.Println("========================3=======================")
	//========================================================================
	var o1=Obj{1,"aaa"}
	var o2=&Obj{2,"bbb"}
	changeObj(o1,o2)
	fmt.Println(o1,o2)

	fmt.Println("========================4=======================")
	//========================================================================
	var car=struct {
		id int
		name string
		style struct{
			color int
			model string
		}
	}{1,"aaa", struct {
		color int
		model string
	}{color: 1, model: "xxx"}}
	fmt.Println(car)

	fmt.Println("======")

	car.id=2
	car.name="bbb"
	car.style.color=2
	car.style.model="yyy"
	fmt.Println(car)

	fmt.Println("========================5=======================")
	//========================================================================
	var cartemp1=struct{
		int
		string
	}{1,"xxx"}
	fmt.Println(cartemp1)

	fmt.Println("======")

	var cartemp2=struct{
		int
		string
		//string//使用匿名属性，属性数据类型不能重复，其实质上是把类型当做属性名使用了
		style struct{
			int
			string
		}
	}{1,"xxx", struct {
		int
		string
	}{2, "yyy" }}
	fmt.Println(cartemp2)

	fmt.Println(cartemp2.int,cartemp2.string,cartemp2.style.int,cartemp2.style.string)

	fmt.Println("========================6=======================")
	//========================================================================
	type Person struct {
		id int
		name string
	}
	type stu struct{
		Person
		age int
	}
	type tea struct{
		Person
		cource string
	}
	var s=stu{
		Person:Person{id:1,name:"aaa"},
		age:22,
	}
	var t=tea{}
	t.Person.id=2
	t.id=2
	t.Person.name="bbb"
	t.name="bbb"
	t.cource="ccc"

	fmt.Println(s,t)

	fmt.Println("========================7=======================")
	//========================================================================
	type Base struct {
		basename string
	}
	type Derive struct {
		*Base
		id int
	}
	var d=Derive{&Base{basename:"xxx"},1}
	fmt.Println(d)
}
type Obj struct {
	id int
	name string
}
func changeObj(o1 Obj,o2 *Obj){
	o1.id=3
	o1.name="ccc"
	o2.id=4
	o2.name="ddd"
}
