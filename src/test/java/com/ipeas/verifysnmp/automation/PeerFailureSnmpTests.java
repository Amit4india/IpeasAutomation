

package com.ipeas.verifysnmp.automation;
import static com.ipeas.config.GlueServerConfig.searchButtonInSplunk;
import static com.ipeas.config.GlueServerConfig.searchFieldBoxInSplunk;
import static com.ipeas.config.GlueServerConfig.searchVPNSSnmp;
import static com.ipeas.config.GlueServerConfig.selectTimeInSplunkDropDown;
import static com.ipeas.config.GlueServerConfig.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.base.SNMPBaseTestCase;
import com.ipeas.util.WebDriverUtil;

public class PeerFailureSnmpTests{
	
	@Test
	public void checkPeerFailureSnmp() throws InterruptedException {
		System.out.println("Starting checkPeerFailureTrap ");
		WebDriverUtil.findElementByXpath(searchFieldBoxInSplunk).clear();
		WebDriverUtil.insertInTextBox(searchFieldBoxInSplunk, searchGlueServerNotRunningSnmp);
		WebDriverUtil.clickButtonUsingXpath(selectTimeInSplunkDropDown);
		WebDriverUtil.clickButtonUsingXpath(searchButtonInSplunk);
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		List<WebElement> tables = WebDriverUtil.getTables(splunkTable);
		List<WebElement> tr_collection = tables.get(1).findElements(By.xpath(".//tbody/tr"));
		Assert.assertEquals(true,  (WebDriverUtil.getSingleRow(tr_collection.get(0)).get(4).getText().contains(searchGlueServerNotRunningSnmp)));
		WebDriverUtil.findElementByXpath(searchFieldBoxInSplunk).clear();
		System.out.println("checkPeerFailureTrap done successfully");
	}
}


