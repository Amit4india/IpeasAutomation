package com.ipeas.data;

import java.util.ArrayList;
import java.util.List;

public class AlertFipsCode {

	public static List<String> listOfFipsCodes; 
	
	static {

		AddFipsCodes();
	}

	

	private static void AddFipsCodes() {
		 listOfFipsCodes = new ArrayList<>();
		// TODO Auto-generated method stub
		listOfFipsCodes.add("Anderson,KS (020003)");
		listOfFipsCodes.add("Atchison,KS (020005)");
		listOfFipsCodes.add("Barber,KS (020007)");
		listOfFipsCodes.add("Barton,KS (020009)");
	}
	
	 public static List<String> getFipsCodes()
	 {
		 return listOfFipsCodes;
	 }

}
