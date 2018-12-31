package com.phiintegration.meta.base;

import java.util.HashMap;

import com.phiintegration.phienum.PHINormalizeColumnNameEnum;
import com.phiintegration.phiexception.NormalizerNotDefined;

public class PHIRecord {
	
	PHINameIndexPair fields = null;
	HashMap<String, String> fieldValue = null;
	
	protected PHIFieldValue originalValues;
	
	public PHIRecord(PHINormalizeColumnNameEnum phiNormalizeEnum) throws NormalizerNotDefined {
		fields = new PHINameIndexPair(phiNormalizeEnum);
	}

	public void newRecord()
	{
		fieldValue = new HashMap<String, String>();
	}

	public void addValue(String key, String value)
	{
		fieldValue.put(key, value);
	}
	
	public String getVal(String key)
	{
		return fieldValue.get(key);
	}
}
