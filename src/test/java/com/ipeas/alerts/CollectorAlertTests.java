package com.ipeas.alerts;

import static com.ipeas.config.GlueServerConfig.alertId;
import static com.ipeas.config.GlueServerConfig.alertInfoFile;
import static com.ipeas.config.GlueServerConfig.collectorAddFipsCodeButton;
import static com.ipeas.config.GlueServerConfig.collectorEasConfirmationButton;
import static com.ipeas.config.GlueServerConfig.collectorFipsCodeRemoveButton;
import static com.ipeas.config.GlueServerConfig.collectorFipsPoolDropDown;
import static com.ipeas.config.GlueServerConfig.collectorRunAlertButton;
import static com.ipeas.config.GlueServerConfig.easCodesDropDown;
import static com.ipeas.config.GlueServerConfig.originatedAlertsRadioButton;
import static com.ipeas.config.GlueServerConfig.sendAlertRadioButtonName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.ipeas.base.BaseTestMonroe;
import com.ipeas.data.AlertEasCode;
import com.ipeas.data.AlertFipsCode;
import com.ipeas.data.RadioButton;
import com.ipeas.util.LoginUtil;
import com.ipeas.util.Util;
import com.ipeas.util.WebDriverUtil;

public class CollectorAlertTests extends BaseTestMonroe {

	@Test
	public void testLogin() throws InterruptedException {
		WebDriverUtil.waitForElementToAppear();
		LoginUtil.monroeLogin();
	}

	@Test(dependsOnMethods = "testLogin")
	public void testSendAlert() {
		int randomIndex = Util.getRandomNumber(10);
		RadioButton radioButton = WebDriverUtil.getAlertRadioButtonState(sendAlertRadioButtonName, 0);
		if (!radioButton.isState()) {
			radioButton.getXpath().click();
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
		String alertId;
		try {
			alertId = retriveAlertId();
			writeAlertInfoInFile(easCode, fipsCode, alertId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private String retriveAlertId() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverUtil.waitForElementToLoad(originatedAlertsRadioButton);
		RadioButton radioButton = WebDriverUtil.getAlertRadioButtonState(sendAlertRadioButtonName, 1);
		if (!radioButton.isState()) {
			radioButton.getXpath().click();
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
