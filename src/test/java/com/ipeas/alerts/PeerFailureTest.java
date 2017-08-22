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

public class PeerFailureTest extends ServerHandler{
	@Test
	public void testPeerFailure() {
		try {
			System.out.println("Testing Peer failover");
			GlueServerConfig.setPropertiesPath();
			GlueServerConfig.processConfig();
			ServerDetails serverDetails = Util.getServerDetails();
			if (serverDetails.getEastRunningMode().equals("Primary Mode")
					&& ("No Failure").equals(serverDetails.getWestFailures())) {
				Util.simulateStop(GlueServerConfig.eastAutomationAgent);
				Thread.sleep(50000);
				serverDetails = Util.getServerDetails();
				Assert.assertTrue(
						("Primary Mode").equals(serverDetails.getWestRunningMode())
								&& ("Not Running").equals(serverDetails.getEastRunningMode()),
						"Peer failure could not be simulated on East");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			Util.simulateStart(GlueServerConfig.eastAutomationAgent);
		}
		System.out.println("Tested Peer failover");
	}

}
