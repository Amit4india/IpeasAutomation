package com.ipeas.glueserver.UI.automation;

import static com.ipeas.config.GlueServerConfig.*;
import static com.ipeas.config.GlueServerConfig.enterFipsCode;
import static com.ipeas.config.GlueServerConfig.glueServerFailedAlertsTab;
import static com.ipeas.config.GlueServerConfig.searchButtonInMonitoring;
import static com.ipeas.config.GlueServerConfig.viewAllReportTable;
import static com.ipeas.config.GlueServerConfig.viewAllReportTableRows;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class TestSearchFipsCodeInFailedTab {
	@Test
	public void testSearchFipsCodeInFailedTab() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(glueServerProcessedTab);
		WebDriverUtil.clickButtonUsingXpath(glueServerFailedAlertsTab);
		WebDriverUtil.clickButtonUsingXpath(capFileTextBoxInGlueServerTab);
		WebDriverUtil.insertInTextBox(capFileTextBoxInGlueServerTab, capFileID);
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("FipsCode Search in GlueServer Failed Page");
		WebElement table = WebDriverUtil.findElementByXpath(viewFailedTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewFailedTable);
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			Assert.assertEquals(capFileID, Util.ExtractFipsCode(td_collection.get(1).getText()));
		}
	}
}
