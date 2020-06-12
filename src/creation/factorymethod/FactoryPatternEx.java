package creation.factorymethod;

public class FactoryPatternEx {
	public static void main(String[] args) throws Exception {
		System.out.println("***Factory Pattern Demo***\n");
		IAnimalFactory animalFactory = new ConcreteFactory();
		IAnimal DuckType = animalFactory.GetAnimalType(IAnimalFactory.AnimalType.DUCK);
		DuckType.Speak();
		IAnimal TigerType = animalFactory.GetAnimalType(IAnimalFactory.AnimalType.TIGER);
		TigerType.Speak();
//There is no Lion type. So, an exception will be thrown
		IAnimal LionType = animalFactory.GetAnimalType(IAnimalFactory.AnimalType.LION);
		LionType.Speak();
	}
}

interface IAnimal {
	void Speak();
}

class Duck implements IAnimal {
	@Override
	public void Speak() {
		System.out.println("Duck says Pack-pack");
	}
}

class Tiger implements IAnimal {
	@Override
	public void Speak() {
		System.out.println("Tiger says: Halum..Halum");
	}
}

abstract class IAnimalFactory {
	public abstract IAnimal
			/* if we cannot instantiate in later stage, we'll throw exception */
			GetAnimalType(AnimalType type) throws Exception;
	
	public  enum AnimalType{
		TIGER,
		DUCK,
		LION;
	}
}

class ConcreteFactory extends IAnimalFactory {
	@Override
	public IAnimal GetAnimalType(IAnimalFactory.AnimalType type) throws Exception {
		switch (type) {
		case DUCK:
			return new Duck();
		case TIGER:
			return new Tiger();
		default:
			throw new Exception("Animal type : " + type + " cannot be instantiated");
		}
	}
}
