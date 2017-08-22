package com.ipeas.glueserver.UI.automation;

import static com.ipeas.config.GlueServerConfig.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class TestSearchAlertIDInProcessedTab {
	@Test
	public void testSearchAlertIDInProcessedTab() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(glueServerFailedAlertsTab);
			WebDriverUtil.clickButtonUsingXpath(glueServerProcessedTab);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(alertIDTextBoxInGlueServerTab);
		WebDriverUtil.insertInTextBox(alertIDTextBoxInGlueServerTab, capFileID);
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("Search By Alert ID in Glue Server");
		WebElement table = WebDriverUtil.findElementByXpath(viewAllReportTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewAllReportTableRows);
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			Assert.assertEquals(capFileID, Util.ExtractFipsCode(td_collection.get(2).getText()));
		}
	}
}
