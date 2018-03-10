package com.hersa.sample.project.dao.permissionview;

public class PermissionView {

	private long roleId;
	private String permissionName;
	private String resourceName;
	private String resourceType;
	private boolean adminResource;
	private boolean allowed;
	private String description;
	
	public PermissionView() {
		
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public boolean isAdminResource() {
		return adminResource;
	}

	public void setAdminResource(boolean adminResource) {
		this.adminResource = adminResource;
	}

	public boolean isAllowed() {
		return allowed;
	}

	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
