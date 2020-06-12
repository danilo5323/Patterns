package creation.prototype.car;

import java.util.HashMap;

public class CarTool {

	public static String FORD = "Ford", NANO = "Nano";
	public static HashMap<String, BasicCar> carsInstancied;
	
	public static void startCarTool() {
		carsInstancied = new HashMap<String, BasicCar>();
		System.out.println("***Prototype Pattern Demo***\n");
		BasicCar nano_base = new Nano("Green Nano");
		nano_base.price = 100000;
		BasicCar ford_basic = new Ford("Ford Yellow");
		ford_basic.price = 500000;
		
		carsInstancied.put(FORD, ford_basic);
		carsInstancied.put(NANO, nano_base);
	}

	public static BasicCar getCar(String key) {
		BasicCar returnCar = null;
		try {
			returnCar = (BasicCar)carsInstancied.get(key).clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return returnCar;
	}
}
