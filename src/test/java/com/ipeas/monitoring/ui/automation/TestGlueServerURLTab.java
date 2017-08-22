package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.GlueServerURLs;
import static com.ipeas.config.GlueServerConfig.ipeasReportTable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.util.WebDriverUtil;

public class TestGlueServerURLTab {
  @Test
  public void testGlueServerURLTab() throws InterruptedException {
	  	WebDriverUtil.waitForElementToAppear();
	  	WebDriverUtil.clickButtonUsingXpath(GlueServerURLs);
		WebDriverUtil.waitForElementToLoad(ipeasReportTable);
	//	Assert.assertTrue(WebDriverUtil.find, message);
		WebDriverUtil.captureScreenShot("GlueServerURLsTab");
		WebDriverUtil.waitForElementToAppear();
	}
}
