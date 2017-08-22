package com.ipeas.alerts;

import static com.ipeas.config.GlueServerConfig.viewAllReportTable;
import static com.ipeas.config.GlueServerConfig.viewAllReportTableRows;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ipeas.data.Alert;
import com.ipeas.util.LaunchBrowser;
import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class MonitoringAlertTests {
	
	@Test
	@Parameters({ "MonitoringStagingServerUrl" })
	public void testVerifyAlerts(String MonitoringStagingServerUrl) throws InterruptedException
	{
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		LaunchBrowser.getDriver().navigate().to(MonitoringStagingServerUrl);
		Alert alert = Util.getAlertInfoFromCollector();
		WebDriverUtil.waitForElementToLoad(viewAllReportTable);
		WebElement table = WebDriverUtil.findElementByXpath(viewAllReportTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewAllReportTableRows);
		List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(1));
		Assert.assertEquals(WebDriverUtil.getTableColumnData(td_collection, 1).trim().replace(" ", ""), alert.getFipsCode());
		Assert.assertEquals(WebDriverUtil.getTableColumnData(td_collection, 2)+":"+WebDriverUtil.getTableColumnData(td_collection, 4).replace(" ", ""),  alert.getEasCode().trim());
		
	    }
	}


