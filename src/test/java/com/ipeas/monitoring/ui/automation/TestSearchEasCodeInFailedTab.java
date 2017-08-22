package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.config.GlueServerConfig;
import com.ipeas.util.WebDriverUtil;

public class TestSearchEasCodeInFailedTab {
	@Test
	public void testSearchEasCodeInFailedTab() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(conopsIpeasReport);
		WebDriverUtil.clickButtonUsingXpath(FailedTestsReport);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.insertInTextBox(easCodeInMonitoring, enterEasCode);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("Verify Search By EAS Code in Failed Report");
		WebElement table = WebDriverUtil.findElementByXpath(viewFailedTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewFailedReportTableRows);
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			Assert.assertEquals(enterEasCode, td_collection.get(3).getText());
		}
	}
}
