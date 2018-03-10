package com.hersa.sample.project.dao.permissionview;

public class PermissionViewDB {
	
	//table name
	public static final String PERMISSION_VIEW = "permissionview";
	
	//column names
	public static final String ROLE_ID = "roleid";
	public static final String PERMISSION_NAME = "permissionname";
	public static final String RESOURCE_NAME = "resourcename";
	public static final String RESOURCE_TYPE = "resourcetype";
	public static final String ADMIN_RESOURCE = "adminresource";
	public static final String ALLOWED = "allowed";
	public static final String DESCRIPTION = "description";
	
	//statements
	public static final String SELECT_PERMISSION_VIEW =  "SELECT "
														+ ROLE_ID
														+ ", "
														+ PERMISSION_NAME
														+ ", "
														+ RESOURCE_NAME
														+ ", "
														+ RESOURCE_TYPE
														+ ", "
														+ ADMIN_RESOURCE
														+ ", "
														+ ALLOWED
														+ ", "
														+ DESCRIPTION
														+ " FROM " + PERMISSION_VIEW;
}
