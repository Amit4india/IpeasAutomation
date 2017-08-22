package com.ipeas.glueserver.UI.automation;

import static com.ipeas.config.GlueServerConfig.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ipeas.base.BaseTestCase;
import com.ipeas.util.LaunchBrowser;
import com.ipeas.util.LoginUtil;
import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class TestGluesServerUI {

	@Test
	@Parameters({ "glueServerUrl" })
	public void testGlueServerLaunchPage(String GlueServerUrl) throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		LaunchBrowser.getDriver().navigate().to(GlueServerUrl);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		Assert.assertTrue(WebDriverUtil.isElementDisplayed(conopsIpeasReport));
	}


	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
}


