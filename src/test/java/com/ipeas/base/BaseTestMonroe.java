package com.ipeas.base;

import org.testng.annotations.AfterClass;
import static com.ipeas.config.GlueServerConfig.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ipeas.config.GlueServerConfig;
import com.ipeas.util.LaunchBrowser;
import com.ipeas.util.WebDriverUtil;

public class BaseTestMonroe {

	@Parameters({ "browserType", "appURL2" ,"driverPath"})
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
	
	
}

