package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.FailedTestsReport;
import static com.ipeas.config.GlueServerConfig.GlueServerURLs;
import static com.ipeas.config.GlueServerConfig.MonitoringStatus;
import static com.ipeas.config.GlueServerConfig.ViewEditFIPSCode;
import static com.ipeas.config.GlueServerConfig.conopsIpeasReport;
import static com.ipeas.config.GlueServerConfig.easCodeInMonitoring;
import static com.ipeas.config.GlueServerConfig.endDate;
import static com.ipeas.config.GlueServerConfig.enterEasCode;
import static com.ipeas.config.GlueServerConfig.enterFipsCode;
import static com.ipeas.config.GlueServerConfig.fipsCodeBoxInViewEditTab;
import static com.ipeas.config.GlueServerConfig.fipsCodeInMonitoring;
import static com.ipeas.config.GlueServerConfig.ipeasReportTable;
import static com.ipeas.config.GlueServerConfig.lastPage;
import static com.ipeas.config.GlueServerConfig.searchButtonInMonitoring;
import static com.ipeas.config.GlueServerConfig.startDate;
import static com.ipeas.config.GlueServerConfig.startDateInMonitoring;
import static com.ipeas.config.GlueServerConfig.toDateInMonitoring;
import static com.ipeas.config.GlueServerConfig.viewAllReportTable;
import static com.ipeas.config.GlueServerConfig.viewAllReportTableRows;
import static com.ipeas.config.GlueServerConfig.viewFailedReportTableRows;
import static com.ipeas.config.GlueServerConfig.viewFailedTable;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ipeas.base.BaseTestCase;
import com.ipeas.config.GlueServerConfig;
import com.ipeas.util.LaunchBrowser;
import com.ipeas.util.LoginUtil;
import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class MonitoringUrlTest  {

	@Test
	@Parameters({ "MonitoringStagingServerUrl" })
	public void testMonitoringUrl(String monitoringUrl) throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		//LaunchBrowser.getDriver().navigate().to(monitoringUrl);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		Assert.assertTrue(WebDriverUtil.isElementDisplayed(conopsIpeasReport));
	}

}
