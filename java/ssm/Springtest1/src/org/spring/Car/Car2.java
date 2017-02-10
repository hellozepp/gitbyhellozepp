package org.spring.Car;

/**
 * Created by hadoop on 16-9-9.
 */
public class Car2 implements Car {
    private String name;
    private double price;

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Car1{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
