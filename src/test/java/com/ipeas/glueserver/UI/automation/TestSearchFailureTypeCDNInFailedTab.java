package com.ipeas.glueserver.UI.automation;

import static com.ipeas.config.GlueServerConfig.failureTypeCDN;
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

public class TestSearchFailureTypeCDNInFailedTab {
	@Test
	public void testSearchFailureTypeCDNInFailedTab() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(glueServerStatusTab);
		WebDriverUtil.clickButtonUsingXpath(glueServerFailedAlertsTab);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(glueServerFailureTextBox);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.insertInTextBox(glueServerFailureTextBox, failureTypeCDN);
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("Search based on Failure Type  in GlueServer Failed Page");
		WebElement table = WebDriverUtil.findElementByXpath(viewFailedTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewFailedReportTableRows);
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			Assert.assertEquals(failureTypeCDN, td_collection.get(2).getText());
		}
	}
}
