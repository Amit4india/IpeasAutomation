package com.ipeas.alerts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.base.ServerHandler;
import com.ipeas.config.GlueServerConfig;
import com.ipeas.data.ServerDetails;
import com.ipeas.util.Util;

public class CDNFailoverTest extends ServerHandler{

	@Test
	public void testCDNFailure() {
		System.out.println("Testing cdn failover");
		boolean failureStatus = false;
		GlueServerConfig.setPropertiesPath();
		GlueServerConfig.processConfig();
		ServerDetails serverDetails = Util.getServerDetails();
		if (serverDetails.getWestRunningMode().equals("Primary Mode")
				&& ("No Failure").equals(serverDetails.getWestFailures())) {
			failureStatus = Util.simulateCDNFailureOnWest(GlueServerConfig.westAutomationAgent);
			Assert.assertTrue(failureStatus, "CDN failure could not be simulated on West");
		} else if (serverDetails.getEastRunningMode().equals("Primary Mode")
				&& serverDetails.getEastFailures().equals("No Failure")) {
			failureStatus = Util.simulateCDNFailureOnEast(GlueServerConfig.eastAutomationAgent);
			Assert.assertTrue(failureStatus, "CDN failure could not be simulated on East");
		} else {
			Assert.assertTrue(failureStatus, "Servers are not running");
		}
		System.out.println("Tested cdn failover");
	}

}
