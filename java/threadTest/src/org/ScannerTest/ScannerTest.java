package org.ScannerTest;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by hadoop on 16-9-19.
 */
public class ScannerTest {
    public static void main(String[] args) throws FileNotFoundException {
    Scanner s = new Scanner("123 asdf sd 45 789 sdf asdfl,sdf.sdfl,asdf    ......asdfkl    las");
                s.useDelimiter(" |,|\\.");//默认空格
    while (s.hasNext()) {
        System.out.println(s.next());
    }
}
}

/**
 * 将注释行去掉，使用空格或逗号或点号作为分隔符，输出结果如下：
 123
 asdf
 sd
 45
 789
 sdf
 asdfl
 sdf
 sdfl
 asdf







 asdfkl

 las

 Process finished with exit code 0
 */
