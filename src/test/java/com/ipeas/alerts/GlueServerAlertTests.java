package com.ipeas.alerts;

import static com.ipeas.config.GlueServerConfig.viewAllReportTable;
import static com.ipeas.config.GlueServerConfig.viewAllReportTableRows;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.config.GlueServerConfig;
import com.ipeas.data.Alert;
import com.ipeas.data.ServerDetails;
import com.ipeas.util.LaunchBrowser;
import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class GlueServerAlertTests {

	@Test
	public void testVerifyAlerts() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		ServerDetails serverDetails = Util.getServerDetails();
		if (serverDetails.getWestRunningMode().equals("Primary Mode")) {
			LaunchBrowser.getDriver().navigate().to(GlueServerConfig.westUrl);
		} else if (serverDetails.getEastRunningMode().equals("Primary Mode")) {
			LaunchBrowser.getDriver().navigate().to(GlueServerConfig.eastUrl);
		} else {
			LaunchBrowser.getDriver().navigate().to(GlueServerConfig.westUrl);
		}
		Alert alert = Util.getAlertInfoFromCollector();
		WebDriverUtil.waitForElementToLoad(viewAllReportTable);
		WebElement table = WebDriverUtil.findElementByXpath(viewAllReportTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewAllReportTableRows);
		List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(1));
		Assert.assertEquals(WebDriverUtil.getTableColumnData(td_collection, 2).trim().replace(" ", ""),
				alert.getAlertId());
	}
}
