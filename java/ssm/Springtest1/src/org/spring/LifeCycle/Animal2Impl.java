package org.spring.LifeCycle;

/**
 * Created by hadoop on 16-9-8.
 */
public class Animal2Impl implements Animal2 {
    private String name1;
    public String getName1() {
        return name1;
    }
    public void setName1(String name1) {
        System.out.println("第二步:属性的注入."+name1);
        this.name1 = name1;
    }
    public Animal2Impl() {
        System.out.println("第一步:实例化类. ");
    }

    @Override
    public void eat(String name1) {
        System.out.println(name1+
                "====   eat");
    }
}
