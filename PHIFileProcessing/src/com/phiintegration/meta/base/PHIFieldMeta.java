package com.phiintegration.meta.base;

import com.phiintegration.phienum.PHIMetaDataType;

public class PHIFieldMeta {
	
	String name = null;
	
	PHIMetaDataType dataType = null;
	Integer length = null; //Total length of data type
	Integer precision = null; //Total number of digits (1234.56 has a precision of 6)
	Integer scale = null; //Number of digits in fraction part (1234.56 has a scale of 2)
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PHIMetaDataType getDataType() {
		return dataType;
	}

	public void setDataType(PHIMetaDataType dataType) {
		this.dataType = dataType;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getPrecision() {
		return precision;
	}

	public void setPrecision(Integer precision) {
		this.precision = precision;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}
}
