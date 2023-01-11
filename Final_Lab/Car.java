
public class Car extends Vehicle {
	private int numberOfPassenegers;

	public Car(String numberPlate, double price, int numberOfPassenegers) {
		super(numberPlate, price);
		this.numberOfPassenegers = numberOfPassenegers;
	}

	public int getNumberOfPassenegers() {
		return numberOfPassenegers;
	}

	@Override
	public double calculateFare(double distance) {
		return 20 + (numberOfPassenegers * 5.0) + (distance * 10.0);
	}

}
