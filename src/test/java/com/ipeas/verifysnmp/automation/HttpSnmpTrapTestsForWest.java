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

public class HttpSnmpTrapTestsForWest{

	@Test
	public void checkHttpTrap() throws InterruptedException {
		System.out.println("Staring checkHttpTrap For West");
		Util.simulateStopHttp(westAutomationAgent);
		WebDriverUtil.findElementByXpath(searchFieldBoxInSplunk).clear();
		WebDriverUtil.insertInTextBox(searchFieldBoxInSplunk, searchHttpdStopSnmp);
		WebDriverUtil.clickButtonUsingXpath(selectTimeInSplunkDropDown);
		WebDriverUtil.clickButtonUsingXpath(searchButtonInSplunk);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		List<WebElement> tables = WebDriverUtil.getTables(splunkTable);
		List<WebElement> tr_collection = tables.get(1).findElements(By.xpath(".//tbody/tr"));
		Assert.assertEquals(true,
				(WebDriverUtil.getSingleRow(tr_collection.get(0)).get(4).getText().contains(searchHttpdStopSnmp)));
		Util.simulateStartHttp(westAutomationAgent);
		WebDriverUtil.findElementByXpath(searchFieldBoxInSplunk).clear();
		System.out.println("checkHttpTrap done for West Glue Server successfully");

	}
}
