package com.hersa.sample.project.dao.clientsettingsview;

public class ClientSettingsViewDB {
	//table name
	public static final String CLIENTSETTINGVIEW = "clientsettingsview";
	
	//columns
	public static final String CLIENT_SETTING_ID = "clientsettingid";
	public static final String SETTING_ID = "settingid";
	public static final String CLIENT_ID = "clientid";
	public static final String VALUE = "value";
	public static final String ACTIVE = "active";
	public static final String DISPLAY_ORDER = "displayorder";
	public static final String MODIFIED_ON = "modifiedon";
	public static final String LABEL_OVERRIDE = "labeloverride";
	public static final String NAME = "name";
	public static final String LABEL = "label";
	public static final String DESCRIPTION = "description";
	public static final String CATEGORY = "category";
	public static final String PERMISSION = "permission";
	
	//satements
	public static final String SELECT_CLIENTSETTINGVIEW = "SELECT "
											+ CLIENT_SETTING_ID											
											+ ", "
											+ SETTING_ID
											+ ", "
											+ CLIENT_ID
											+ ", "
											+ VALUE
											+ ", "
											+ ACTIVE
											+ ", "
											+ DISPLAY_ORDER
											+ ", "
											+ MODIFIED_ON
											+ ", "
											+ LABEL_OVERRIDE
											+ ", "
											+ NAME
											+ ", "
											+ LABEL
											+ ", "
											+ DESCRIPTION
											+ ", "
											+ CATEGORY
											+ ", "
											+ PERMISSION 
											+ " FROM " + CLIENTSETTINGVIEW;
											
											
}
