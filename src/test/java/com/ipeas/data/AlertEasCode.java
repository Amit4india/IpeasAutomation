package com.ipeas.data;

import java.util.ArrayList;
import java.util.List;

public class AlertEasCode {

	public static List<String> listOfEasCodes; 
	
	static {

		AddEasCodes();
	}

	

	private static void AddEasCodes() {
		 listOfEasCodes = new ArrayList<>();
		// TODO Auto-generated method stub
		/*listOfEasCodes.add("NIC : NATIONAL INFORMATION CENTER");
		listOfEasCodes.add("NPT : NATIONAL PERIODIC TEST");*/
		listOfEasCodes.add("DMO : PRACTICE/DEMO WARNING");
		listOfEasCodes.add("RMT : REQUIRED MONTHLY TEST");
		listOfEasCodes.add("RWT : REQUIRED WEEKLY TEST");
		listOfEasCodes.add("ADR : ADMINISTRATIVE MESSAGE");
		listOfEasCodes.add("AVW : AVALANCHE WARNING");
		listOfEasCodes.add("AVA : AVALANCE WATCH");
		listOfEasCodes.add("BZW : BLIZZARD WARNING");
		listOfEasCodes.add("CEM : CIVIL EMERGENCY MESSAGE");
		listOfEasCodes.add("CAE : CHILD ABDUCTION EMERGENCY");
		listOfEasCodes.add("CFW : COASTAL FLOOD WARNING");
		listOfEasCodes.add("CFA : COASTAL FLOOD WATCH");
		listOfEasCodes.add("DSW : DUST STORM WARNING");
		listOfEasCodes.add("EQW : EARTHQUAKE WARNING");
		listOfEasCodes.add("FRW : FIRE WARNING");
		listOfEasCodes.add("FFA : FLASH FLOOD WATCH");
		listOfEasCodes.add("FFW : FLASH FLOOD WARNING");
		listOfEasCodes.add("FFS : FLASH FLOOD STATEMENT");
		listOfEasCodes.add("FLA : FLOOD WATCH");
	}
	
	 public static List<String> getEasCodes()
	 {
		 return listOfEasCodes;
	 }

}
