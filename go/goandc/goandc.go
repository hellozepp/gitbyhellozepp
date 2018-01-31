package goandc

//#include<stdio.h>
//#include<stdlib.h>
//#include<unistd.h>
//#include "load_so.h"
//#cgo LDFLAGS: -ldl
/*
int display(char *str,int a,int b){
 printf("xxxx\n");
 printf("hello %s\n",str);//go ide有bug 打印不了这个，需要到终端执行go run才能看到效果
 return a+b;
}

extern void Xxx();

void testxxx() {
        printf("I am bar!\n");
        Xxx();
}

*/
import "C"//与ｃ代码不能有空行

import (
	"unsafe"
	"fmt"
)
func Mygoandc() {
	s := "xxx"
	cs := C.CString(s)
	fmt.Println(C.display(cs,1,2))
	C.free(unsafe.Pointer(cs))


	fmt.Println("20*30=", C.do_test_so_func(20, 30))


	C.testxxx()
}

