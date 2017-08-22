package com.ipeas.base;

import static com.ipeas.config.GlueServerConfig.SnapshotFileLocation;
import static com.ipeas.config.GlueServerConfig.searchFieldBoxInSplunk;
import static com.ipeas.config.GlueServerConfig.splunkSearchtab;
import static com.ipeas.config.GlueServerConfig.splunkSkipTag;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ipeas.config.GlueServerConfig;
import com.ipeas.util.LaunchBrowser;
import com.ipeas.util.WebDriverUtil;

public class SNMPBaseTestCase {

	@Parameters({ "browserType", "splunkUrl", "driverPath" })
	@BeforeClass
	public void launchBrowser(String browserType, String splunkUrl, String driverPath) throws InterruptedException
	{
		LaunchBrowser.setDriverPath(driverPath);
		loadPropertiesfromResourceFile();
		LaunchBrowser.initializeTestBaseSetup(browserType, splunkUrl);
		WebDriverUtil.waitTillElementIsVisible(splunkSkipTag);
		WebDriverUtil.clickButtonUsingXpath(splunkSkipTag);
		WebDriverUtil.waitTillElementIsVisible(splunkSearchtab);
		WebDriverUtil.clickButtonUsingXpath(splunkSearchtab);
		WebDriverUtil.waitTillElementIsVisible(searchFieldBoxInSplunk);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(searchFieldBoxInSplunk);
		
	}
	
	
	public void loadPropertiesfromResourceFile()
	{
		GlueServerConfig.setPropertiesPath();
		GlueServerConfig.processConfig();
	}
}
