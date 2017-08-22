package com.ipeas.util;

import static com.ipeas.config.GlueServerConfig.alertInfoFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ipeas.config.GlueServerConfig;
import com.ipeas.data.Alert;
import com.ipeas.data.ServerDetails;

public class Util {

	public static WebDriverWait waitForTenSecond() {
		WebDriverWait timeOut = new WebDriverWait(LaunchBrowser.getDriver(), 10);
		return timeOut;
	}

	public static WebDriverWait waitFor20Second() {
		WebDriverWait timeOut = new WebDriverWait(LaunchBrowser.getDriver(), 20);
		return timeOut;
	}

	public static WebDriverWait waitFor30Second() {
		WebDriverWait timeOut = new WebDriverWait(LaunchBrowser.getDriver(), 30);
		return timeOut;
	}

	public static WebDriverWait waitFor50Second() {
		WebDriverWait timeOut = new WebDriverWait(LaunchBrowser.getDriver(), 30);
		return timeOut;
	}

	public static WebDriverWait waitFor100Second() {
		WebDriverWait timeOut = new WebDriverWait(LaunchBrowser.getDriver(), 100);
		return timeOut;
	}

	public static int getRandomNumber(int maxSize) {
		Random rand = new Random();
		int index = rand.nextInt(maxSize);
		return index;
	}

	public static Alert getAlertInfoFromCollector() {
		// TODO Auto-generated method stub
		Alert alert = new Alert();
		try {
			File alertFile = new File(alertInfoFile);
			java.io.FileReader fileReader = new java.io.FileReader(alertFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			alert.setEasCode(bufferedReader.readLine().trim().replace(" ", ""));
			alert.setFipsCode(bufferedReader.readLine().trim().replace(" ", ""));
			alert.setAlertId(bufferedReader.readLine().trim().replace(" ", ""));
			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alert;
	}

	public static String ExtractFipsCode(String detailedFipsCode) {
		String fipscode = "";
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(detailedFipsCode);
		while (m.find()) {
			fipscode = String.valueOf(m.group());
		}
		return fipscode;
	}

	public static String FormateDate(String date) throws ParseException {
		SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
		Date date1 = dt.parse(date);

		// *** same for the format String below
		SimpleDateFormat dt1 = new SimpleDateFormat("MMM d, yyyy");
		return dt1.format(date1).toString();
	}

	public static ServerDetails getServerDetails() {
		String[] westDetails = JsonUtil
				.convertJsonToString(new JSONObject(RestUtil.getStatusFromServer(GlueServerConfig.westServiceUrl)));
		String[] eastDetails = JsonUtil
				.convertJsonToString(new JSONObject(RestUtil.getStatusFromServer(GlueServerConfig.eastServiceUrl)));
		ServerDetails serverDetails = new ServerDetails();
		serverDetails.setWestRunningMode(westDetails[0]);
		serverDetails.setWestFailures(westDetails[1]);
		serverDetails.setEastRunningMode(eastDetails[0]);
		serverDetails.setEastFailures(eastDetails[1]);
		return serverDetails;
	}

	public static Date getFormattedDate(String date) {
		SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
		Date date1 = null;
		try {
			date1 = dt.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date1;
	}

	public static boolean simulateVPNSFailureOnWest(String westAutomationAgent) {
		boolean isVPNSFailed = false;
		RestUtil.triggerFailure(westAutomationAgent + "testVPNSFailure");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ServerDetails serverDetails = Util.getServerDetails();
		if (serverDetails.getWestRunningMode().equals("Secondary Mode")
				&& serverDetails.getWestFailures().equals("VPNS_PUSH_FAILURE")) {
			isVPNSFailed = true;
		}
		return isVPNSFailed;

	}

	public static boolean simulateVPNSFailureOnEast(String eastAutomationAgent) {
		boolean isVPNSFailed = false;
		RestUtil.triggerFailure(eastAutomationAgent + "testVPNSFailure");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ServerDetails serverDetails = Util.getServerDetails();
		if (serverDetails.getEastRunningMode().equals("Secondary Mode")
				&& serverDetails.getEastFailures().equals("VPNS_PUSH_FAILURE")) {
			isVPNSFailed = true;
		}
		return isVPNSFailed;

	}

	public static boolean simulateCDNFailureOnWest(String westAutomationAgent) {
		boolean isCDNFailed = false;
		RestUtil.triggerFailure(westAutomationAgent + "testCDNFailure");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ServerDetails serverDetails = Util.getServerDetails();
		if (serverDetails.getWestRunningMode().equals("Secondary Mode")
				&& serverDetails.getWestFailures().equals("CDN_PUSH_FAILURE")) {
			isCDNFailed = true;
		}
		return isCDNFailed;

	}

	public static boolean simulateCDNFailureOnEast(String eastAutomationAgent) {
		boolean isCDNFailed = false;
		RestUtil.triggerFailure(eastAutomationAgent + "testCDNFailure");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ServerDetails serverDetails = Util.getServerDetails();
		if (serverDetails.getEastRunningMode().equals("Secondary Mode")
				&& serverDetails.getEastFailures().equals("CDN_PUSH_FAILURE")) {
			isCDNFailed = true;
		}
		return isCDNFailed;

	}

	public static void simulateRestart(String automationAgent) {
		RestUtil.triggerFailure(automationAgent + "restartGlueServer");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void simulateStart(String automationAgent) {
		RestUtil.triggerFailure(automationAgent + "startGlueServer");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void simulateStop(String automationAgent) {
		RestUtil.triggerFailure(automationAgent + "stopGlueServer");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void simulateStartMysql(String automationAgent) {
		RestUtil.triggerFailure(automationAgent + "startMysql");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void simulateStopMysql(String automationAgent) {
		RestUtil.triggerFailure(automationAgent + "stopMysql");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void simulateStartHttp(String automationAgent) {
		RestUtil.triggerFailure(automationAgent + "startHttp");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void simulateStopHttp(String automationAgent) {
		RestUtil.triggerFailure(automationAgent + "stopHttp");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void simulateStartJetty(String automationAgent) {
		RestUtil.triggerFailure(automationAgent + "startJetty");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void simulateStopJetty(String automationAgent) {
		RestUtil.triggerFailure(automationAgent + "stopJetty");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void simulateStartNtp(String automationAgent) {
		RestUtil.triggerFailure(automationAgent + "startNtp");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void simulateStopNtp(String automationAgent) {
		RestUtil.triggerFailure(automationAgent + "stopNtp");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean simulateDBFailureOnWest(String westAutomationAgent) {
		boolean isDBFailed = false;
		RestUtil.triggerFailure(westAutomationAgent + "stopMysql");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ServerDetails serverDetails = Util.getServerDetails();
		if (serverDetails.getWestRunningMode().equals("Secondary Mode")
				&& serverDetails.getWestFailures().equals("DB_FAILURE")) {
			isDBFailed = true;
		}
		return isDBFailed;

	}

	public static boolean simulateDBFailureOnEast(String eastAutomationAgent) {
		boolean isDBFailed = false;
		RestUtil.triggerFailure(eastAutomationAgent + "stopMysql");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ServerDetails serverDetails = Util.getServerDetails();
		if (serverDetails.getEastRunningMode().equals("Secondary Mode")
				&& serverDetails.getEastFailures().equals("DB_FAILURE")) {
			isDBFailed = true;
		}
		return isDBFailed;

	}
	
	public static int getServerStatus(String serviceUrl) {
		int serverStatus = Integer.parseInt(RestUtil.getStatusFromServer(serviceUrl));
		return serverStatus;
	}
}
