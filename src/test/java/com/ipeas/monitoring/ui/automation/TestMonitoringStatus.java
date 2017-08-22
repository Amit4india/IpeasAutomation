package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.MonitoringStatus;
import static com.ipeas.config.GlueServerConfig.ipeasReportTable;

import org.testng.annotations.Test;

import com.ipeas.util.WebDriverUtil;

public class TestMonitoringStatus {
  @Test
  public void testMonitoringStatus() throws InterruptedException {
	  	WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(MonitoringStatus);
		WebDriverUtil.waitForElementToLoad(ipeasReportTable);
		WebDriverUtil.captureScreenShot("MonitoringStatusTab");
		WebDriverUtil.waitForElementToAppear();
	}
}
