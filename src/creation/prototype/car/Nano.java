package creation.prototype.car;

 

import creation.prototype.car.BasicCar; 

public class Nano extends BasicCar {
	public Nano(String m) {
		modelname = m;
	}

	@Override
	public BasicCar clone() throws CloneNotSupportedException {
		return (Nano) super.clone();
	}
}