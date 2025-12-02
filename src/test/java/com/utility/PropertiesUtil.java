package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String readProperty(Env env, String key) throws IOException {

		System.out.println(System.getProperty("user.dir"));
		File propFile = new File(System.getProperty("user.dir") + "\\config" + env + ".properties");
		FileReader fr = null;
		Properties prop = new Properties();
		try {
			fr = new FileReader(propFile);
			prop.load(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		return prop.getProperty(key);
	}
}
