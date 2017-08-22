package com.ipeas.glueserver.UI.automation;

import static com.ipeas.config.GlueServerConfig.failureTypeExpire;
import static com.ipeas.config.GlueServerConfig.glueServerFailedAlertsTab;
import static com.ipeas.config.GlueServerConfig.glueServerFailureTextBox;
import static com.ipeas.config.GlueServerConfig.glueServerStatusTab;
import static com.ipeas.config.GlueServerConfig.searchButtonInMonitoring;
import static com.ipeas.config.GlueServerConfig.viewFailedReportTableRows;
import static com.ipeas.config.GlueServerConfig.viewFailedTable;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.util.WebDriverUtil;

public class TestSearchFailureTypeExpireInFailedTab {
	@Test
	public void testSearchFailureTypeExpireInFailedTab() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(glueServerStatusTab);
		WebDriverUtil.clickButtonUsingXpath(glueServerFailedAlertsTab);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(glueServerFailureTextBox);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.insertInTextBox(glueServerFailureTextBox, failureTypeExpire);
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("Search based on Failure Type  in GlueServer Failed Page");
		WebElement table = WebDriverUtil.findElementByXpath(viewFailedTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewFailedReportTableRows);
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			Assert.assertEquals(failureTypeExpire, td_collection.get(2).getText());
		}
	}
}
