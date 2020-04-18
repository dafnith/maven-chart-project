package math;

import org.junit.Test;

public class MyMathTest {
	
	MyMath mm = new MyMath();
	
	@Test (expected = IllegalArgumentException.class)
	public void testFactorialException() {
		mm.factorial(-1);
		mm.factorial(13);
	}
}
