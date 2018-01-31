package mypkg

//import "fmt"  //1

//import stdio "fmt" //2

//import . "fmt" //3
import (
	"fmt"
	"strconv"
) //4
func Mypkg()  {
	//fmt.Println("hello world!")  //1
	//stdio.Println("stdio hello world!") //2
	//Println(". hello world!") //3

	//4
	var istr int=123456
	fmt.Println(strconv.Itoa(istr))
}
