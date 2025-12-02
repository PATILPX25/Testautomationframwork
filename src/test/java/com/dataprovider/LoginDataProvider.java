package com.dataprovider;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.utility.CsvReader;
import com.utility.User;

public class LoginDataProvider {

	@DataProvider(name = "LoginCSVData")
	public Iterator<User> csvDataReader() 
	{
		return CsvReader.readCsvFile("loginData.csv");
	}

}
