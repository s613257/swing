package swing.project1.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class IOTesting {

	public static void reader() {

		try {
			CSVReader rd = new CSVReader(new FileReader("File.csv"));
			String[] nextLine = {};
			while ((nextLine = rd.readNext()) != null) {
				System.out.println(nextLine[0] + nextLine[1] + "\n");
			}
		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}

	}

	public static void writer() {
		CSVWriter writer;
		try {
			writer = new CSVWriter(new FileWriter("File.csv"));
			String[] entries1 = "data1,data2,data3".split(",");
			String[] entries2 = { "data1", "data2", "data3" };
			writer.writeNext(entries1);
			writer.writeNext(entries2);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
