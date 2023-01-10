
public class Question2 {

	public static void main(String[] args) {
		Matrix m1, m2, sub, add;
		m1 = new Matrix(3, 3);
		m1.get_input();
		m2 = new Matrix(3, 3);
		m2.get_input();
		System.out.println("Resultant Matrix after Subtraction:");
		try {
			sub = m1.sub(m2);
			sub.print_matrix();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Resultant Matrix after addition:");
		try {
			add = m1.add(m2);
			add.print_matrix();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
