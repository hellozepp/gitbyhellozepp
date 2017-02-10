package zengqiang;

import org.spring.Car.Car1;

/**装饰  decorate
 * Created by hadoop on 16-9-9.
 */
public class Demo2 {
    public static void main(String[] args) {
        CarDecorate caraa =new CarDecorate(new bmw());
        caraa.run();
    }
}
interface Caraa{
    void run();
}
class bmw implements Caraa{

    @Override
    public void run() {
        System.out.println("bmw run");
    }
}
class benz implements Caraa{

    @Override
    public void run() {
        System.out.println("bmw benz");
    }
}
class CarDecorate implements Caraa{
    private Caraa caraa;
    public CarDecorate(Caraa caraa) {
        this.caraa = caraa;
    }

    @Override
    public void run() {
        System.out.println("zengqiang");
        caraa.run();
    }
}
