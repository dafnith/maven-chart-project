package math;

public class MyMath {

	public int factorial(int n) {

		// The case where the result doesn't fit in an Integer variable
		if (n < 0 || n > 12) {
			throw new IllegalArgumentException("number must be positive and <=12");
		}

		int i;
		int factorial = 1;
		for (i = 1; i <= n; i++) {
			factorial = factorial * i;
		}
		return factorial;

	}
}
