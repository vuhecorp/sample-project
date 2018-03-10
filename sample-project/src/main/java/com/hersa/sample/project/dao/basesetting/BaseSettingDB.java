package com.hersa.sample.project.dao.basesetting;

public class BaseSettingDB {
	
	//table name
	public static final String BASESETTING = "basesetting";
	
	//columns
	public static final String ID = "id";
	public static final String BASE_SETTING_TYPE_ID = "basesettingtypeid";
	public static final String NAME = "name";
	public static final String LABEL = "label";
	public static final String DESCRIPTION = "description";
	public static final String CATEGORY = "category";
	public static final String PERMISSION = "permission";
	public static final String DATATYPE = "datatype";
	public static final String ALLOWEDVALUES = "allowedvalues";
	
	//statements
	public static final String SELECT_SETTING = "SELECT "
									+ ID
									+ ", "
									+ BASE_SETTING_TYPE_ID
									+ ", "
									+ NAME
									+ ", "
									+ LABEL
									+ ", "
									+ DESCRIPTION
									+ ", "
									+ CATEGORY
									+ ", "
									+ DATATYPE
									+ ", "
									+ ALLOWEDVALUES
									+ " FROM " + BASESETTING;
}
