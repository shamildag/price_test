package com.shama;

import com.shama.model.Price;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

final class TestValuesFromCustomer {
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
	public static List<Price> existingPrices, newPrices, resultList;

	public static Date convertFromString2Date(String strDate) {
		return Date.from(LocalDateTime.parse(strDate, dtf).atZone(ZoneId.systemDefault()).toInstant());
	}

	static {
		existingPrices = Arrays.asList(
				new Price("122856", 1, 1, convertFromString2Date("01.01.2013 00:00:00"),
						convertFromString2Date("31.01.2013 23:59:59"), 11000),
				new Price("122856", 2, 1, convertFromString2Date("10.01.2013 00:00:00"),
						convertFromString2Date("20.01.2013 23:59:59"), 99000),
				new Price("6654", 1, 2, convertFromString2Date("01.01.2013 00:00:00"),
						convertFromString2Date("31.01.2013 00:00:00"), 5000)
		);
		newPrices = Arrays.asList(
				new Price("122856", 1, 1, convertFromString2Date("20.01.2013 00:00:00")
						, convertFromString2Date("20.02.2013 23:59:59"), 11000),
				new Price("122856", 2, 1, convertFromString2Date("15.01.2013 00:00:00"),
						convertFromString2Date("25.01.2013 23:59:59"), 92000),
				new Price("6654", 1, 2, convertFromString2Date("12.01.2013 00:00:00"),
						convertFromString2Date("13.01.2013 00:00:00"), 4000)
		);
		resultList = Arrays.asList(
				new Price("122856", 1, 1, convertFromString2Date("01.01.2013 00:00:00"),
						convertFromString2Date("20.02.2013 23:59:59"), 11000),
				new Price("122856", 2, 1, convertFromString2Date("10.01.2013 00:00:00"),
						convertFromString2Date("15.01.2013 00:00:00"), 99000),
				new Price("122856", 2, 1, convertFromString2Date("15.01.2013 00:00:00"),
						convertFromString2Date("25.01.2013 23:59:59"), 92000),
				new Price("6654", 1, 2, convertFromString2Date("01.01.2013 00:00:00"),
						convertFromString2Date("12.01.2013 00:00:00"), 5000),
				new Price("6654", 1, 2, convertFromString2Date("12.01.2013 00:00:00"),
						convertFromString2Date("13.01.2013 00:00:00"), 4000),
				new Price("6654", 1, 2, convertFromString2Date("13.01.2013 00:00:00"),
						convertFromString2Date("31.01.2013 00:00:00"), 5000)
		);
	}
}



