package com.ipeas.util;

import static com.ipeas.config.GlueServerConfig.*;
import static com.ipeas.config.GlueServerConfig.conopsPasswordTextBox;
import static com.ipeas.config.GlueServerConfig.conopsUserNameTextBox;
import static com.ipeas.config.GlueServerConfig.conopsUsername;
import static com.ipeas.config.GlueServerConfig.conopsPassword;

public class LoginUtil {	

	public static void login() {
		// TODO Auto-generated method stub
		WebDriverUtil.insertInTextBox(conopsUserNameTextBox, conopsUsername);
		WebDriverUtil.insertInTextBox(conopsPasswordTextBox, conopsPassword);
		WebDriverUtil.clickButtonUsingXpath(conopsLoginButton);
	}
	
	public static void monroeLogin()
	{
		WebDriverUtil.insertInTextBox(collectorUserNameTextBox, collectorUsername);
		WebDriverUtil.insertInTextBox(collectorPasswordTextBox, collectorPassword);
		WebDriverUtil.clickButtonUsingXpath(collectorLoginButton);
	}
}
