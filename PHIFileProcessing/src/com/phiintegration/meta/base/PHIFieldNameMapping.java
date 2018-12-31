package com.phiintegration.meta.base;

import java.util.HashMap;

import com.phiintegration.phiexception.ColumnIndexOrNameNotFoundException;

public class PHIFieldNameMapping {
	HashMap<Integer, Integer> colAdditionalIndex = null;
	
	HashMap<String, Integer> colAdditionalIndexOri = null;
	HashMap<String, Integer> colAdditionalIndexUpp = null;
	HashMap<String, Integer> colAdditionalIndexLow = null;

	HashMap<String, Integer> col1NamesOri = null;
	HashMap<String, Integer> col1NamesUpp = null;
	HashMap<String, Integer> col1NamesLow = null;
	
	HashMap<Integer, String> col2NamesOri = null;
	HashMap<Integer, String> col2NamesUpp = null;
	HashMap<Integer, String> col2NamesLow = null;
	
	public void reset()
	{
		col1NamesOri = null;
		col1NamesUpp = null;
		col1NamesLow = null;
		
		col2NamesOri = null;
		col2NamesUpp = null;
		col2NamesLow = null;		
	}
	
	public void add(String fieldName, Integer AdditionalPositionIndex)
	{
		if(col1NamesOri==null)
		{
			col1NamesOri 	= new HashMap<String, Integer>();
			col1NamesUpp 	= new HashMap<String, Integer>();
			col1NamesLow 	= new HashMap<String, Integer>();
			col2NamesOri 	= new HashMap<Integer, String>();
			col2NamesUpp 	= new HashMap<Integer, String>();
			col2NamesLow 	= new HashMap<Integer, String>();
		}
		String fldName = fieldName.trim();
		col1NamesOri.put(fldName, col1NamesOri.size()+1);
		col1NamesUpp.put(fldName.toUpperCase(), col1NamesUpp.size()+1);
		col1NamesLow.put(fldName.toLowerCase(), col1NamesLow.size()+1);
		col2NamesOri.put(col2NamesOri.size()+1, fldName);
		col2NamesUpp.put(col2NamesUpp.size()+1, fldName.toUpperCase());
		col2NamesLow.put(col2NamesLow.size()+1, fldName.toLowerCase());
	}
	
	public String getNameOriginal(Integer position) throws ColumnIndexOrNameNotFoundException
	{
		if(position <= 0)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index tidak boleh lebih kecil dari 1!");
		else if(position > col2NamesOri.size())
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index tidak boleh lebih besar dari jumlah kolom!");
		return col2NamesOri.get(position);
	}
	
	public String getNameUpperCase(Integer position) throws ColumnIndexOrNameNotFoundException
	{
		if(position <= 0)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index tidak boleh lebih kecil dari 1!");
		else if(position > col2NamesUpp.size())
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index tidak boleh lebih besar dari jumlah kolom!");
		return col2NamesUpp.get(position);
	}

	public String getNameLowerCase(Integer position) throws ColumnIndexOrNameNotFoundException
	{
		if(position <= 0)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index tidak boleh lebih kecil dari 1!");
		else if(position > col2NamesLow.size())
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index tidak boleh lebih besar dari jumlah kolom!");
		return col2NamesLow.get(position);
	}
	
	public Integer getIndexByOriginal(String fieldName) throws ColumnIndexOrNameNotFoundException
	{
		String fldName = fieldName.trim();
		if(col1NamesOri.get(fieldName) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Nama " + fieldName.trim() + " tidak ada!");
		return col1NamesOri.get(fldName);
	}
	
	
	public Integer getIndexByUpper(String fieldName) throws ColumnIndexOrNameNotFoundException
	{
		String fldName = fieldName.trim();
		if(col1NamesUpp.get(fieldName) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Nama " + fieldName.trim() + " tidak ada!");
		return col1NamesUpp.get(fldName);
	}
	
	public Integer getIndexByLower(String fieldName) throws ColumnIndexOrNameNotFoundException
	{
		String fldName = fieldName.trim();
		if(col1NamesLow.get(fieldName) == null)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Nama " + fieldName.trim() + " tidak ada!");
		return col1NamesLow.get(fldName);
	}
	
	public int numOfColumns()
	{
		return col1NamesOri.size();
	}
}
