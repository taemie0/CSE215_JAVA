
public class Question1 {
	public static boolean isArmstrong(int n) {
		int sum = 0, temp = n, r;
		while (temp > 0) {
			r = temp % 10;
			sum += Math.pow(r, 3);
			temp /= 10;
		}
		return sum == n;
	}

	public static void main(String[] args) {
		System.out.println("Armstrong numbers between 1 and 999 are:");
		for (int i = 1; i <= 999; i++) {
			if (isArmstrong(i))
				System.out.print(i + " ");
		}

	}

}
