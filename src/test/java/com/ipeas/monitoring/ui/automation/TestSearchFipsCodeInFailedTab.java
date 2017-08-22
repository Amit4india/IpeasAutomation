package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.FailedTestsReport;
import static com.ipeas.config.GlueServerConfig.conopsIpeasReport;
import static com.ipeas.config.GlueServerConfig.enterFipsCode;
import static com.ipeas.config.GlueServerConfig.fipsCodeInMonitoring;
import static com.ipeas.config.GlueServerConfig.searchButtonInMonitoring;
import static com.ipeas.config.GlueServerConfig.viewFailedReportTableRows;
import static com.ipeas.config.GlueServerConfig.viewFailedTable;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.config.GlueServerConfig;
import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class TestSearchFipsCodeInFailedTab {
	@Test
	public void testSearchFipsCodeInFailedTab() throws InterruptedException {

		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToLoad(GlueServerConfig.FailedTestsReport);
		WebDriverUtil.clickButtonUsingXpath(conopsIpeasReport);
		WebDriverUtil.clickButtonUsingXpath(FailedTestsReport);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.insertInTextBox(fipsCodeInMonitoring, enterFipsCode);
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("FipsCode Search In Failed Report");
		WebElement table = WebDriverUtil.findElementByXpath(viewFailedTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewFailedReportTableRows);
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			Assert.assertEquals(enterFipsCode, Util.ExtractFipsCode(td_collection.get(2).getText()));
		}
	}
}
