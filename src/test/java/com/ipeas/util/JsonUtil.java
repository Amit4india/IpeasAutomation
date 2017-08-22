package com.ipeas.util;

import org.json.JSONObject;

public class JsonUtil {

	public static String[] convertJsonToString(JSONObject jsonObject) {
		String[] details = new String[2];
		details[0] = jsonObject.getString("runningMode");
		if (jsonObject.getJSONArray("failures").length() != 0) {
			details[1] = jsonObject.getJSONArray("failures").getString(0);
		} else {
			details[1] = "No Failure";
		}
		return details;
	}
}
