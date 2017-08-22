package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.FailedTestsReport;
import static com.ipeas.config.GlueServerConfig.ipeasReportTable;

import org.testng.annotations.Test;

import com.ipeas.util.WebDriverUtil;

public class TestIpeasFailedTab {
  @Test
  public void testIpeasFailedTab() throws InterruptedException {
	  	WebDriverUtil.waitForElementToAppear();
	  	WebDriverUtil.clickButtonUsingXpath(FailedTestsReport);
		WebDriverUtil.waitForElementToLoad(ipeasReportTable);
		WebDriverUtil.captureScreenShot("FailedReportTab");
		WebDriverUtil.waitForElementToAppear();
	}
}
