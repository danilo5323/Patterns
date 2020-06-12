package creation.prototype;

import creation.prototype.car.*;

public class PrototypePatternEx {
	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("***Prototype Pattern Demo***\n");
		CarTool.startCarTool();
		BasicCar ford_basic= CarTool.getCar(CarTool.FORD);
		BasicCar nano_base  = CarTool.getCar(CarTool.NANO);     
		
		System.out.println("Car is: " + ford_basic.modelname + " and it's price is Rs." + ford_basic.price);
		System.out.println("Car is: " + nano_base.modelname + " and it's price is Rs." + nano_base.price);
	}
}
