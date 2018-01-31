package myapi

import (
	"regexp"
	"fmt"
	"os"
	"net/http"
	"io/ioutil"
	iconv "github.com/djimenez/iconv-go" //go get github.com/djimenez/iconv-go
)

func MyReg(){
	//匹配到这个字符串的例子
	var digitsRegexp = regexp.MustCompile(`(\d+)\D+(\d+)`)
	someString:="1000abcd123"
	fmt.Println(digitsRegexp.FindStringSubmatch(someString))

	fmt.Println("========================1=======================")
	//========================================================================
	//使用带命名的正则表达式
	var myExp=regexp.MustCompile(`(?P<first>\d+)\.(\d+).(?P<second>\d+)`)
	fmt.Printf("%+v",myExp.FindStringSubmatch("1234.5678.9"))

	fmt.Println("========================2=======================")
	//========================================================================
	//对正则表达式类扩展一个获得所有命名信息的方法，并使用它
	var myExp2=myRegexp{regexp.MustCompile(`(?P<first>\d+)\.(\d+).(?P<second>\d+)`)}
	mmap:=myExp2.FindStringSubmatchMap("1234.5678.9")
	ww:=mmap["first"]
	fmt.Println(mmap)
	fmt.Println(ww)

	fmt.Println("========================3=======================")
	//========================================================================
	//抓取限号信息，并记录到一个Map中
	var myExp3=myRegexp{regexp.MustCompile(`自(?P<byear>[\d]{4})年(?P<bmonth>[\d]{1,2})月(?P<bday>[\d]{1,2})日至(?P<eyear>[\d]{4})年(?P<emonth>[\d]{1,2})月(?P<eday>[\d]{1,2})日，星期一至星期五限行机动车车牌尾号分别为：(?P<n11>[\d])和(?P<n12>[\d])、(?P<n21>[\d])和(?P<n22>[\d])、(?P<n31>[\d])和(?P<n32>[\d])、(?P<n41>[\d])和(?P<n42>[\d])、(?P<n51>[\d])和(?P<n52>[\d])`)}
	response,err:=http.Get("http://www.bjjtgl.gov.cn/zhuanti/10weihao/index.html")
	defer response.Body.Close()

	if err!=nil{
		ErrorAndExit(err)
	}

	input,err:=ioutil.ReadAll(response.Body)
	if err!=nil{
		ErrorAndExit(err)
	}

	body :=make([]byte,len(input))


	iconv.Convert(input,body,"utf-8","utf-8")

	fmt.Println(string(body))

	mmap3:=myExp3.FindStringSubmatchMap2(string(body))

	fmt.Println(mmap3)


}

func ErrorAndExit(err error){
	fmt.Fprintln(os.Stderr,err)
	os.Exit(1)
}

type myRegexp struct{
	*regexp.Regexp
}

func(r *myRegexp)FindStringSubmatchMap(s string) map[string]string{
	captures:=make(map[string]string)

	match:=r.FindStringSubmatch(s)
	if match==nil{
		return captures
	}

	for i,name:=range r.SubexpNames(){
		//Ignore the whole regexp match and unnamed groups
		if i==0||name==""{
			continue
		}

		captures[name]=match[i]

	}
	return captures
}

func(r *myRegexp)FindStringSubmatchMap2(s string)[](map[string]string){
	captures:=make([](map[string]string),0)

	matches:=r.FindAllStringSubmatch(s,-1)

	if matches==nil{
		return captures
	}

	names:=r.SubexpNames()

	for _,match:=range matches{

		cmap:=make(map[string]string)

		for pos,val:=range match{
			name:=names[pos]
			if name==""{
				continue
			}

			/*
				fmt.Println("+++++++++")
				fmt.Println(name)
				fmt.Println(val)
			*/
			cmap[name]=val
		}

		captures=append(captures,cmap)

	}

	return captures
}
