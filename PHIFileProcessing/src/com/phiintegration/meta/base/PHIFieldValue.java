package com.phiintegration.meta.base;

import com.phiintegration.latest.IPHIFieldValue;

public class PHIFieldValue implements Cloneable, IPHIFieldValue {
	private String fieldName;
	private String fieldValue;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
}
