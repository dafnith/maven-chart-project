package math;

import math.ArithmeticOperations;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {
	ArithmeticOperations ao = new ArithmeticOperations();
	
	@Test
	public void testDivide() {
		Assert.assertEquals(2, ao.divide(4, 2), 0);
		Assert.assertEquals(-1.826, ao.divide(3.14, -1.72), 0.001);
		Assert.assertEquals(1, ao.divide(1.0/3, 1.0/3), 0);
		Assert.assertEquals(0, ao.divide(0, 3), 0);
	}
	
	@Test (expected = ArithmeticException.class)
	public void testDivideException() {
		ao.divide(4,0);
	}
	
	
	
	@Test
	public void testMultiplyWhenProductFitsInVariable( ) {
		Assert.assertEquals(2, ao.multiply(1, 2), 0);
	}
	
	/*
	 * A test case for the exceptions caused when
	 * one or more input values are negative. Testing
	 * the exception is performed with a @Rule
	 */
	@Rule 
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	@Test 
	public void testMultiplyShouldThrowExceptionOnNegativeInput() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(-5, 1);
	}
	
	/*
	 * A test case for the exceptions caused when
	 * the result of the multiplication doesn't fit 
	 * in an Integer variable.
	 */
	@Test 
	public void testMultiplyShouldThrowExceptionOverflow() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(Integer.MAX_VALUE, 2);
	}
}
