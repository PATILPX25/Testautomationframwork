package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvReader {

	public static Iterator<User> readCsvFile(String filename) {
		File scr = new File(System.getProperty("user.dir") + "//testdata//"+ filename);
		FileReader fr = null;
		CSVReader cr;
		String[] data;
		List<User> newData = null;
		try {
			fr = new FileReader(scr);
			cr = new CSVReader(fr);
			cr.readNext();
			User user;
			newData = new ArrayList<User>();
			while ((data = cr.readNext()) != null) {
				user = new User(data[0], data[1]);
				newData.add(user);
			}
			
		} catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newData.iterator();
	}

}
