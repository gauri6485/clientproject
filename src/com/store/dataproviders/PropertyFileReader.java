package com.store.dataproviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	// read the data from property file and send the email and pwd
	// create its object where ever required.
	private Properties properties;
	private final String propertyFilePath = "configs//Config.properties";

	public PropertyFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		System.out.println(driverPath);

		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getEmail() {
		String email = properties.getProperty("email");
		if (email != null)
			return email;
		else
			throw new RuntimeException("email not specified in the Configuration.properties file.");
	}

	public String getPwd() {
		String pwd = properties.getProperty("pwd");
		if (pwd != null)
			return pwd;
		else
			throw new RuntimeException("pwd not specified in the Configuration.properties file.");
	}
	
	
	public String getFirstNameLabel() {
		String FN = properties.getProperty("FN");
		if (FN != null)
			return FN;
		else
			throw new RuntimeException("FN not specified in the Configuration.properties file.");
	}
	
	
	public String getLastNameLabel() {
		String LN = properties.getProperty("LN");
		if (LN != null)
			return LN;
		else
			throw new RuntimeException("LN not specified in the Configuration.properties file.");
	}
	
	public String getAddressLabel() {
		String adr = properties.getProperty("adr");
		if (adr != null)
			return adr;
		else
			throw new RuntimeException("adrress not specified in the Configuration.properties file.");
	}
	
	public String getCityLabel() {
		String city = properties.getProperty("city");
		if (city != null)
			return city;
		else
			throw new RuntimeException("city not specified in the Configuration.properties file.");
	}
	
	
	
	public String getZipLabel() {
		String zip = properties.getProperty("zip");
		if (zip != null)
			return zip;
		else
			throw new RuntimeException("zip not specified in the Configuration.properties file.");
	}
	
	public String getEmailLabel() {
		String email = properties.getProperty("email");
		if (email != null)
			return email;
		else
			throw new RuntimeException("email not specified in the Configuration.properties file.");

	}
	
	
	public String getPhoneLabel() {
		String phone = properties.getProperty("phone");
		if (phone != null)
			return phone;
		else
			throw new RuntimeException("phone not specified in the Configuration.properties file.");
	}
}
