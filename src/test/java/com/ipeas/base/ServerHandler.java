package com.ipeas.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.ipeas.config.GlueServerConfig;
import com.ipeas.util.Util;

public class ServerHandler {

	@BeforeClass
	public void loadProperties() {
		GlueServerConfig.setPropertiesPath();
		GlueServerConfig.processConfig();
	}

	@BeforeMethod
	public void restartServers() {
		GlueServerConfig.setPropertiesPath();
		GlueServerConfig.processConfig();
		Util.simulateRestart(GlueServerConfig.westAutomationAgent);
		Util.simulateRestart(GlueServerConfig.eastAutomationAgent);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void restoreServers() {
		Util.simulateRestart(GlueServerConfig.westAutomationAgent);
		Util.simulateRestart(GlueServerConfig.eastAutomationAgent);
	}
}
