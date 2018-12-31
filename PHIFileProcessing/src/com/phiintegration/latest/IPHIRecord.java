package com.phiintegration.latest;

import java.util.HashMap;

public interface IPHIRecord {
	
	public Integer getHeader();

	public String getFieldName(Integer indexPos);
	public Integer getFieldPosition(String fieldName);
	
	public String getString(Integer fieldPosition);
	public String getString(String fieldName);

	public void add(IPHIFieldValue phifield);
	
	public HashMap<String, IPHIFieldValue> getPhiFields();
}
