import java.util.Scanner;

public class Matrix {
	private int row, column;
	private double[][] array;
	private Scanner input = new Scanner(System.in);
	public Matrix() {

	}

	public Matrix(int r, int c) {
		this.row = r;
		this.column = c;
		this.array = new double[r][c];
	}

	public void get_input() {
		System.out.println("Enter the " + row + "x" + column + " matrix:");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				array[i][j] = input.nextDouble();
			}
		}
	}

	public Matrix add(Matrix m1) throws Exception {
		if (m1.row != this.row || m1.column != this.column) {
			throw new Exception("Addition not possible.");
		}
		Matrix result = new Matrix(row, column);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				result.array[i][j] = this.array[i][j] + m1.array[i][j];
			}
		}
		return result;

	}

	public Matrix sub(Matrix m1) throws Exception {
		if (m1.row != this.row || m1.column != this.column) {
			throw new Exception("Substraction not possible.");
		}
		Matrix result = new Matrix(row, column);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				result.array[i][j] = this.array[i][j] - m1.array[i][j];
			}
		}
		return result;

	}

	public void print_matrix() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}

	}

}
