package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ipeas.base.BaseTestCase;
import com.ipeas.config.GlueServerConfig;
import com.ipeas.util.LaunchBrowser;
import com.ipeas.util.WebDriverUtil;

public class TestDeleteFipsCode  {

	@Test
	@Parameters({ "MonitoringStagingServerUrl" })
	public void testDeleteFipsCodeButtonInMonitoring(String monitoringUrl) throws InterruptedException {
		String fipsCode = "";
		WebDriverUtil.waitForElementToAppear();
		//LaunchBrowser.getDriver().navigate().to(monitoringUrl);
		WebDriverUtil.waitForElementToLoad(GlueServerConfig.ViewEditFIPSCode);
		WebDriverUtil.clickButtonUsingXpath(ViewEditFIPSCode);
		WebDriverUtil.waitForElementToAppear();
		WebElement table = WebDriverUtil.findElementByXpath(viewAllReportTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewAllReportTableRows);
		System.out.println(tr_collection.size());
		for (int i = 1; i < 2; i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			fipsCode = td_collection.get(1).getText();
		}
		WebDriverUtil.clickButtonUsingXpath(selectRadioButtonInViewEditFipsCode);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(deleteButtonInViewEditFipsCode);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(alertPopUpDeleteButton);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.insertInTextBox(fipsCodeBoxInViewEditTab, fipsCode);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		String valueOnPage = WebDriverUtil.findElementByXpath(recordNotFound).getText();
		System.out.println(valueOnPage);
		WebDriverUtil.captureScreenShot("Snapshot after deleting Fips Code");
		Assert.assertEquals("No Records Found", valueOnPage);

	}
}
