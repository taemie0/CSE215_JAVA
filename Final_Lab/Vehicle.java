
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class Vehicle implements Comparable, SaveableToFile {
	private String numberPlate;
	private double price;

	public Vehicle(String numberPlate, double price) {
		this.numberPlate = numberPlate;
		this.price = price;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public double getPrice() {
		return price;
	}

	public abstract double calculateFare(double distance);

	@Override
	public String toString() {
		return "Vehicle [numberPlate=" + numberPlate + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Object o) {
		if (((Vehicle) o).getPrice() > this.getPrice())
			return -1;
		if (((Vehicle) o).getPrice() < this.getPrice())
			return 1;
		else
			return 0;
	}

	@Override
	public void appendToFile(String fileName) {

		File file = new File(fileName);
		FileWriter fr;
		try {
			fr = new FileWriter(file, true);
			if (this instanceof Car) {
				fr.write(numberPlate + " " + price + " " + ((Car) this).getNumberOfPassenegers() + "\n");
			} else if (this instanceof Truck) {
				fr.write(numberPlate + " " + price + " " + ((Truck) this).getWeightCarriedInKG() + "\n");
			} else {
				fr.write(numberPlate + " " + price + "\n");
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int numberOfLinesInFile(String fileName) {
		int numberOfLines = 0;
		File file = new File(fileName);
		try {
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				in.nextLine();
				numberOfLines++;
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return numberOfLines;
	}

	@Override
	public Vehicle[] getAllVeciclesFromFile(String fileName) {
		File file = new File(fileName);
		String line;
		double weightCarriedInKG, price;
		int noOfPassanger, i = 0;
		Vehicle[] array = new Vehicle[numberOfLinesInFile(fileName)];
		try {
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				line = in.nextLine();
				String[] temp = line.split(" ");
				try {
					weightCarriedInKG = Double.parseDouble(temp[2]);
					price = Double.parseDouble(temp[1]);
					array[i] = (new Truck(temp[0], price, weightCarriedInKG));

				} catch (Exception e) {
					noOfPassanger = Integer.parseInt(temp[2]);
					price = Double.parseDouble(temp[1]);
					array[i] = (new Car(temp[0], price, noOfPassanger));
				}
				i++;
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return array;

	}

}
