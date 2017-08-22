package com.ipeas.verifysnmp.automation;

import static com.ipeas.config.GlueServerConfig.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.base.SNMPBaseTestCase;
import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class JettySnmpTrapTests {

	@Test
	public void checkJettyTrap() throws InterruptedException {
		System.out.println("Starting checkJettyTrap for East");
		Util.simulateStopJetty(eastAutomationAgent);
		WebDriverUtil.findElementByXpath(searchFieldBoxInSplunk).clear();
		WebDriverUtil.insertInTextBox(searchFieldBoxInSplunk, searchJettySnmp);
		WebDriverUtil.clickButtonUsingXpath(selectTimeInSplunkDropDown);
		WebDriverUtil.clickButtonUsingXpath(searchButtonInSplunk);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		List<WebElement> tables = WebDriverUtil.getTables(splunkTable);
		WebDriverUtil.waitForElementToAppear();
		List<WebElement> tr_collection = tables.get(1).findElements(By.xpath(".//tbody/tr"));
		Assert.assertEquals(true,
				(WebDriverUtil.getSingleRow(tr_collection.get(0)).get(4).getText().contains(searchJettySnmp)));
		Util.simulateStartJetty(eastAutomationAgent);
		WebDriverUtil.findElementByXpath(searchFieldBoxInSplunk).clear();
		System.out.println("checkJettyTrap done for East Glue Server successfully");

	}
}
