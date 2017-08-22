package com.ipeas.util;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LaunchBrowser {

	private static WebDriver driver;
	public static String driverPath;
	
	public static void setDriverPath(String path){
	driverPath = path;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	private static void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath );
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		/*System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", driverPath+"/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);*/
		   String Xport = System.getProperty(
	                "lmportal.xvfb.id", ":1");
	        final File firefoxPath = new File(System.getProperty(
	                "lmportal.deploy.firefox.path", "/usr/bin/firefox"));
	        FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath);
	        firefoxBinary.setEnvironmentProperty("DISPLAY", Xport);

	        // Start Firefox driver
	 driver = new FirefoxDriver(firefoxBinary, null);
		return driver;
	}

	public static void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*public void tearDown() {
		driver.quit();
	}
*/
}
