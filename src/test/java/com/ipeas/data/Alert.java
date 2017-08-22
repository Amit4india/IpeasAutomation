package com.ipeas.data;

public class Alert {

	private String alertId;
	private String easCode;
	public String getAlertId() {
		return alertId;
	}
	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}
	public String getEasCode() {
		return easCode;
	}
	public void setEasCode(String easCode) {
		this.easCode = easCode;
	}
	public String getFipsCode() {
		return fipsCode;
	}
	public void setFipsCode(String fipsCode) {
		this.fipsCode = fipsCode;
	}
	private String fipsCode;
}
