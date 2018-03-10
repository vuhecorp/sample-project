package com.hersa.sample.project.dao.clientsettingsview;

import java.util.Date;

public class ClientSettingsView {
	
	private long clientSettingId;
	private long settingId;
	private String clientId;
	private String value;
	private boolean active;
	private int displayOrder;
	private Date modifiedOn;
	private String labelOverride;
	private String name;
	private String label;
	private String description;
	private long category;
	private long permission;
	
	public ClientSettingsView() {
		
	}
	
	public long getClientSettingId() {
		return clientSettingId;
	}
	public void setClientSettingId(long clientSettingId) {
		this.clientSettingId = clientSettingId;
	}
	public long getSettingId() {
		return settingId;
	}
	public void setSettingId(long settingId) {
		this.settingId = settingId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getLabelOverride() {
		return labelOverride;
	}
	public void setLabelOverride(String labelOverride) {
		this.labelOverride = labelOverride;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getCategory() {
		return category;
	}
	public void setCategory(long category) {
		this.category = category;
	}
	public long getPermission() {
		return permission;
	}
	public void setPermission(long permission) {
		this.permission = permission;
	}
}
