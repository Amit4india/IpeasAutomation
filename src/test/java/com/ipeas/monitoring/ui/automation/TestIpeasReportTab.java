package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.GlueServerURLs;
import static com.ipeas.config.GlueServerConfig.conopsIpeasReport;
import static com.ipeas.config.GlueServerConfig.ipeasReportTable;

import org.testng.annotations.Test;

import com.ipeas.util.WebDriverUtil;

public class TestIpeasReportTab {
  
  @Test
  public void testIpeasReportTab() throws InterruptedException {
	  	WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(conopsIpeasReport);
		WebDriverUtil.waitForElementToLoad(ipeasReportTable);
		WebDriverUtil.captureScreenShot("testIpeasReportTab");
		WebDriverUtil.waitForElementToAppear();
	}
}
