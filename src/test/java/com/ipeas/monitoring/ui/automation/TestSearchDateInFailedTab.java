package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.*;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.config.GlueServerConfig;
import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class TestSearchDateInFailedTab {
	@Test
	public void testSearchDateInFailedTab() throws InterruptedException, ParseException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToLoad(GlueServerConfig.FailedTestsReport);
		WebDriverUtil.clickButtonUsingXpath(conopsIpeasReport);
		WebDriverUtil.clickButtonUsingXpath(FailedTestsReport);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.insertInTextBox(startDateInMonitoring, startDate);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.insertInTextBox(toDateInMonitoring, endDate);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.captureScreenShot("Verify Date Search In Failed Report");

		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("VerifyDateSearch In Failed Tab of Monitoring");
		WebElement table = WebDriverUtil.findElementByXpath(viewFailedTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewFailedReportTableRows);
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			String value = td_collection.get(1).getText();
			Assert.assertTrue(value.contains(Util.FormateDate(startDate)));

		}
		WebDriverUtil.waitForElementToAppear();
		if (WebDriverUtil.isElementDisplayed(lastPage)) {
			WebDriverUtil.clickButtonUsingXpath(lastPage);
			WebDriverUtil.waitForElementToAppear();
			WebDriverUtil.captureScreenShot("VerifyDateSearchLastpage In Monitoring System");
			WebElement table2 = WebDriverUtil.findElementByXpath(viewFailedTable);
			List<WebElement> tr_collection2 = WebDriverUtil.getAllRows(table2, viewFailedReportTableRows);
			for (int i = 1; i < tr_collection2.size(); i++) {
				List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection2.get(i));
				String value = td_collection.get(1).getText();
				Assert.assertTrue(value.contains(Util.FormateDate(startDate)));
			}
		}

	}
}

