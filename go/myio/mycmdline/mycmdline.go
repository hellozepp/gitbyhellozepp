package mycmdline

import (
	"flag"
	"fmt"
	"os"
)

func Mycmdline() {
	flagtest1()

	fmt.Println("========================1=======================")
	//========================================================================
	args := os.Args //获取用户输入的所有参数
	if args == nil || len(args) <2{//如果用户没有输入,或参数个数不够,则调用该函数提示用户
		fmt.Println("you name?");
		fmt.Println("you age?");
		return
	}
	name := args[1] //获取输入的第一个参数
	age := args[2]  //获取输入的第二个参数
	fmt.Println("your name is:",name,"\nyour age is:",age)
}

func flagtest1() {
	married := flag.Bool("married", false, "Are you married?")
	age := flag.Int("age", 22, "How old are you?")
	name := flag.String("name", "", "What your name?")

	var address string
	//flag.StringVar这样的函数第一个参数换成了变量地址，后面的参数和flag.String是一样的。
	flag.StringVar(&address, "address", "GuangZhou", "Where is your address?")

	flag.Parse() //解析输入的参数

	fmt.Println("输出的参数married的值是:", *married)//不加*号的话,输出的是内存地址
	fmt.Println("输出的参数age的值是:", *age)
	fmt.Println("输出的参数name的值是:", *name)
	fmt.Println("输出的参数address的值是:", address)
}