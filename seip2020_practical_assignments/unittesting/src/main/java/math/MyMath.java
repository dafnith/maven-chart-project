package math;


/**
* The MyMath class provides some advanced arithmetic operations
* that serve as hands-on practice on Unit Testing.
*
* @author  dafnith
* @version 1.0
* @since   2020-04-16 
*/
public class MyMath {

	
	/**
	 * Calculates the factorial of a given number
	 * @param n the given input
	 * @return the result of the factorial
	 * @exception IllegalArgumentException for n<0 and n>=12
	 */
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
	
	
	/**
	 *Checks whether a number is prime or not
	 * @param n the given input
	 * @return true for prime number false for not prime
	 * @exception IllegalArgumentException for n<2
	 */
	public boolean isPrime(int n) {
		
		boolean flag = false;

		if (n < 2) {
			throw new IllegalArgumentException("number must be >=2");
		} else {
			for (int i = 2; i <= n / 2; ++i) {
				// condition for nonprime number
				if (n % i == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return true;
			} else {
				return false;
			}
		}
	}
}
