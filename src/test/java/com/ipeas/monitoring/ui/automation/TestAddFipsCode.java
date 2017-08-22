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

public class TestAddFipsCode  {

	@Test
	@Parameters({ "MonitoringStagingServerUrl" })
	public void testAddFipsCodeFromViewEditTab(String monitoringUrl) throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		//LaunchBrowser.getDriver().navigate().to(monitoringUrl);
		WebDriverUtil.waitForElementToLoad(GlueServerConfig.ViewEditFIPSCode);
		WebDriverUtil.clickButtonUsingXpath(ViewEditFIPSCode);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(addButtonInViewEditFipsCode);
		WebDriverUtil.findElementByXpath(addFipsCodeFromViewEdit).sendKeys(addFipsCode);
		WebDriverUtil.findElementByXpath(addCountyNameFromViewEdit).sendKeys(addCountyName);
		WebDriverUtil.findElementByXpath(addMarketFromViewEdit).sendKeys(addMarketName);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(alertPopUpSaveButton);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("Snapshot after Adding Fips Code");
		WebDriverUtil.clickButtonUsingXpath(conopsIpeasReport);
		WebDriverUtil.clickButtonUsingXpath(ViewEditFIPSCode);
		WebDriverUtil.insertInTextBox(fipsCodeBoxInViewEditTab, addFipsCode);
		WebDriverUtil.clickButtonUsingXpath(searchButtonInMonitoring);
		WebDriverUtil.waitForElementToAppear();
		WebElement table = WebDriverUtil.findElementByXpath(viewAllReportTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewAllReportTableRows);
		System.out.println(tr_collection.size());
		for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(i));
			String value = td_collection.get(1).getText();
			Assert.assertEquals(addFipsCode, value);
		}
		WebDriverUtil.clickButtonUsingXpath(selectRadioButtonInViewEditFipsCode);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(deleteButtonInViewEditFipsCode);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(alertPopUpDeleteButton);
		WebDriverUtil.waitForElementToAppear();

	}
}
