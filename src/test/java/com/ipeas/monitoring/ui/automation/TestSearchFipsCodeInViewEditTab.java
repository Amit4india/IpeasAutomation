package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.ViewEditFIPSCode;
import static com.ipeas.config.GlueServerConfig.enterFipsCode;
import static com.ipeas.config.GlueServerConfig.fipsCodeBoxInViewEditTab;
import static com.ipeas.config.GlueServerConfig.searchButtonInMonitoring;
import static com.ipeas.config.GlueServerConfig.viewAllReportTable;
import static com.ipeas.config.GlueServerConfig.viewAllReportTableRows;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.config.GlueServerConfig;
import com.ipeas.util.WebDriverUtil;

public class TestSearchFipsCodeInViewEditTab {
	@Test
	public void testSearchFipsCodeInViewEditTab() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToLoad(GlueServerConfig.ViewEditFIPSCode);
		WebDriverUtil.clickButtonUsingXpath(ViewEditFIPSCode);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.insertInTextBox(fipsCodeBoxInViewEditTab, enterFipsCode);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("FipsCode Search in View/Edit Report");
		WebElement table = WebDriverUtil.findElementByXpath(viewAllReportTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewAllReportTableRows);
		System.out.println(tr_collection.size());
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			String value = td_collection.get(1).getText();
			Assert.assertEquals(enterFipsCode, value);
		}
	}
}
