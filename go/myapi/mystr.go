package myapi

import (
	"fmt"
	"strings"
	"strconv"
)

func Mystr(){
	//字符串使用
	str_sample()

	fmt.Println("========================1=======================")
	//========================================================================
	//strings包函数使用。
	string_function_sample()
}

/*
 * 字符串使用例子
 * author : RoadToTheExpert
 */
func str_sample() {
	str := "Hello"
	str += "World"

	fmt.Println("字符串相加:", str)
	fmt.Println("计算字符串长度：", len(str))
	fmt.Printf("获取对应下标字符： %c  %d \n", str[0], str[1])

	//字符串遍历
	r := []rune(str + "中国")
	fmt.Println("兼容unicode的字符串遍历：")
	for i := 0; i < len(r); i++ {
		fmt.Println(string(r[i]), r[i])
	}

	//字符串转整数
	n, err := strconv.Atoi("12")
	if err == nil {
		fmt.Printf("字符串转整数 : %d \n", n)
	}

	//整数转字符串
	fmt.Println("整数转字符串 : ", strconv.Itoa(12345))

	//字符串 转 []byte
	fmt.Println("字符串 转 []byte : ", []byte("hello go"))

	//[]byte 转 字符串
	fmt.Println("[]byte 转 字符串 : ", string([]byte{51, 52, 53, 54, 55, 56})) //可能存在unicode问题

	//十六进制
	fmt.Println("十六进制 : ", strconv.FormatInt(int64(28), 16))

	//二进制
	fmt.Printf("二进制 : ")
	fmt.Println(strconv.FormatInt(123, 2))

	//十六进制字符串转整数
	n2, _ := strconv.ParseInt("be", 16, 32)
	fmt.Printf("十六进制字符串转整数: %d  \n", int(n2))

	//格式化字符串
	fmt.Println(fmt.Sprintf("格式化字符串 0x%X", 62))
}

/*
 * strings包函数使用。
 */
func string_function_sample() {
	//该函数代码收集自互联网

	fmt.Println("查找子串是否在指定的字符串中")
	fmt.Println(" Contains 函数的用法")
	fmt.Println(strings.Contains("seafood", "foo")) //true
	fmt.Println(strings.Contains("seafood", "bar")) //false
	fmt.Println(strings.Contains("seafood", ""))    //true
	fmt.Println(strings.Contains("", ""))           //true 这里要特别注意
	fmt.Println(strings.Contains("我是中国人", "我"))     //true

	fmt.Println("")
	fmt.Println(" ContainsAny 函数的用法")
	fmt.Println(strings.ContainsAny("team", "i"))        // false
	fmt.Println(strings.ContainsAny("failure", "u & i")) // true
	fmt.Println(strings.ContainsAny("foo", ""))          // false
	fmt.Println(strings.ContainsAny("", ""))             // false

	fmt.Println("")
	fmt.Println(" ContainsRune 函数的用法")
	fmt.Println(strings.ContainsRune("我是中国", '我')) // true 注意第二个参数，用的是字符

	fmt.Println("")
	fmt.Println(" Count 函数的用法")
	fmt.Println(strings.Count("cheese", "e")) // 3
	fmt.Println(strings.Count("five", ""))    // before & after each rune result: 5 , 源码中有实现

	fmt.Println("")
	fmt.Println(" EqualFold 函数的用法")
	fmt.Println(strings.EqualFold("Go", "go")) //大小写忽略

	fmt.Println("")
	fmt.Println(" Fields 函数的用法")
	fmt.Println("Fields are: %q", strings.Fields(" foo bar baz ")) //["foo" "bar" "baz"] 返回一个列表

	//相当于用函数做为参数，支持匿名函数
	for _, record := range []string{" aaa*1892*122", "aaataat", "124|939|22"} {
		fmt.Println(strings.FieldsFunc(record, func(ch rune) bool {
			switch {
			case ch > '5':
				return true
			}
			return false
		}))
	}

	fmt.Println("")
	fmt.Println(" HasPrefix 函数的用法")
	fmt.Println(strings.HasPrefix("NLT_abc", "NLT")) //前缀是以NLT开头的

	fmt.Println("")
	fmt.Println(" HasSuffix 函数的用法")
	fmt.Println(strings.HasSuffix("NLT_abc", "abc")) //后缀是以NLT开头的

	fmt.Println("")
	fmt.Println(" Index 函数的用法")
	fmt.Println(strings.Index("NLT_abc", "abc")) // 返回第一个匹配字符的位置，这里是4
	fmt.Println(strings.Index("NLT_abc", "aaa")) // 在存在返回 -1
	fmt.Println(strings.Index("我是中国人", "中"))     // 在存在返回 6

	fmt.Println("")
	fmt.Println(" IndexAny 函数的用法")
	fmt.Println(strings.IndexAny("我是中国人", "中")) // 在存在返回 6
	fmt.Println(strings.IndexAny("我是中国人", "和")) // 在存在返回 -1

	fmt.Println("")
	fmt.Println(" Index 函数的用法")
	fmt.Println(strings.IndexRune("NLT_abc", 'b')) // 返回第一个匹配字符的位置，这里是4
	fmt.Println(strings.IndexRune("NLT_abc", 's')) // 在存在返回 -1
	fmt.Println(strings.IndexRune("我是中国人", '中'))   // 在存在返回 6

	fmt.Println("")
	fmt.Println(" Join 函数的用法")
	s := []string{"foo", "bar", "baz"}
	fmt.Println(strings.Join(s, ", ")) // 返回字符串：foo, bar, baz

	fmt.Println("")
	fmt.Println(" LastIndex 函数的用法")
	fmt.Println(strings.LastIndex("go gopher", "go")) // 3

	fmt.Println("")
	fmt.Println(" LastIndexAny 函数的用法")
	fmt.Println(strings.LastIndexAny("go gopher", "go")) // 4
	fmt.Println(strings.LastIndexAny("我是中国人", "中"))      // 6

	fmt.Println("")
	fmt.Println(" Map 函数的用法")
	rot13 := func(r rune) rune {
		switch {
		case r >= 'A' && r <= 'Z':
			return 'A' + (r-'A'+13)%26
		case r >= 'a' && r <= 'z':
			return 'a' + (r-'a'+13)%26
		}
		return r
	}
	fmt.Println(strings.Map(rot13, "'Twas brillig and the slithy gopher..."))

	fmt.Println("")
	fmt.Println(" Repeat 函数的用法")
	fmt.Println("ba" + strings.Repeat("na", 2)) //banana

	fmt.Println("")
	fmt.Println(" Replace 函数的用法")
	fmt.Println(strings.Replace("oink oink oink", "k", "ky", 2))
	fmt.Println(strings.Replace("oink oink oink", "oink", "moo", -1))

	fmt.Println("")
	fmt.Println(" Split 函数的用法")
	fmt.Printf("%qn", strings.Split("a,b,c", ","))
	fmt.Printf("%qn", strings.Split("a man a plan a canal panama", "a "))
	fmt.Printf("%qn", strings.Split(" xyz ", ""))
	fmt.Printf("%qn", strings.Split("", "Bernardo O'Higgins"))

	fmt.Println("")
	fmt.Println(" SplitAfter 函数的用法")
	fmt.Printf("%qn", strings.SplitAfter("/home/m_ta/src", "/")) //["/" "home/" "m_ta/" "src"]

	fmt.Println("")
	fmt.Println(" SplitAfterN 函数的用法")
	fmt.Printf("%qn", strings.SplitAfterN("/home/m_ta/src", "/", 2))  //["/" "home/m_ta/src"]
	fmt.Printf("%qn", strings.SplitAfterN("#home#m_ta#src", "#", -1)) //["/" "home/" "m_ta/" "src"]

	fmt.Println("")
	fmt.Println(" SplitN 函数的用法")
	fmt.Printf("%qn", strings.SplitN("/home/m_ta/src", "/", 1))

	fmt.Printf("%qn", strings.SplitN("/home/m_ta/src", "/", 2))  //["/" "home/" "m_ta/" "src"]
	fmt.Printf("%qn", strings.SplitN("/home/m_ta/src", "/", -1)) //["" "home" "m_ta" "src"]
	fmt.Printf("%qn", strings.SplitN("home,m_ta,src", ",", 2))   //["/" "home/" "m_ta/" "src"]

	fmt.Printf("%qn", strings.SplitN("#home#m_ta#src", "#", -1)) //["/" "home/" "m_ta/" "src"]

	fmt.Println("")
	fmt.Println(" Title 函数的用法") //这个函数，还真不知道有什么用
	fmt.Println(strings.Title("her royal highness"))

	fmt.Println("")
	fmt.Println(" ToLower 函数的用法")
	fmt.Println(strings.ToLower("Gopher")) //gopher

	fmt.Println("")
	fmt.Println(" ToLowerSpecial 函数的用法")

	fmt.Println("")
	fmt.Println(" ToTitle 函数的用法")
	fmt.Println(strings.ToTitle("loud noises"))
	fmt.Println(strings.ToTitle("loud 中国"))

	fmt.Println("")
	fmt.Println(" Replace 函数的用法")
	fmt.Println(strings.Replace("ABAACEDF", "A", "a", 2)) // aBaACEDF
	//第四个参数小于0，表示所有的都替换， 可以看下golang的文档
	fmt.Println(strings.Replace("ABAACEDF", "A", "a", -1)) // aBaaCEDF

	fmt.Println("")
	fmt.Println(" ToUpper 函数的用法")
	fmt.Println(strings.ToUpper("Gopher")) //GOPHER

	fmt.Println("")
	fmt.Println(" Trim 函数的用法")
	fmt.Printf("[%q]", strings.Trim(" !!! Achtung !!! ", "! ")) // ["Achtung"]

	fmt.Println("")
	fmt.Println(" TrimLeft 函数的用法")
	fmt.Printf("[%q]", strings.TrimLeft(" !!! Achtung !!! ", "! ")) // ["Achtung !!! "]

	fmt.Println("")
	fmt.Println(" TrimSpace 函数的用法")
	fmt.Println(strings.TrimSpace(" tn a lone gopher ntrn")) // a lone gopher

}
