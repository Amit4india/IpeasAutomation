package com.ipeas.verifysnmp.automation;
import static com.ipeas.config.GlueServerConfig.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ipeas.base.ServerHandler;
import com.ipeas.util.Util;

public class ServerStatusTests extends ServerHandler{
	
	@Test
	public void testWestServerStatus() {
		System.out.println("Testing West server status");
		int serverStatus = Util.getServerStatus(westServerStatusUrl);
		Assert.assertTrue(serverStatus==200 || serverStatus==500);
		if (serverStatus ==200)
		{
			System.out.println("West is in Primary mode");
		}
		else
		{
			System.out.println("West is in Secondary mode");
		}
		System.out.println("Tested West server status");
	}

	@Test
	public void testEastServerStatus() {
		System.out.println("Testing East server status");
		int serverStatus = Util.getServerStatus(eastServerStatusUrl);
		Assert.assertTrue(serverStatus==200 || serverStatus==500);
		if (serverStatus ==200)
		{
			System.out.println("East is in Primary mode");
		}
		else
		{
			System.out.println("East is in Secondary mode");
		}
		System.out.println("Tested East server status");
	}

}
