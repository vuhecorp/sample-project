package com.hersa.sample.project.dao.basesetting;

public class BaseSetting {
	
	private long id;
	private long baseSettingTypeId;
	private String name;
	private String label;
	private String description;
	private long category;
	private String dataType;
	private String allowedValues;
	
	public BaseSetting() {
		
	}	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getAllowedValues() {
		return allowedValues;
	}

	public void setAllowedValues(String allowedValues) {
		this.allowedValues = allowedValues;
	}

	public long getBaseSettingTypeId() {
		return baseSettingTypeId;
	}

	public void setBaseSettingTypeId(long baseSettingTypeId) {
		this.baseSettingTypeId = baseSettingTypeId;
	}
}
