package org.spring.Car;

/**
 * Created by hadoop on 16-9-9.
 */
public class PersonInfo {
    private String name;
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "PersonInfo{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
