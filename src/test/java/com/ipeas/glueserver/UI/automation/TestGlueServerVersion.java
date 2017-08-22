package com.ipeas.glueserver.UI.automation;

import static com.ipeas.config.GlueServerConfig.glueServerStatusTab;
import static com.ipeas.config.GlueServerConfig.glueServerVersion;
import static com.ipeas.config.GlueServerConfig.viewAllReportTable;
import static com.ipeas.config.GlueServerConfig.viewAllReportTableRows;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.util.WebDriverUtil;

public class TestGlueServerVersion {
	@Test
	public void testGlueServerVersion() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(glueServerStatusTab);
		WebDriverUtil.captureScreenShot("glueServerStatusTab");
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.captureScreenShot("GlueServer Version");
		WebElement table = WebDriverUtil.findElementByXpath(viewAllReportTable);
		List<WebElement> tr_collection = WebDriverUtil.getAllRows(table, viewAllReportTableRows);
		//for (int i = 1; i < tr_collection.size(); i++) {
			List<WebElement> td_collection = WebDriverUtil.getSingleRow(tr_collection.get(8));
			Assert.assertEquals(glueServerVersion, td_collection.get(1).getText());
		
	}
}
