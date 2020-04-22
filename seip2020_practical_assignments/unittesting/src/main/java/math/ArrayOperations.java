package math;

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

/**
* The ArrayOperations provides simple array operations
* that serve as hands-on practice on Unit Testing.
*
* @author  dafnith
* @version 1.0
* @since   2020-04-20 
*/
public class ArrayOperations {

	/**
	 * Reads a file and returns the prime numbers in an int[] array
	 * @param fileIo the class that reads the file and returns an int[] with its integer contents
	 * @param filepath the file that contains text in lines
	 * @param myMath the class that contains method isPrime()
	 * @return an array with the prime numbers in file
	 */
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		
		//MyMath mm = new MyMath();
		int[] numbers = fileIo.readFile(filepath);
		List<Integer> primeNumbers = new ArrayList<>();
		
		for (int number : numbers) {
			if (myMath.isPrime(number))
				primeNumbers.add(number);
		}
		
		return primeNumbers.stream().mapToInt(i->i).toArray();
	}
}
