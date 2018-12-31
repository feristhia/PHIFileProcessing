package com.phiintegration.latest;

import com.phiintegration.meta.base.PHIFieldValue;

public interface IPHIFieldMatching extends IPHIFieldValue {
	public Boolean getIsKey();
	public void setIsKey(Boolean isKey);

	public Boolean getIsStored();

	public void setIsStored(Boolean isStored);

	public Boolean getIsBlock();

	public void setIsBlock(Boolean isBlock);
	
	public Boolean getIsMatchingField();

	public void setIsMatchingField(Boolean isMatchingField);

	public Boolean getIsNonRepeatable();
	public void setIsNonRepeatable(Boolean isNonRepeatable);
 
	public PHIFieldValue clone() throws CloneNotSupportedException;
}
