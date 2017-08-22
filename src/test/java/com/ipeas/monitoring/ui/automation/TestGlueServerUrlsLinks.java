package com.ipeas.monitoring.ui.automation;

import static com.ipeas.config.GlueServerConfig.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.util.WebDriverUtil;

public class TestGlueServerUrlsLinks {
	@Test
	public void testGlueServerURLs() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.clickButtonUsingXpath(GlueServerURLs);
		Assert.assertTrue(WebDriverUtil.isElementDisplayed(glueServerEast), "Link is not active");
		WebDriverUtil.clickButtonUsingXpath(glueServerEast);
		Assert.assertTrue(WebDriverUtil.isElementDisplayed(glueServerProcessedTab), "Link is not active");
	}

}
