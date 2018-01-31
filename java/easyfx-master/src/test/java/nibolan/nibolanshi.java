package nibolan;
/**
 *
 * loop:读取读取输入的字符串，将当前读入的字符记为a：
 step1:如果a为操作数则直接append到stringbuffer中.
 step2:如果a为左括号“（”则将a进栈
 step3:如果a为右括号，则从栈顶开始找，并移动栈顶指针，如果当前栈顶元素非左括号则将栈顶元素append到
 stringbuffer中，直到找到第一个左括号，找到后将左括号出栈,并注意不要将左括号放到stringbuffer中.
 step4:如果a为运算符，则取栈顶元素和a进行比较如果栈顶元素的运算符优先级小于a则将a入栈，否则将栈顶
 弹出存到stringbuffer中，直到栈顶元素的运算符优先级小于a为址，注左括号和右括号的运算优先级比+-* /都低在这里 d loop;
 最后将stringbuffer进行toString并拼上stack中的元素就得到后缀表达式

 2.计算逆波兰式的思路

 定义一栈 stack:
 输入一段后缀表达式如12+:
 loop:逐个读取字符串中的字符记为b:
 1.如果a为操作数，则入栈
 2.如果a为操作符，则弹出栈顶最前进两个数用运算符a进行计算,并将计算结果入栈
 end loop;

 3,最后将stack的栈元素输入则为运算结果

 首先定义一个简单栈,所有代码中都没有进行异常判断，
 栈:



* */
//将用户输入的中缀表达式转化成后缀表式
//并根据后缀表达式计算结果表明  
public class nibolanshi {
  
    //此函数只能处理字符串中的数字全是个位数的情况，如果存在十位以上的则此函数的参数就不能用string了  
    //要改为传入一个栈了,并且只计算整数，其它的float,double需稍作修改
    public int countRpn(String src) {  
        MyStack<String> stack = new MyStack<String>();
        for (int i = 0; i < src.length(); i++) {  
            String foo = src.charAt(i) + "";  
            if (!isOperator(foo)) {  
                stack.push(foo);  
            } else {//如果是运算符  
                // 取栈顶两元素进行计算，并将计算结果放入栈顶  
                String a = stack.pop();  
                String b = stack.pop();  
                int temp = count(b, a, foo);
                stack.push(temp + "");  
  
            }  
        }  
        return Integer.parseInt(stack.pop());//最后栈顶元素的值就是表达式的值了  
    }  
  
    // 是否为运算符  
    public boolean isOperator(String e) {  
        if (null == e || "".equals(e)) {  
            return false;  
        }  
        return "+".equals(e) || "*".equals(e) || "-".equals(e) || "/".equals(e);  
    }  
  
    // 是否是左括号  
    public boolean isLeft(String s) {  
        return "(".equals(s);  
    }  
   //是否是右括号  
    public boolean isRight(String s) {  
        return ")".equals(s);  
    }  
  
    // 根据运算符（e）计算两个数的值班(a,b)  
    public int count(String a, String b, String e) {  
        int temp1 = Integer.parseInt(a);  
        int temp2 = Integer.parseInt(b);  
        if ("+".equals(e)) {  
            return temp1 + temp2;  
        } else if ("-".equals(e)) {  
            return temp1 - temp2;  
        } else if ("*".equals(e)) {  
            return temp1 * temp2;  
        } else {  
            return temp1 / temp2;  
        }  
    }  
  
    // 将中缀表达式转化为后缀表达式（逆波兰式）  加减找*/弹栈，没有*/自己存到字符串，*/直接压栈，左括号压栈，右括号除左括号为全部谈到字符串
    public String reverse2Rpn(String src) {
        MyStack<String> stack = new MyStack<String>();  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < src.length(); i++) {  
            String temp = src.charAt(i) + "";  
            if (!isOperator(temp) && !isRight(temp) && !isLeft(temp)) {  
                // 操作数，+-直接输出  
                sb.append(temp);  
            } else if (isOperator(temp)) {  
                // 如果是操作符  
                if (stack.size() == 0) {// 如果zhan为空则入zhan  
                    stack.push(temp);  
                } else if ("+".equals(temp) || "-".equals(temp)) {  
                    if (isLeft(stack.top())) {//如果栈顶为左括号，则直接入栈  
                        stack.push(temp);//直接将操作符入栈  
                    } else {//从栈顶往下找，直到找到当前栈顶的操作符优先级小于等于当前操作符  
                        String top = stack.top();  
                        boolean next = true;  
                        while (("*".equals(top) || "/".equals(top)) && next) {  
                            top = stack.pop();  
                            sb.append(top);// 弹出顶部元素  
                            next = stack.size() == 0 ? false : true;  
                        }  
                       stack.push(temp);//  
                    }  
                      
  
                } else {// 操作符为:"*"或"/" 直接入栈  
                    stack.push(temp);// */的优先级比任何运算符都高，所以直接入栈
  
                }  
            } else if (isLeft(temp)) {//如果是左括号直接入栈  
                stack.push(temp);  
  
            } else if (isRight(temp)) {// 如果是右括号，则找到左括号，并将找的过程中的字符全部出栈  
                String top = stack.pop();  
                boolean next = true;  
                while (!isLeft(top) && next) {  
                    sb.append(top);  
                    top = stack.pop();  
                    next = stack.size() == 0 ? false : true;  
                }  
            }  
        }  
        while (stack.size() > 0) {  
            sb.append(stack.pop());  
        }  
        return sb.toString();  
    }  
  
    public static void main(String[] args) {
        nibolanshi nibolanshi = new nibolanshi();
        String src = nibolanshi.reverse2Rpn("((1+2*3-5/2)*2)*4)+9*(1+2)");
        System.out.println("后缀表达式为:"+src);  
        System.out.println("计算结果:"+ nibolanshi.countRpn(src));
    }  
  
}  