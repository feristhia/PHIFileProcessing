package com.phiintegration.meta.base;

import java.util.HashMap;

import com.phiintegration.phienum.PHINormalizeColumnNameEnum;
import com.phiintegration.phiexception.ColumnIndexOrNameNotFoundException;
import com.phiintegration.phiexception.DuplicateColumnCustomIndexException;
import com.phiintegration.phiexception.DuplicateColumnNameException;
import com.phiintegration.phiexception.NormalizerNotDefined;
import com.phiintegration.phiexception.NormalizerNotImplementedException;

public final class PHINameIndexPair {
	HashMap<Integer, Integer>	colIndexMappingOriToPos		= null;
	HashMap<Integer, Integer>	colIndexMappingPosToOri		= null;
	
	HashMap<String, Integer> 	colStringToIndex	= null;
	HashMap<Integer, String> 	colIndexToString	= null;
	
	HashMap<String, String> 	colStringToOriginal	= null;
	HashMap<String, String> 	colOriginalToString	= null;
	
	PHINormalizeColumnName		phiNormalize = new PHINormalizeColumnName();
	PHINormalizeColumnNameEnum	phiNormalizeEnum = null;
	
	public PHINameIndexPair(PHINormalizeColumnNameEnum	phiNormalizeEnum) throws NormalizerNotDefined
	{
		if(phiNormalizeEnum == null)
		{
			throw new NormalizerNotDefined(
					"Normalizer must be defined!");			
		}
		this.phiNormalizeEnum = phiNormalizeEnum;
	}
	
	public String getNameByIndex(Integer position) throws ColumnIndexOrNameNotFoundException
	{
		if(position <= 0)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index tidak boleh lebih kecil dari 1!");
		else if(position > colStringToIndex.size())
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index tidak boleh lebih besar dari jumlah kolom!");
		return colIndexToString.get(position);
	}
	
	public String getNameByCustomIndex(Integer customIndex) throws ColumnIndexOrNameNotFoundException
	{
		if(colIndexMappingPosToOri.get(customIndex) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index tidak ditemukan!");
		return colIndexToString.get(colIndexMappingPosToOri.get(customIndex));
	}
	
	public String getNameByOriginalFieldName(String originalName) throws ColumnIndexOrNameNotFoundException
	{
		if(colOriginalToString.get(originalName) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom " + originalName + " tidak ditemukan!");
		return colOriginalToString.get(originalName);
	}

	public String getOriginalNameByIndex(Integer posisi) throws ColumnIndexOrNameNotFoundException
	{
		if(colStringToOriginal.get(getNameByIndex(posisi)) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom dengan index " + posisi + " tidak ditemukan!");
		return colStringToOriginal.get(getNameByIndex(posisi));
	}

	public String getOriginalNameByCustomIndex(Integer customIndex) throws ColumnIndexOrNameNotFoundException
	{
		if(colStringToOriginal.get(getNameByCustomIndex(customIndex)) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index tidak ditemukan!");
		return colStringToOriginal.get(getNameByCustomIndex(customIndex));
	}
	
	public String getOriginalNameByFieldName(String fieldName) throws ColumnIndexOrNameNotFoundException
	{
		String fldName = fieldName.trim();
		if(colStringToOriginal.get(fieldName) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Nama " + fieldName.trim() + " tidak ditemukan!");
		return colStringToOriginal.get(fldName);
	}

	
	public Integer getIndexByFieldName(String fieldName) throws ColumnIndexOrNameNotFoundException
	{
		String fldName = fieldName.trim();
		if(colStringToIndex.get(fldName) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Nama " + fldName + " tidak ditemukan!");
		return colStringToIndex.get(fldName);
	}
	
	public Integer getIndexByOriginalFieldName(String originalName) throws ColumnIndexOrNameNotFoundException
	{
		if(colStringToIndex.get(colOriginalToString.get(originalName)) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom nama " + originalName + " tidak ditemukan!");
		return colStringToIndex.get(colOriginalToString.get(originalName));
	}

	public Integer getIndexByCustomIndex(Integer customIndex) throws ColumnIndexOrNameNotFoundException
	{
		if(colIndexMappingPosToOri.get(customIndex) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index " + customIndex + " tidak ditemukan!");
		return colIndexMappingPosToOri.get(customIndex);
	}
	
	public Integer getCustomIndexByIndex(Integer index) throws ColumnIndexOrNameNotFoundException
	{
		if(colIndexMappingOriToPos.get(index) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index " + index + " tidak ditemukan!");
		return colIndexMappingOriToPos.get(index);
	}
	
	public Integer getCustomIndexByOriginalFieldName(String originalName) throws ColumnIndexOrNameNotFoundException
	{
		if(colIndexMappingOriToPos.get(colStringToIndex.get(colOriginalToString.get(originalName))) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom nama " + originalName + " tidak ditemukan!");
		return colIndexMappingOriToPos.get(colStringToIndex.get(colOriginalToString.get(originalName)));
	}
	
	public Integer getCustomIndexByFieldName(String fieldName) throws ColumnIndexOrNameNotFoundException
	{
		if(colIndexMappingOriToPos.get(colStringToIndex.get(fieldName)) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Nama " + fieldName + " tidak ditemukan!");
		return colIndexMappingOriToPos.get(colStringToIndex.get(fieldName));
	}
	
	public Integer numOfColumns()
	{
		return colStringToIndex.size();
	}
	
	public void add(String fieldName, Integer customIndex) throws DuplicateColumnNameException, DuplicateColumnCustomIndexException, NormalizerNotDefined, NormalizerNotImplementedException
	{
		if(phiNormalizeEnum==null)
			throw new NormalizerNotDefined(
					"Normalizer is not defined!");
			
		String newFieldName = phiNormalize.normalize(fieldName, phiNormalizeEnum);
		
		if(colStringToIndex==null)
		{
			reset();
		}
		
		if(colStringToIndex.get(newFieldName)!=null)
			throw new DuplicateColumnNameException(
					"Field " + newFieldName + " ditemukan sebagai duplikat!");
		if(colIndexMappingPosToOri.get(customIndex)!=null)
			throw new DuplicateColumnCustomIndexException (
					"Index " + customIndex + " ditemukan sebagai duplikat!");
		if(colIndexMappingPosToOri.get(fieldName)!=null)
			throw new DuplicateColumnCustomIndexException (
					"Field " + fieldName + " ditemukan sebagai duplikat!");
		
		colStringToIndex.put(newFieldName, colStringToIndex.size()+1);
		colIndexToString.put(colIndexToString.size()+1, newFieldName);
		
		colIndexMappingOriToPos.put(colIndexMappingOriToPos.size()+1, customIndex);
		colIndexMappingPosToOri.put(customIndex, colIndexMappingPosToOri.size()+1);
	
		colStringToOriginal.put(newFieldName, fieldName);
		colOriginalToString.put(fieldName, newFieldName);
	}
	
	public void reset()
	{
		colIndexMappingOriToPos 	= new HashMap<Integer, Integer >();
		colIndexMappingPosToOri 	= new HashMap<Integer, Integer >();
		colIndexToString 			= new HashMap<Integer, String>();
		colStringToIndex			= new HashMap<String, Integer>();
		colStringToOriginal			= new HashMap<String, String>();
		colOriginalToString			= new HashMap<String, String>();		
	}
}
