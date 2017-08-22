package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.conopsIpeasReport;
import static com.ipeas.config.GlueServerConfig.easCodeInMonitoring;
import static com.ipeas.config.GlueServerConfig.enterEasCode;
import static com.ipeas.config.GlueServerConfig.searchButtonInMonitoring;
import static com.ipeas.config.GlueServerConfig.viewAllReportTable;
import static com.ipeas.config.GlueServerConfig.viewAllReportTableRows;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.util.WebDriverUtil;

public class TestSearchEasCodeInIpeasReport {
	@Test
	public void testSearchEasCodeInIpeasReport() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(conopsIpeasReport);
		WebDriverUtil.insertInTextBox(easCodeInMonitoring, enterEasCode);
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("Verify Search By EAS Code in Ipeas Report");
		WebElement table = WebDriverUtil.findElementByXpath(viewAllReportTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewAllReportTableRows);
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			Assert.assertEquals(enterEasCode, td_collection.get(2).getText());
		}
	}
}
