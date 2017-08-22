package com.ipeas.glueserver.UI.automation;

import static com.ipeas.config.GlueServerConfig.glueServerStatusTab;
import static com.ipeas.config.GlueServerConfig.glueServerVersionCDNUrl;
import static com.ipeas.config.GlueServerConfig.viewAllReportTable;
import static com.ipeas.config.GlueServerConfig.viewAllReportTableRows;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.util.WebDriverUtil;

public class TestGlueServerCDNUrl {
	@Test
	public void testGlueServerCDNUrl() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(glueServerStatusTab);
		WebDriverUtil.captureScreenShot("glueServerStatusTab");
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("GlueServer VPNS Url");
		WebElement table = WebDriverUtil.findElementByXpath(viewAllReportTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewAllReportTableRows);
		List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(2));
		Assert.assertEquals(glueServerVersionCDNUrl, td_collection.get(1).getText());
	
	}
}
