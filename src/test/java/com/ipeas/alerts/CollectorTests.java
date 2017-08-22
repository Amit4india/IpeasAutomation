package com.ipeas.alerts;

import static com.ipeas.config.GlueServerConfig.alertId;
import static com.ipeas.config.GlueServerConfig.alertInfoFile;
import static com.ipeas.config.GlueServerConfig.collectorAddFipsCodeButton;
import static com.ipeas.config.GlueServerConfig.collectorEasConfirmationButton;
import static com.ipeas.config.GlueServerConfig.collectorFipsCodeRemoveButton;
import static com.ipeas.config.GlueServerConfig.collectorFipsPoolDropDown;
import static com.ipeas.config.GlueServerConfig.collectorRunAlertButton;
import static com.ipeas.config.GlueServerConfig.easCodesDropDown;
import static com.ipeas.config.GlueServerConfig.monroeMenuTab;
import static com.ipeas.config.GlueServerConfig.originatedAlertRadioButtonName;
import static com.ipeas.config.GlueServerConfig.sendAlertRadioButtonName;
import static com.ipeas.config.GlueServerConfig.collectorUserNameTextBox;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ipeas.base.BaseTestCase;
import com.ipeas.data.AlertEasCode;
import com.ipeas.data.AlertFipsCode;
import com.ipeas.data.RadioButton;
import com.ipeas.util.LoginUtil;
import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class CollectorTests extends BaseTestCase {

	@Test
	public void testLogin() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		WebDriverUtil.waitForElementToAppear();
		//WebDriverUtil.waitForElementToLoad(collectorUserNameTextBox);
		LoginUtil.monroeLogin();
	}

	@Test(dependsOnMethods = "testLogin")
	public void testSendAlert() {
		WebElement menuTab = WebDriverUtil.findElementByXpath(monroeMenuTab);
		List<WebElement> td_collection = WebDriverUtil.getSingleRow(menuTab);
		if (td_collection.get(0).getAttribute("class").isEmpty()) {
			RadioButton radioButton = WebDriverUtil.getAlertRadioButtonState(sendAlertRadioButtonName, 0);
			if (!radioButton.isState()) {
				radioButton.getXpath().click();
			}
		} else {
			List<WebElement> font = WebDriverUtil.getFontElements(td_collection.get(0));
			List<WebElement> hyperLinks = WebDriverUtil.getHyperLinksElements(font.get(0));
			hyperLinks.get(0).click();
			RadioButton radioButton = WebDriverUtil.getAlertRadioButtonState(sendAlertRadioButtonName, 0);
			if (!radioButton.isState()) {
				radioButton.getXpath().click();
			}
		}
		List<String> easCodes = AlertEasCode.getEasCodes();
		String easCode = easCodes.get(Util.getRandomNumber(easCodes.size()));
		WebDriverUtil.waitForElementToLoad(easCodesDropDown);
		WebDriverUtil.selectElementFromDropDownUsingVisibleText(easCodesDropDown, easCode);
		try {
			while (WebDriverUtil.findElementByXpath(collectorFipsCodeRemoveButton) != null) {
				WebDriverUtil.clickButtonUsingXpath(collectorFipsCodeRemoveButton);
			}
		} catch (NoSuchElementException elementException) {
			System.out.println("All existing fips codes are deleted");
		}
		List<String> fipsCodes = AlertFipsCode.getFipsCodes();
		WebDriverUtil.waitForElementToLoad(collectorFipsPoolDropDown);
		String fipsCode = fipsCodes.get(Util.getRandomNumber(fipsCodes.size()));
		WebDriverUtil.selectElementFromDropDownUsingVisibleText(collectorFipsPoolDropDown, fipsCode);
		WebDriverUtil.clickButtonUsingId(collectorAddFipsCodeButton);
		WebDriverUtil.clickButtonUsingId(collectorEasConfirmationButton);
		WebDriverUtil.clickButtonUsingId(collectorRunAlertButton);
		try {
			WebDriverUtil.waitForElementToAppear();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String alertId;
		try {
			alertId = retriveAlertId();
			writeAlertInfoInFile(easCode, fipsCode, alertId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private String retriveAlertId() throws InterruptedException {
		WebElement menuTab = WebDriverUtil.findElementByXpath(monroeMenuTab);
		List<WebElement> td_collection = WebDriverUtil.getSingleRow(menuTab);
		if (td_collection.get(1).getAttribute("class").isEmpty()) {
			RadioButton radioButton = WebDriverUtil.getAlertRadioButtonState(originatedAlertRadioButtonName, 4);
			if (!radioButton.isState()) {
				radioButton.getXpath().click();
			}
		} else {
			List<WebElement> font = WebDriverUtil.getFontElements(td_collection.get(1));
			List<WebElement> hyperLinks = WebDriverUtil.getHyperLinksElements(font.get(0));
			hyperLinks.get(0).click();
			RadioButton radioButton = WebDriverUtil.getAlertRadioButtonState(originatedAlertRadioButtonName, 4);
			if (!radioButton.isState()) {
				radioButton.getXpath().click();
			}
		}
		String alert = WebDriverUtil.findElementByXpath(alertId).getText().toString();
		return alert;
	}

	private void writeAlertInfoInFile(String easCode, String fipsCode, String alertId) {
		try {
			File alertFile = new File(alertInfoFile);
			if (alertFile.exists()) {
				alertFile.delete();
			}
			FileWriter fileWriter = new FileWriter(alertFile, true);
			fileWriter.write(easCode + "\n");
			fileWriter.write(fipsCode + "\n");
			fileWriter.write(alertId);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
