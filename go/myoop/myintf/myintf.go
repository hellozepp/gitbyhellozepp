package myintf

import (
	"fmt"
	"strconv"
)

func Myintf(){
	s:=student{}
	s.id=1
	s.name="aaa"
	s.age=22
	str:=s.dorun(100)
	printinfo(str,s)

}

type irun interface {
	dorun(i int)string
	dis()
}

type ijump interface {
	dojump(i int)string
	dis()
}

type person struct{
	id int
	name string
}

type student struct{
	person
	age int
}

func (s *student)dorun(i int)string{
	return strconv.Itoa(s.id)+" "+s.name+" is runing at "+strconv.Itoa(i)+" speed...... his age is "+strconv.Itoa(s.age)
}

func (p *person)dojump(i int)string{
	return strconv.Itoa(p.id)+" "+p.name+" is runing at "+strconv.Itoa(i)+" speed......"
}

func printinfo(s string,obj interface{}){
	if v,ok:=obj.(student);ok{
		fmt.Println("hello "+v.name)
		fmt.Println(s)
	}else{
		fmt.Println("呵呵")
	}

	switch value :=obj.(type) {
	case person:
		fmt.Println(value.name+" is student")
	case student:
		fmt.Println(value.name+" is student")
	default:
		fmt.Println("呵呵")
	}
}