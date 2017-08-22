package com.ipeas.glueserver.UI.automation;

import static com.ipeas.config.GlueServerConfig.capFileID;
import static com.ipeas.config.GlueServerConfig.capFileTextBoxInGlueServerTab;
import static com.ipeas.config.GlueServerConfig.glueServerFailedAlertsTab;
import static com.ipeas.config.GlueServerConfig.glueServerProcessedTab;
import static com.ipeas.config.GlueServerConfig.searchButtonInMonitoring;
import static com.ipeas.config.GlueServerConfig.viewAllReportTable;
import static com.ipeas.config.GlueServerConfig.viewAllReportTableRows;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class TestSearchFipsCodeInProcessedTab {
	@Test
	public void testSearchFipsCodeInProcessedTab() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(glueServerFailedAlertsTab);
		WebDriverUtil.clickButtonUsingXpath(glueServerProcessedTab);
		WebDriverUtil.clickButtonUsingXpath(capFileTextBoxInGlueServerTab);
		WebDriverUtil.insertInTextBox(capFileTextBoxInGlueServerTab, capFileID);
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("FipsCode Search in GlueServer Page");
		WebElement table = WebDriverUtil.findElementByXpath(viewAllReportTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewAllReportTableRows);
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			Assert.assertEquals(capFileID, Util.ExtractFipsCode(td_collection.get(2).getText()));
		}
	}
	
	
}
