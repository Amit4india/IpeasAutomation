package com.ipeas.glueserver.UI.automation;

import static com.ipeas.config.GlueServerConfig.alertIDTextBoxInGlueServerTab;
import static com.ipeas.config.GlueServerConfig.capFileID;
import static com.ipeas.config.GlueServerConfig.glueServerFailedAlertsTab;
import static com.ipeas.config.GlueServerConfig.searchButtonInMonitoring;
import static com.ipeas.config.GlueServerConfig.viewFailedReportTableRows;
import static com.ipeas.config.GlueServerConfig.viewFailedTable;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.util.WebDriverUtil;

public class TestSearchAlertIDInFailedTab {
	@Test
	public void testSearchAlertIDInFailedTab() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(glueServerFailedAlertsTab);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(alertIDTextBoxInGlueServerTab);
		WebDriverUtil.insertInTextBox(alertIDTextBoxInGlueServerTab, capFileID);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("Search By Alert ID in Glue Server Failed");
		WebElement table = WebDriverUtil.findElementByXpath(viewFailedTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewFailedReportTableRows);
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			Assert.assertEquals(capFileID, td_collection.get(1).getText());
		}

}
}
