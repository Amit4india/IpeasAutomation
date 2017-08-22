package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.ViewEditFIPSCode;
import static com.ipeas.config.GlueServerConfig.ipeasReportTable;

import org.testng.annotations.Test;

import com.ipeas.util.WebDriverUtil;

public class TestViewEditFipsCodeTab {
  @Test
  public void testViewEditFipsCodeTab() throws InterruptedException {
	  	WebDriverUtil.waitForElementToAppear();
	  	WebDriverUtil.clickButtonUsingXpath(ViewEditFIPSCode);
		WebDriverUtil.waitForElementToLoad(ipeasReportTable);
		WebDriverUtil.captureScreenShot("ViewEditFipsCodeTab");
		WebDriverUtil.waitForElementToAppear();
	}
}
