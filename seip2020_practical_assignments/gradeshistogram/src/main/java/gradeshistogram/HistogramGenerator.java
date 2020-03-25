package gradeshistogram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class HistogramGenerator {

	public static void main(String[] args) {
		String path = args[0];
		HistogramGenerator obj = new HistogramGenerator();
		int grades[] = obj.readGrades(path);
		obj.generateChart(grades);
	}
	
	
	
	/***
	 * Receives a string variable with the given path of the file.
	 * Reads a file from a local directory and stores them in an array.
	 * @param path
	 * 		string variable with the given path of the file
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
		//System.out.println(Arrays.toString(arr));
		
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
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries data = new XYSeries("random values");
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("GRADES CHART", "line", "grade", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		frame.setVisible(true);
	}

}
