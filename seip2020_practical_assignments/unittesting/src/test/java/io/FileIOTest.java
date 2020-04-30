package io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FileIOTest {

	FileIO fileio = new FileIO();
	public static String resourcesPath = "src/test/resources/";
	
	@Test
	public void testReadFileValidInput() {
		int[] expectedIntegers = new int[] {
				3, 4, 5, 7, 0, 9, 6, 2, 0, 0};
		String filepath = resourcesPath.concat("grades.txt");
		
		Assert.assertArrayEquals(expectedIntegers, fileio.readFile(filepath));
	}
	

	@Rule 
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	
	/*
	 * A test case for the exceptions caused when
	 * the given file does not exist. Testing
	 * the exception is performed with a @Rule
	 */	
	@Test 
	public void testReadFileShouldThrowExceptionWhenFileDoesNotExist() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		String filepath = resourcesPath.concat("foo.txt");
		fileio.readFile(filepath);
	}
	
	/*
	 * A test case for the exceptions caused when
	 * the given file is empty. Testing
	 * the exception is performed with a @Rule
	 */
	@Test 
	public void testReadFileShouldThrowExceptionWhenFileIsEmpty() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		String filepath = resourcesPath.concat("empty.txt");
		fileio.readFile(filepath);
	}
	
	@Test
	public void testReadFileContainsInvalidEntries(){
		int[] expectedIntegers = new int[] {
				2, 6, 3, 6, 5};
		String filepath = resourcesPath.concat("mixed.txt");
		
		Assert.assertArrayEquals(expectedIntegers, fileio.readFile(filepath));
	}
}
