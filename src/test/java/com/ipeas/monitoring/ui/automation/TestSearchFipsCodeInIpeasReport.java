package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.conopsIpeasReport;
import static com.ipeas.config.GlueServerConfig.enterFipsCode;
import static com.ipeas.config.GlueServerConfig.fipsCodeInMonitoring;
import static com.ipeas.config.GlueServerConfig.searchButtonInMonitoring;
import static com.ipeas.config.GlueServerConfig.viewAllReportTable;
import static com.ipeas.config.GlueServerConfig.viewAllReportTableRows;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class TestSearchFipsCodeInIpeasReport {
	@Test
	public void testSearchFipsCodeInIpeasReport() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(conopsIpeasReport);
		WebDriverUtil.insertInTextBox(fipsCodeInMonitoring, enterFipsCode);
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("FipsCode Search In Ipeas Report");
		WebElement table = WebDriverUtil.findElementByXpath(viewAllReportTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewAllReportTableRows);
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			Assert.assertEquals(enterFipsCode, Util.ExtractFipsCode(td_collection.get(1).getText()));
		}
	}
}
