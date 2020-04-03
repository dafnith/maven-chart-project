package gradeshistogram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/***
 * The purpose of this class is to generate and demonstrate
 * a frequency histogram given a file of grades.
 * the x axis represents the grades and the y axis represents
 * the frequency of each grade.
 *         
 * @author dafnith
 * @since March 2020 
 */

public class HistogramGenerator {

	public static void main(String[] args) {
		String path = args[0];
		HistogramGenerator obj = new HistogramGenerator();
		int grades[] = obj.readGrades(path);
		obj.generateChart(grades);
	}

	/***
	 * Receives a string variable with the given path of the file. Reads a file from
	 * a local directory and stores them in an array.
	 * 
	 * @param path
	 *            string variable with the given path of the file
	 * @return the array of integers.
	 */
	public int[] readGrades(String path) {
		StringBuilder sb = new StringBuilder();
		String strLine = "";
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while (strLine != null) {
				strLine = br.readLine();
				sb.append(strLine);
				sb.append(System.lineSeparator());
				if (strLine == null)
					break;
				list.add(strLine);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			System.err.println("Unable to read the file.");
		}

		/*
		 * Converts string array to integer array
		 */
		int size = list.size();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(list.get(i));
		}

		return arr;
	}
	
	

	/***
	 * Receives a single dimension Integer array. From this array the dataset that
	 * will be used for the visualization is generated. Finally, The chart is
	 * generated with the use of the aforementioned dataset and then presented in
	 * the screen.
	 *
	 * @param dataValues
	 *            Single dimension integer array
	 */
	public void generateChart(int[] dataValues) {

		// Creating a HashMap object with elements of dataValues as keys and their count as values
		
		HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();
		
		for (int i : dataValues) {
			if (elementCountMap.containsKey(i)) {
				
				// If element is present in elementCountMap, incrementing it's count by 1
				
				elementCountMap.put(i, elementCountMap.get(i) + 1);
			} else {
				
				// If element is not present in elementCountMap,
				// adding this element to elementCountMap with 1 as it's value
				
				elementCountMap.put(i, 1);
			}
		}


		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < elementCountMap.size(); i++) {
			dataValues[i] = (dataValues[i]);
			dataset.setValue(elementCountMap.get(i), "Grade", Integer.toString(i));
		}

		JFreeChart chart = ChartFactory.createBarChart("Frequency of Grades", "", "Times", dataset,
				PlotOrientation.VERTICAL, false, false, false);

		// Declare and initialize a Chart
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		frame.setVisible(true);

	}
}
