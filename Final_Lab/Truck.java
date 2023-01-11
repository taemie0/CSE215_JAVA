
public class Truck extends Vehicle {
	private double weightCarriedInKG;

	public Truck(String numberPlate, double price, double weightCarriedInKG) {
		super(numberPlate, price);
		this.weightCarriedInKG = weightCarriedInKG;
	}

	public double getWeightCarriedInKG() {
		return weightCarriedInKG;
	}

	@Override
	public double calculateFare(double distance) {
		return 300 + (weightCarriedInKG * 2.0) + (distance * 0.5);
	}

}
