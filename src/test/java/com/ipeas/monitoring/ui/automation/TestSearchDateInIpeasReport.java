package com.ipeas.monitoring.ui.automation;

import org.testng.annotations.Test;
import static com.ipeas.config.GlueServerConfig.*;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class TestSearchDateInIpeasReport {
  @Test
  public void testSearchDateInIpeasReport() throws InterruptedException, ParseException {
		WebDriverUtil.clickButtonUsingXpath(conopsIpeasReport);
		WebDriverUtil.insertInTextBox(startDateInMonitoring, startDate);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.insertInTextBox(toDateInMonitoring, endDate);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("VerifyDateSearch in Ipeas Report");
		WebElement table = WebDriverUtil.findElementByXpath(viewAllReportTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewAllReportTableRows);
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			String value = td_collection.get(0).getText();
			Assert.assertTrue(value.contains(Util.FormateDate(startDate)));
		}

		WebDriverUtil.waitForElementToAppear();
		if (WebDriverUtil.isElementDisplayed(lastPage)) {
			WebDriverUtil.clickButtonUsingXpath(lastPage);
			WebDriverUtil.waitForElementToAppear();
			WebDriverUtil.captureScreenShot("VerifyDateSearchLastpage");
			WebElement table2 = WebDriverUtil.findElementByXpath(viewAllReportTable);
			List<WebElement> tr_collection2 = WebDriverUtil.getAllRows(table2, viewAllReportTableRows);
			for (int i = 1; i < tr_collection2.size(); i++) {
				List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection2.get(i));
				String value = td_collection.get(0).getText();
				Assert.assertTrue(value.contains(Util.FormateDate(startDate)));
			}
		}
	}
}
