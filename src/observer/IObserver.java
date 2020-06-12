package observer;

import java.util.*;

interface IObserver {
	void update(String s, int i);
}

class Observer1 implements IObserver {
	@Override
	public void update(String s, int i) {
		System.out.println("Observer1: myValue in " + s + " is now: " + i);
	}
}

class Observer2 implements IObserver {
	@Override
	public void update(String s, int i) {
		System.out.println("Observer2: observes ->myValue is changed in " + s + " to :" + i);
	}
}

class Observer3 implements IObserver {
	@Override
	public void update(String s, int i) {
		System.out.println("Observer3 is observing:myValue is changed in " + s + " to :" + i);
	}
}

interface ISubject {
	void register(IObserver o);

	void unregister(IObserver o);

	void notifyObservers(int i);
}

class Subject1 implements ISubject {
	private int myValue;

	public int getMyValue() {
		return myValue;
	}

	public void setMyValue(int myValue) {
		this.myValue = myValue;
//Notify observers
		notifyObservers(myValue);
	}

	List<IObserver> observersList = new ArrayList<IObserver>();

	@Override
	public void register(IObserver o) {
		observersList.add(o);
	}

	@Override
	public void unregister(IObserver o) {
		observersList.remove(o);
	}

	@Override
	public void notifyObservers(int updatedValue) {
		for (int i = 0; i < observersList.size(); i++) {
			observersList.get(i).update(this.getClass().getSimpleName(), updatedValue);
		}
	}
}

class Subject2 implements ISubject {
	private int myValue;

	public int getMyValue() {
		return myValue;
	}

	public void setMyValue(int myValue) {
		this.myValue = myValue;
//Notify observers
		notifyObservers(myValue);
	}

	List<IObserver> observersList = new ArrayList<IObserver>();

	@Override
	public void register(IObserver o) {
		observersList.add(o);
	}

	@Override
	public void unregister(IObserver o) {
		observersList.remove(o);
	}

	@Override
	public void notifyObservers(int updatedValue) {
		for (int i = 0; i < observersList.size(); i++) {
			observersList.get(i).update(this.getClass().getSimpleName(), updatedValue);
		}
	}
}

