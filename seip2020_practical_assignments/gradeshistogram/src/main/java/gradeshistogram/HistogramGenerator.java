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
		HistogramGenerator obj = new HistogramGenerator();
		int grades[] = obj.readGrades();
		obj.generateChart(grades);

	}

	public int[] readGrades() {
		StringBuilder sb = new StringBuilder();
		String strLine = "";
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/dafni/Desktop/grades.txt"));
			while (strLine != null) {
				strLine = br.readLine();
				sb.append(strLine);
				sb.append(System.lineSeparator());
				if (strLine == null)
					break;
				list.add(strLine);
			}
			System.out.println(Arrays.toString(list.toArray()));
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			System.err.println("Unable to read the file.");
		}

		/*
		 * Converts a string array to an integer array
		 */
		int size = list.size();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(list.get(i));
		}
		System.out.println(Arrays.toString(arr));
		
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
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that can be
		 * visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many series in
		 * one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the previously
		 * created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

}
