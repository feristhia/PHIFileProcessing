package com.phiintegration.textfiles;

import com.phiintegration.meta.base.PHIFieldValue;
import com.phiintegration.meta.base.PHIHeaderWithSeparator;
import com.phiintegration.meta.base.PHIRecord;
import com.phiintegration.phienum.PHIReadTextResult;
import com.phiintegration.phiexception.ColumnIndexOrNameNotFoundException;

public class PHICSVDetailRowText {
	/*
	String[] teks = null;
	Integer tekslen = null;
	PHIRecord phiRecord = new PHIRecord();
	PHIHeaderWithSeparator header = null;
	
	public PHICSVDetailRowText(PHIHeaderWithSeparator header)
	{
		this.header = header;
	}
	
	public PHIReadTextResult buildHeader(String text, String sep) 
	{
		teks = text.split(sep);
		teks = null;
		teks = text.split(sep);
		
		if(teks == null)
			return PHIReadTextResult.NULL;
		else if(teks.length==0)
			return PHIReadTextResult.Empty;
		else if(teks.length!=header.getNumOfColumns())
			return PHIReadTextResult.LengthIsDifferent;
		
		StringBuilder strHeaderTemp = new StringBuilder();
		strHeaderTemp.append("");
		for(int i=0; i<teks.length;i++)
		{
			strHeaderTemp.append("kolom");
			strHeaderTemp.append(i+1);
			if(i<teks.length-1)
				strHeaderTemp.append(sep);
		}
		return PHIReadTextResult.Success;
	}
	
	public PHIReadTextResult proses(String text, String sep) throws ColumnIndexOrNameNotFoundException {
		for(int i=0; i<header.getNumOfColumns();i++)
		{
			//System.out.print(i+1);
			//System.out.println(header.getIndex(i+1));
		}
		teks = null;
		//Penambahan spasi agar bisa displit dengan jumlah yang benar
		teks = (text + " ").split(sep);
		tekslen = teks.length; //penting, tidak boleh dihapus
		
		//Normalisasi kembali
		String s = teks[tekslen-1];
		teks[tekslen-1] = s.substring(0, s.length() - 1);
		
		if(teks == null)
			return PHIReadTextResult.NULL;
		else if(tekslen==0)
			return PHIReadTextResult.Empty;
		
		for(int i=0; i<header.getNumOfColumns();i++)
		{
			PHIFieldValue fld = new PHIFieldValue();
			fld.setFieldName(header.getIndex(i+1));
			if(i+1<=tekslen)
				fld.setFieldValue(teks[i]);
			else
				fld.setFieldValue("");
			
			phiRecord.add(fld);
		}
		
		if(tekslen!=header.getNumOfColumns())
			return PHIReadTextResult.LengthIsDifferent;
		else
			return PHIReadTextResult.Success;
	}
	
	public String get(Integer idx) throws ColumnIndexOrNameNotFoundException
	{
		if(idx>=0 && idx < tekslen)
		{
			return phiRecord.getPhiFields().get(header.getIndex(idx+1)).getFieldValue();			
		}
		return null;
	}
	
	public String getTrim(Integer idx) throws ColumnIndexOrNameNotFoundException
	{
		if(idx>=0 && idx < tekslen)
		{
			return phiRecord.getPhiFields().get(header.getIndex(idx+1)).getFieldValue().trim();			
		}
		return null;
	}

	public String get(String fieldName) throws ColumnIndexOrNameNotFoundException
	{
		return phiRecord.getPhiFields().get(fieldName).getFieldValue();			
	}
	
	public String getTrim(String fieldName) throws ColumnIndexOrNameNotFoundException
	{
		return phiRecord.getPhiFields().get(fieldName).getFieldValue().trim();			
	}
	*/
}
