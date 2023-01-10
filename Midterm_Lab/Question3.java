
import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] a = new int[5][5];
		int div = 0;
		System.out.println("Enter Values of the 5x5 array:");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				a[i][j] = input.nextInt();
				if (a[i][j] % 7 == 0 && a[i][j] % 2 != 0)
					div++;
			}
		}
		System.out.println("Number of values divisible by 7 & odd=" + div);
		int[][] temp = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp[j][i] = a[i][j];
			}
		}
		System.out.println("Interchanged array:");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
		input.close();
	}

}
