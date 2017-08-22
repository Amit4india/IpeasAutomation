package com.ipeas.alerts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ipeas.base.ServerHandler;
import com.ipeas.config.GlueServerConfig;
import com.ipeas.data.ServerDetails;
import com.ipeas.util.Util;

public class DatabaseFailoverTests extends ServerHandler {
	
	@Test
	public void testDBFailure() {
		System.out.println("Testing DB failover");
		boolean failureStatus = false;
		ServerDetails serverDetails = Util.getServerDetails();
		if (serverDetails.getWestRunningMode().equals("Primary Mode")
				&& serverDetails.getWestFailures().equals("No Failure")) {
			failureStatus = Util.simulateDBFailureOnWest(GlueServerConfig.westAutomationAgent);
			Assert.assertTrue(failureStatus, "DB failure could not be simulated on West");
		} else if (serverDetails.getEastRunningMode().equals("Primary Mode")
				&& serverDetails.getEastFailures().equals("No Failure")) {
			failureStatus = Util.simulateDBFailureOnEast(GlueServerConfig.eastAutomationAgent);
			Assert.assertTrue(failureStatus, "DB failure could not be simulated on East");
		} else {
			Assert.assertTrue(failureStatus, "Servers are not running");
		}
		System.out.println("Tested DB failover");
	}
	
}
