package math;

import org.junit.Test;

import io.FileIO;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.*;


public class ArrayOperationsTest {
	
	@Test
	public void testFindPrimesInFile() {
		FileIO fileio = mock(FileIO.class);
		MyMath mm = new MyMath();
		//MyMath mm = new MyMath();
		
		String path = "src/test/resources/mixed.txt";
		when(fileio.readFile(path)).thenReturn(new int[] {2,6,3,6,5,29});
		
		ArrayOperations arrop = new ArrayOperations();
		int[] expected = {2,3,5,29};
		int[] actual = arrop.findPrimesInFile(fileio, path, mm);
		
		assertArrayEquals(expected, actual);
	}
}
