package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyMathTest {
	
	MyMath mm = new MyMath();
	
	@Test (expected = IllegalArgumentException.class)
	public void testFactorialException() {
		mm.factorial(-1);
		mm.factorial(13);
	}
	
	@Test
	public void testIsPrime() {
		Assert.assertEquals(true, mm.isPrime(2));
		Assert.assertEquals(true, mm.isPrime(3));
		Assert.assertEquals(false, mm.isPrime(6));
		Assert.assertEquals(true, mm.isPrime(97));
	}
	
	
	/*
	 * A test case for the exception caused when
	 * the input value is < 2. Testing
	 * the exception is performed with a @Rule
	 */
	@Rule 
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	@Test 
	public void testIsPrimeShouldThrowExceptionOnLowerThanTwoInput() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("number must be >=2");
		mm.isPrime(1);
	}
}
