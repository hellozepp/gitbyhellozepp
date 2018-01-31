package myfile

import (
	"os"
	"fmt"
	"io"
	"bufio"
	"io/ioutil"
	"path/filepath"
)

func Myfile(){
	mywritefile()

	fmt.Println("========================1=======================")
	//========================================================================
	myreadfile()

	mycopyfile()

	mybufiocopyfile()//使用bufio拷贝文件

	//使用ioutil拷贝文件
	myioutilcopyfile()

	fmt.Println("========================2=======================")
	//========================================================================
	mygetFilelist("/data")
}

func mywritefile() {
	userFile := "/disk/mygopath/src/iotestgo/res/myfile.txt" //文件路径
	fout,err := os.Create(userFile) //根据路径创建File的内存地址
	defer fout.Close() //延迟关闭资源
	if err != nil{
		fmt.Println(userFile,err)
		return
	}

	fout.WriteString("Hello world!\n") //写入字符串
	fout.Write([]byte("abcd!\n"))//强转成byte slice后再写入

}

func myreadfile() {
	userFile := "/disk/mygopath/src/iotestgo/res/myfile.txt" //文件路径
	fin,err := os.Open(userFile) //打开文件,返回File的内存地址
	defer fin.Close() //延迟关闭资源
	if err != nil{
		fmt.Println(userFile,err)
		return
	}
	buf := make([]byte,1024)//创建一个初始容量为1024的slice,作为缓冲容器
	for{
		//循环读取文件数据到缓冲容器中,返回读取到的个数
		n,_ := fin.Read(buf)

		if 0==n{
			break //如果读到个数为0,则读取完毕,跳出循环
		}
		//从缓冲slice中写出数据,从slice下标0到n,通过os.Stdout写出到控制台
		os.Stdout.Write(buf[:n])
	}
}

func mycopyfile() {
	fi, err := os.Open("/disk/mygopath/src/iotestgo/res/input.txt")//打开输入*File
	if err != nil { panic(err) }
	defer fi.Close()

	fo, err := os.Create("/disk/mygopath/src/iotestgo/res/output.txt")//创建输出*File
	if err != nil { panic(err) }
	defer fo.Close()

	buf := make([]byte, 1024)
	for {
		n, err := fi.Read(buf)//从input.txt读取
		if err != nil && err != io.EOF { panic(err) }
		if n == 0 { break }

		if n2, err := fo.Write(buf[:n]); err != nil {//写入output.txt,直到错误
			panic(err)
		} else if n2 != n {
			panic("error in writing")
		}
	}
}


func mybufiocopyfile() {
	fi, err := os.Open("/disk/mygopath/src/iotestgo/res/input.txt")//打开输入*File
	if err != nil { panic(err) }
	defer fi.Close()
	r := bufio.NewReader(fi)//创建一个读取缓冲流

	fo, err := os.Create("/disk/mygopath/src/iotestgo/res/output.txt")//创建输出*File
	if err != nil { panic(err) }
	defer fo.Close()
	w := bufio.NewWriter(fo)//创建输出缓冲流

	buf := make([]byte, 1024)
	for {
		n, err := r.Read(buf)
		if err != nil && err != io.EOF { panic(err) }
		if n == 0 { break }

		if n2, err := w.Write(buf[:n]); err != nil {
			panic(err)
		} else if n2 != n {
			panic("error in writing")
		}
	}

	if err = w.Flush(); err != nil { panic(err) }
}

func myioutilcopyfile() {
	b, err := ioutil.ReadFile("/disk/mygopath/src/iotestgo/res/input.txt")//读文件
	if err != nil { panic(err) }

	err = ioutil.WriteFile("/disk/mygopath/src/iotestgo/res/output.txt", b, 0644)//写文件
	if err != nil { panic(err) }
}

func mygetFilelist(path string) {
	err := filepath.Walk(path, func(path string, f os.FileInfo, err error) error {
		if ( f == nil ) {
			return err
			}
		if f.IsDir() {
			return nil
			}
		println(path)
		return nil
	})
	if err != nil {
		fmt.Println(err)
	}
}