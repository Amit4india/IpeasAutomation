package com.ipeas.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ipeas.config.GlueServerConfig;
import com.ipeas.util.LaunchBrowser;
import com.ipeas.util.WebDriverUtil;

import static com.ipeas.config.GlueServerConfig.SnapshotFileLocation;
import static com.ipeas.config.GlueServerConfig.collectorUserNameTextBox;

public class BaseTestCase {

	@Parameters({ "browserType", "monroeUrl", "driverPath" })
	@BeforeClass
	public void launchBrowser(String browserType, String appURL, String driverPath) throws InterruptedException
	{
		LaunchBrowser.setDriverPath(driverPath);
		loadPropertiesfromResourceFile();
		LaunchBrowser.initializeTestBaseSetup(browserType, appURL);
		WebDriverUtil.deleteScreenShot(SnapshotFileLocation);
		
	}
	
	
	public void loadPropertiesfromResourceFile()
	{
		GlueServerConfig.setPropertiesPath();
		GlueServerConfig.processConfig();
	}
	
/*	@AfterClass
	public void closeBrowser()
	{
		LaunchBrowser.getDriver().quit();
	}*/
}
