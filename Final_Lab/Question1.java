import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner in = new Scanner(System.in);
		String fileName = "vehicle.txt";
		String plateNo;
		double price, weightCarriedInKG;
		int noOfPassanger;

		Vehicle[] a = new Vehicle[5];
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter Car plate no:");
			plateNo = in.next();
			System.out.println("Enter Car price:");
			price = in.nextDouble();
			System.out.println("Enter Number Of Passenegers in Car:");
			noOfPassanger = in.nextInt();
			a[i] = new Car(plateNo, price, noOfPassanger);
			a[i].appendToFile(fileName);
		}
		for (int i = 3; i < 5; i++) {
			System.out.println("Enter Truck plate no:");
			plateNo = in.next();
			System.out.println("Enter Truck price:");
			price = in.nextDouble();
			System.out.println("Enter Weight Carried in kG:");
			weightCarriedInKG = in.nextDouble();
			a[i] = new Truck(plateNo, price, weightCarriedInKG);
			a[i].appendToFile(fileName);
		}

		Vehicle temp = new Car("-1", 0, 0);
		double highestPrice = 0;
		int index = -1, totalVehicle = temp.numberOfLinesInFile(fileName);

		Vehicle[] array = new Vehicle[totalVehicle];
		array = temp.getAllVeciclesFromFile(fileName);

		for (int i = 0; i < totalVehicle - 1; i++) {
			if (array[i].compareTo(array[i + 1]) == 1) {
				if (highestPrice < array[i].getPrice()) {
					highestPrice = array[i].getPrice();
					index = i;
				}
			} else {
				if (highestPrice < array[i + 1].getPrice()) {
					highestPrice = array[i + 1].getPrice();
					index = i + 1;
				}
			}
		}

		System.out.println("Highest Price Vehicle is:");
		if (array[index] instanceof Car) {
			System.out.println("Vehicle no-" + (index + 1) + "(Car)");
		} else {
			System.out.println("Vehicle no-" + (index + 1) + "(Truck)");
		}
		System.out.println("Plate no = " + array[index].getNumberPlate());
		System.out.println("Price = " + array[index].getPrice());
		in.close();
	}
}
