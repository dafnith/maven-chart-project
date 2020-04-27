package math;

import org.junit.Test;

import io.FileIO;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.*;


public class ArrayOperationsTest {
	
	@Test
	public void testFindPrimesInFile() {
		FileIO fileio = mock(FileIO.class);
		MyMath mm = mock(MyMath.class);
		

		
		String path = "src/test/resources/mixed.txt";
		when(fileio.readFile(path)).thenReturn(new int[] {2,6,3,6,5,29});

		when(mm.isPrime(2)).thenReturn(true);
		when(mm.isPrime(6)).thenReturn(false);
		when(mm.isPrime(3)).thenReturn(true);
		when(mm.isPrime(5)).thenReturn(true);
		when(mm.isPrime(29)).thenReturn(true);
		
		ArrayOperations arrop = new ArrayOperations();
		int[] expected = {2,3,5,29};
		int[] actual = arrop.findPrimesInFile(fileio, path, mm);
		
		assertArrayEquals(expected, actual);
	}
}
