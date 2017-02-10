package cn.itcast.zq;

//使用装饰进行增强
public class Demo2 {
	public static void main(String[] args) {

		Car car=new Bmw();
		
		//给车增强
		CarDerector cd=new CarDerector(car);
		
		cd.run();
		
	}
}

interface Car {
	void run();
}

class Bmw implements Car {
	public void run() {
		System.out.println("bmw run....");
	}
}

class Benz implements Car {
	public void run() {
		System.out.println("benz run....");
	}
}

// 使用装饰来完成
class CarDerector implements Car {

	private Car car;

	public CarDerector(Car car) {
		this.car = car;
	}

	public void run() {
		System.out.println("添加导航");
		car.run();
		
	}
}