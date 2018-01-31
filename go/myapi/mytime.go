package myapi

import (
	"fmt"
	"time"
)

func Mytime() {
	now := time.Now()
	secs := now.Unix()
	nanos := now.UnixNano()
	fmt.Println(now)
	millis := nanos / 1000000
	fmt.Println(secs)
	fmt.Println(millis)
	fmt.Println(nanos)

	fmt.Println(time.Unix(secs, 0))
	fmt.Println(time.Unix(0, nanos))

	fmt.Println("========================1=======================")
	//========================================================================
	//返回现在时间
	tNow := time.Now()
	//时间转化为string，layout必须为 "2006-01-02 15:04:05"
	timeNow := tNow.Format("2006-01-02 15:04:05")
	fmt.Println("tNow(time format):", tNow)
	fmt.Println("tNow(string format):", timeNow)

	//string转化为时间，layout必须为 "2006-01-02 15:04:05"
	t, _ := time.Parse("2006-01-02 15:04:05", "2014-06-15 08:37:18")
	fmt.Println("t(time format)", t)

	//某个时间点 前后判断
	trueOrFalse := t.After(tNow)
	if trueOrFalse == true {
		fmt.Println("t（2014-06-15 08:37:18）在tNow之后!")
	} else {
		fmt.Println("t（2014-06-15 08:37:18）在tNow之前!")
	}

	fmt.Println("========================2=======================")
	//========================================================================
	//获取时间戳
	timestamp := time.Now().Unix()
	fmt.Println(timestamp)

	//格式化为字符串,tm为Time类型
	tm := time.Unix(timestamp, 0)
	fmt.Println(tm.Format("2006-01-02 03:04:05 PM"))
	fmt.Println(tm.Format("02/01/2006 15:04:05 PM"))

	//从字符串转为时间戳，第一个参数是格式，第二个是要转换的时间字符串
	tm2, _ := time.Parse("01/02/2006", "02/08/2015")
	fmt.Println(tm2.Unix())

}