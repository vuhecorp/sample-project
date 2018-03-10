package com.hersa.sample.project.dao.setting;

public class SettingDB {

	//table name
	public static final String SETTING = "setting";
	
	//column names
	public static final String ID = "id";
	public static final String SETTING_ID = "settingid";
	public static final String CLIENT_ID = "clientid";
	public static final String VALUE = "value";
	public static final String ACTIVE = "active";
	public static final String DISPLAY_ORDER = "displayorder";
	public static final String MODIFIED_ON = "modifiedon";
	public static final String LABEL_OVERRIDE = "labeloverride";
	public static final String ALLOWED_OVERRIDE = "allowedoverride";
	
	
	//statements
	public static final String SELECT_ADMINSETTING = " SELECT "
													+ ID
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
													+ ALLOWED_OVERRIDE
													+ " FROM " + SETTING;
}
