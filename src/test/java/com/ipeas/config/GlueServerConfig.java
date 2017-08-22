// COPYRIGHT HEADER
//------------------------------------------------------------
// Copyright 2014 Time Warner Cable, Inc.
//
//
// This module contains unpublished, confidential, proprietary
// material.  The use and dissemination of this material are
// governed by a license.  The above copyright notice does not
// evidence any actual or intended publication of this material.
//
// Created:
// File: GlueServerConfig.java
//------------------------------------------------------------
// COPYRIGHT END

package com.ipeas.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ipeas.util.PropertyNotConfiguredException;


/**
 * This class is used to extract values of different configuration related
 * properties. Values are extracted from resources .properties which is placed
 * in src/main/resources folder.
 */

public class GlueServerConfig {

	private static final Logger LOG = LoggerFactory
			.getLogger(GlueServerConfig.class);

	public static final String CONFIG_FILE = "src/main/resources/resources.properties";
	
	private static String propertiesPath;
	public static String sendAlertRadioButton;
	public static String easCodesDropDown;
	public static String collectorUserNameTextBox;
	public static String collectorPasswordTextBox;
	public static String collectorLoginButton;
	public static String collectorFipsCodeRemoveButton;
	public static String collectorFipsPoolDropDown;
	public static String collectorAddFipsCodeButton;
	public static String collectorEasConfirmationButton;
	public static String collectorRunAlertButton;
	public static long pageTimeOut;
	public static String conopsUserNameTextBox;
	public static String conopsPasswordTextBox;
	public static String conopsLoginButton;
	public static String conopsMessageAfterLogin;
	public static String conopslogoTextafterLogin;
	public static String conopsUsername;
	public static String conopsPassword;
	public static String FailedTestsReport;
	public static String ViewEditFIPSCode;
	public static String GlueServerURLs;
	public static String MonitoringStatus;
	public static String SnapshotFileLocation;
	public static String conopsIpeasReport;
	public static String ipeasReportTable;
	public static String originatedAlertsRadioButton;
	public static String alertId;
	public static String alertInfoFile;
	public static String viewAllReportTable;
	public static String viewAllReportTableRows;
	public static String waitForTableLoad;
	public static String fipsCodeInMonitoring;
	public static String easCodeInMonitoring;
	public static String startDateInMonitoring;
	public static String toDateInMonitoring;
	public static String searchButtonInMonitoring;
	public static String enterFipsCode;
	public static String enterEasCode;
	public static String startDate;
	public static String endDate;
	public static String endDate2;
	public static String lastPage;
	public static String viewFailedTable;
	public static String viewFailedReportTableRows;
	public static String fipsCodeBoxInViewEditTab;
	public static String collectorUsername;
	public static String collectorPassword;
	public static String sendAlertRadioButtonName;
	public static String glueServerEast;
	public static String glueServerWest;
	public static String glueServerProcessedTab;
	public static String capFileTextBoxInGlueServerTab;
	public static String alertIDTextBoxInGlueServerTab;	
	public static String glueServerFailedAlertsTab;
	public static String glueServerStatusTab;
	public static String westServiceUrl;
    public static String eastServiceUrl;
    public static String deleteButtonInViewEditFipsCode;
    public static String addButtonInViewEditFipsCode;
    public static String editButtonInViewEditFipsCode;
    public static String deleteFipsCode;
    public static String selectRadioButtonInViewEditFipsCode;
    public static String alertPopUpDeleteButton;
    public static String recordNotFound;
    public static String addFipsCodeFromViewEdit;
    public static String addCountyNameFromViewEdit;
    public static String addMarketFromViewEdit;
    public static String alertPopUpSaveButton;
    public static String addFipsCode;
    public static String addCountyName;
    public static String addMarketName;

	public static String westAutomationAgent;
	public static String eastAutomationAgent;
	public static String westUrl;
	public static String eastUrl;

	public static String glueServerFailureTextBox;
	public static String failureTypeVpns;
	public static String failureTypeCDN;
	public static String failureTypeExpire;
	public static String capFileID;
	public static String glueServerVersionVpnsUrl;
	public static String glueServerVersionCDNUrl;
	public static String glueServerVersion;
	public static String monroeMenuTab;
	public static String originatedAlertRadioButtonName;
	public static String searchFieldBoxInSplunk;
	public static String searchButtonInSplunk;
	public static String splunkUrl;
	public static String splunkSearchtab;
	public static String splunkTableID;
	public static String selectTimeInSplunkDropDown;
	public static String selectTimeInSplunk1m;
	public static String splunkSkipTag;
	public static String splunkTable;
	public static String searchVPNSSnmp;
	public static String searchCDNSnmp;
	public static String searchJettySnmp;
	public static String searchMysqldSnmp;
	public static String searchPeerStopSnmp;
	public static String searchHttpdStopSnmp;
	public static String searchNtpdStopSnmp;
	public static String searchGlueServerNotRunningSnmp;
	public static String westServerStatusUrl;
	public static String eastServerStatusUrl;
	/**
	 * Method to process configuration properties file.
	 */
	public static void processConfig() {
		LOG.info("Loading Properties from {} ", propertiesPath);
		LOG.info("Opening configuration file ({})", propertiesPath);
		try {
			readPropertiesFile();

		} catch (Exception e) {
			LOG.error(
					"Monitoring system encountered an error while processing config file, Exiting",
					e);
		}
	}

	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static boolean readPropertiesFile() throws FileNotFoundException,
			IOException, PropertyNotConfiguredException {
		File file = new File(propertiesPath);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Properties prop = new Properties();
		prop.load(reader);
		
		sendAlertRadioButton = verifyAndFetchMandatoryProperty("sendAlertRadioButton", prop);
		easCodesDropDown = verifyAndFetchMandatoryProperty("easCodesDropDown", prop);
		collectorUserNameTextBox = verifyAndFetchMandatoryProperty("collectorUserNameTextBox", prop);
		collectorPasswordTextBox = verifyAndFetchMandatoryProperty("collectorPasswordTextBox", prop);
		collectorLoginButton = verifyAndFetchMandatoryProperty("collectorLoginButton", prop);
		collectorFipsCodeRemoveButton = verifyAndFetchMandatoryProperty("collectorFipsCodeRemoveButton", prop);
		collectorFipsPoolDropDown = verifyAndFetchMandatoryProperty("collectorFipsPoolDropDown", prop);
		collectorAddFipsCodeButton = verifyAndFetchMandatoryProperty("collectorAddFipsCodeButton", prop);
		collectorEasConfirmationButton = verifyAndFetchMandatoryProperty("collectorEasConfirmationButton", prop);
		collectorRunAlertButton = verifyAndFetchMandatoryProperty("collectorRunAlertButton", prop);
		pageTimeOut = Long.parseLong(verifyAndFetchMandatoryProperty("pageTimeOut", prop));
		conopsMessageAfterLogin=verifyAndFetchMandatoryProperty("conopsMessageAfterLogin", prop);
		conopsUserNameTextBox=verifyAndFetchMandatoryProperty("conopsUserNameTextBox", prop);
		conopsPasswordTextBox=verifyAndFetchMandatoryProperty("conopsPasswordTextBox", prop);
		conopsLoginButton=verifyAndFetchMandatoryProperty("conopsLoginButton", prop);
		conopsUsername=verifyAndFetchMandatoryProperty("conopsUsername", prop);
		conopsPassword=verifyAndFetchMandatoryProperty("conopsPassword", prop);
		conopsPasswordTextBox=verifyAndFetchMandatoryProperty("conopsPasswordTextBox", prop);
		FailedTestsReport=verifyAndFetchMandatoryProperty("FailedTestsReport", prop);
		ViewEditFIPSCode=verifyAndFetchMandatoryProperty("ViewEditFIPSCode", prop);
		GlueServerURLs=verifyAndFetchMandatoryProperty("GlueServerURLs", prop);
		SnapshotFileLocation = verifyAndFetchMandatoryProperty("SnapshotFileLocation", prop);
		conopsIpeasReport= verifyAndFetchMandatoryProperty("conopsIpeasReport", prop);
		ipeasReportTable = verifyAndFetchMandatoryProperty("ipeasReportTable", prop);
		MonitoringStatus = verifyAndFetchMandatoryProperty("MonitoringStatus", prop);


		originatedAlertsRadioButton = verifyAndFetchMandatoryProperty("originatedAlertsRadioButton", prop);
		alertId = verifyAndFetchMandatoryProperty("alertId", prop);
		alertInfoFile = verifyAndFetchMandatoryProperty("alertInfoFile", prop);
		viewAllReportTable = verifyAndFetchMandatoryProperty("viewAllReportTable", prop);
		viewAllReportTableRows = verifyAndFetchMandatoryProperty("viewAllReportTableRows", prop);
		waitForTableLoad=verifyAndFetchMandatoryProperty("waitForTableLoad", prop);
		fipsCodeInMonitoring=verifyAndFetchMandatoryProperty("fipsCodeInMonitoring", prop);
		easCodeInMonitoring=verifyAndFetchMandatoryProperty("easCodeInMonitoring", prop);
		startDateInMonitoring=verifyAndFetchMandatoryProperty("startDateInMonitoring", prop);
		searchButtonInMonitoring=verifyAndFetchMandatoryProperty("searchButtonInMonitoring", prop);
		toDateInMonitoring=verifyAndFetchMandatoryProperty("toDateInMonitoring", prop);
		enterFipsCode=verifyAndFetchMandatoryProperty("enterFipsCode", prop);
		enterEasCode=verifyAndFetchMandatoryProperty("enterEasCode", prop);
		startDate=verifyAndFetchMandatoryProperty("startDate", prop);
		endDate=verifyAndFetchMandatoryProperty("endDate", prop);
		endDate2=verifyAndFetchMandatoryProperty("endDate2", prop);
		lastPage=verifyAndFetchMandatoryProperty("lastPage", prop);
		viewFailedTable=verifyAndFetchMandatoryProperty("viewFailedTable", prop);
		viewFailedReportTableRows=verifyAndFetchMandatoryProperty("viewFailedReportTableRows", prop);
		fipsCodeBoxInViewEditTab=verifyAndFetchMandatoryProperty("fipsCodeBoxInViewEditTab", prop);
		collectorUsername=verifyAndFetchMandatoryProperty("collectorUsername", prop);
		collectorPassword=verifyAndFetchMandatoryProperty("collectorPassword", prop);
		sendAlertRadioButtonName = verifyAndFetchMandatoryProperty("sendAlertRadioButtonName", prop);
		glueServerEast = verifyAndFetchMandatoryProperty("glueServerEast", prop);
		glueServerWest = verifyAndFetchMandatoryProperty("glueServerWest", prop);
		glueServerProcessedTab = verifyAndFetchMandatoryProperty("glueServerProcessedTab", prop);
		glueServerFailedAlertsTab = verifyAndFetchMandatoryProperty("glueServerFailedAlertsTab", prop);
		glueServerStatusTab = verifyAndFetchMandatoryProperty("glueServerStatusTab", prop);
		alertIDTextBoxInGlueServerTab =verifyAndFetchMandatoryProperty("alertIDTextBoxInGlueServerTab", prop);
		capFileTextBoxInGlueServerTab=verifyAndFetchMandatoryProperty("capFileTextBoxInGlueServerTab", prop);
		westServiceUrl = verifyAndFetchMandatoryProperty("westServiceUrl", prop);
        eastServiceUrl = verifyAndFetchMandatoryProperty("eastServiceUrl", prop);
        westUrl = verifyAndFetchMandatoryProperty("westUrl", prop);
        eastUrl = verifyAndFetchMandatoryProperty("eastUrl", prop);
        deleteButtonInViewEditFipsCode = verifyAndFetchMandatoryProperty("deleteButtonInViewEditFipsCode", prop);
        addButtonInViewEditFipsCode = verifyAndFetchMandatoryProperty("addButtonInViewEditFipsCode", prop);
        editButtonInViewEditFipsCode = verifyAndFetchMandatoryProperty("editButtonInViewEditFipsCode", prop);
        selectRadioButtonInViewEditFipsCode = verifyAndFetchMandatoryProperty("selectRadioButtonInViewEditFipsCode", prop);
        alertPopUpDeleteButton = verifyAndFetchMandatoryProperty("alertPopUpDeleteButton", prop);
        deleteFipsCode = verifyAndFetchMandatoryProperty("deleteFipsCode", prop);
        recordNotFound=verifyAndFetchMandatoryProperty("recordNotFound", prop);
        addFipsCodeFromViewEdit = verifyAndFetchMandatoryProperty("addFipsCodeFromViewEdit", prop);
        addCountyNameFromViewEdit = verifyAndFetchMandatoryProperty("addCountyNameFromViewEdit", prop);
        addMarketFromViewEdit = verifyAndFetchMandatoryProperty("addMarketFromViewEdit", prop);
        addFipsCode = verifyAndFetchMandatoryProperty("addFipsCode", prop);
        addCountyName = verifyAndFetchMandatoryProperty("addCountyName", prop);
        addMarketName = verifyAndFetchMandatoryProperty("addMarketName", prop);
        alertPopUpSaveButton =verifyAndFetchMandatoryProperty("alertPopUpSaveButton", prop);        
		westAutomationAgent = verifyAndFetchMandatoryProperty("westAutomationAgent", prop);
		eastAutomationAgent = verifyAndFetchMandatoryProperty("eastAutomationAgent", prop);
		glueServerFailureTextBox =verifyAndFetchMandatoryProperty("glueServerFailureTextBox", prop);
		failureTypeVpns=verifyAndFetchMandatoryProperty("failureTypeVpns", prop);
		failureTypeCDN=verifyAndFetchMandatoryProperty("failureTypeCDN", prop);
		failureTypeExpire=verifyAndFetchMandatoryProperty("failureTypeExpire", prop);
		capFileID=verifyAndFetchMandatoryProperty("capFileID", prop);
		glueServerVersion=verifyAndFetchMandatoryProperty("glueServerVersion", prop);
		glueServerVersionVpnsUrl=verifyAndFetchMandatoryProperty("glueServerVersionVpnsUrl", prop);
		glueServerVersionCDNUrl=verifyAndFetchMandatoryProperty("glueServerVersionCDNUrl", prop);
		monroeMenuTab = verifyAndFetchMandatoryProperty("monroeMenuTab", prop);
		originatedAlertRadioButtonName = verifyAndFetchMandatoryProperty("originatedAlertRadioButtonName", prop);
		searchFieldBoxInSplunk = verifyAndFetchMandatoryProperty("searchFieldBoxInSplunk", prop);
		searchButtonInSplunk = verifyAndFetchMandatoryProperty("searchButtonInSplunk", prop);
		splunkUrl = verifyAndFetchMandatoryProperty("splunkUrl", prop);
		splunkSearchtab = verifyAndFetchMandatoryProperty("splunkSearchtab", prop);
		selectTimeInSplunkDropDown = verifyAndFetchMandatoryProperty("selectTimeInSplunkDropDown", prop);
		selectTimeInSplunk1m=verifyAndFetchMandatoryProperty("selectTimeInSplunk1m", prop);
		splunkTableID= verifyAndFetchMandatoryProperty("splunkTableID", prop);
		splunkSkipTag=verifyAndFetchMandatoryProperty("splunkSkipTag", prop);
		splunkTable = verifyAndFetchMandatoryProperty("splunkTable", prop);
		searchVPNSSnmp = verifyAndFetchMandatoryProperty("searchVPNSSnmp", prop);
		searchCDNSnmp = verifyAndFetchMandatoryProperty("searchCDNSnmp", prop);
		searchJettySnmp = verifyAndFetchMandatoryProperty("searchJettySnmp", prop);
		searchMysqldSnmp=verifyAndFetchMandatoryProperty("searchMysqldSnmp", prop);
		searchPeerStopSnmp= verifyAndFetchMandatoryProperty("searchPeerStopSnmp", prop);
		searchHttpdStopSnmp=verifyAndFetchMandatoryProperty("searchHttpdStopSnmp", prop);
		searchNtpdStopSnmp = verifyAndFetchMandatoryProperty("searchNtpdStopSnmp", prop);
		searchGlueServerNotRunningSnmp = verifyAndFetchMandatoryProperty("searchGlueServerNotRunningSnmp", prop);
		westServerStatusUrl = verifyAndFetchMandatoryProperty("westServerStatusUrl", prop);
		eastServerStatusUrl = verifyAndFetchMandatoryProperty("eastServerStatusUrl", prop);
		reader.close();
		LOG.info("Checking for valid configuration settings");
		return true;
	}

	public static void setPropertiesPath() {
		propertiesPath = System.getProperty("resources.properties");
		if (propertiesPath == null || propertiesPath.isEmpty()) {
			propertiesPath = CONFIG_FILE;
		}
	}

	/**
	 * Method to verify and fetch the mandatory properties for glue server. If
	 * the mandatory property is not set in the properties file this method
	 * throws a custom NullPointerException. If the property is left blank then
	 * this method throws a PropertyNotConfiguredException.
	 * 
	 * @see com.twc.glueserver.utils.PropertyNotConfiguredException
	 * 
	 * @param key
	 * @param prop
	 * @return
	 * @throws PropertyNotConfiguredException
	 */
	public static String verifyAndFetchMandatoryProperty(String key,
			Properties prop) throws PropertyNotConfiguredException {
		String property;
		// Mandatory property should not be null.
		property = Objects.requireNonNull(fetchProperty(key, prop),
				"ERROR: Must set configuration value for " + key);

		// Mandatory property should not be blank.

		if (property.isEmpty()) {
			throw new PropertyNotConfiguredException(
					"ERROR: Must set configuration value for " + key);
		}
		return property;
	}

	public static String fetchProperty(String key, Properties prop) {
		return prop.getProperty(key);
	}

	/**
	 * Method to verify and fetch the optional properties for glue server. If
	 * the property is blank or is not set in the glueserver.properties it
	 * returns the default value.
	 * 
	 * @param key
	 * @param defaultValue
	 * @param prop
	 * @return
	 */
	public static String verifyAndFetchOptionalProperty(String key,
			String defaultValue, Properties prop) {
		String property;
		property = fetchProperty(key, prop);

		// Property should not be blank.
		if (property == null || (property != null && property.trim().isEmpty())) {
			return defaultValue;
		}
		return property;
	}

	/**
	 * Method overload of verifyAndFetchOptionalProperty method.
	 */
	public static int verifyAndFetchOptionalProperty(String key,
			int defaultValue, Properties prop) {
		String property;
		property = fetchProperty(key, prop);

		// Property should not be blank.
		if (property == null || (property != null && property.trim().isEmpty())) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(property);
		} catch (NumberFormatException numEx) {
			return defaultValue;
		}
	}

	/**
	 * Method overload of verifyAndFetchOptionalProperty method.
	 */
	public static boolean verifyAndFetchOptionalProperty(String key,
			boolean defaultValue, Properties prop) {
		String property;
		property = fetchProperty(key, prop);

		// Property should not be blank.
		if (property == null || (property != null && property.trim().isEmpty())) {
			return defaultValue;
		}
		return Boolean.parseBoolean(property);
	}

}
