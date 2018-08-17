package com.store.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneralMethods {
	public String getCurrentDateTime() {

		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy-HHmmss");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String currentDateTime = dateFormat.format(date);

		return currentDateTime;
	}

	public void sync() throws Exception{
		Thread.sleep(2000);
	}
}