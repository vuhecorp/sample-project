package com.hersa.sample.project.dao.setting;

import java.util.Date;

public class Setting {
	private long id;
	private long settingId;
	private String clientId;
	private String value;
	private boolean active;
	private int displayOrder;
	private Date modifiedOn;
	private String labelOverride;
	private String allowedOverride;
	public Setting() {
		
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	public boolean getBooleanValue() {
		return Boolean.parseBoolean(value);
		
	}
	public String getAllowedOverride() {
		return allowedOverride;
	}
	public void setAllowedOverride(String allowedOverride) {
		this.allowedOverride = allowedOverride;
	}
}
