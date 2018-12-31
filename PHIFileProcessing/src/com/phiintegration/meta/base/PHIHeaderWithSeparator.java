package com.phiintegration.meta.base;

import com.phiintegration.phienum.PHINormalizeColumnNameEnum;
import com.phiintegration.phiexception.ColumnIndexOrNameNotFoundException;
import com.phiintegration.phiexception.DuplicateColumnCustomIndexException;
import com.phiintegration.phiexception.DuplicateColumnNameException;
import com.phiintegration.phiexception.EmptyColumnNameException;
import com.phiintegration.phiexception.NormalizerNotDefined;
import com.phiintegration.phiexception.NormalizerNotImplementedException;

public class PHIHeaderWithSeparator {
	private String teks;
	private String sep;
	
	public final String UTF8_BOM = "\uFEFF";
	
	PHINameIndexPair phiFields = null;
	
	public PHIHeaderWithSeparator(String text, String sep, PHINormalizeColumnNameEnum phiNormalizeEnum) throws EmptyColumnNameException, DuplicateColumnNameException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		this.teks = text;
		this.sep = sep;

		String arrTeks[] = (teks + " ").split(sep);
		Integer teksLen = arrTeks.length;
		arrTeks[teksLen-1] = arrTeks[teksLen-1].substring(0, arrTeks[teksLen-1].length()-1);

		for (String arrTek : arrTeks) {
			if(arrTek.trim().equals(""))
			{
				throw new EmptyColumnNameException(
						"Field kosong ditemukan!");
			}
		}
		
		phiFields = new PHINameIndexPair(phiNormalizeEnum);
		
		for(int i=0; i< arrTeks.length;i++)
		{
			phiFields.add(arrTeks[i], i);
		}
	}
	
	public PHIHeaderWithSeparator(Integer n, String Prefix, PHINormalizeColumnNameEnum phiNormalizeEnum) throws DuplicateColumnNameException, EmptyColumnNameException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		for(int i=0; i< n;i++)
		{
			phiFields.add(Prefix + " " + i, i);
		}
	}
	
	public Integer getIndex(String headerName) throws ColumnIndexOrNameNotFoundException
	{
		return phiFields.getIndexByFieldName(headerName);
	}
	
	public String getFieldName(String headerName) throws ColumnIndexOrNameNotFoundException
	{
		return phiFields.getNameByOriginalFieldName(headerName);

	}

	public String getFieldName(Integer idx) throws ColumnIndexOrNameNotFoundException
	{
		return phiFields.getNameByIndex(idx);

	}
	
	public Integer getNumOfColumns() {
		return phiFields.numOfColumns();
	}
	
	public String getSep()
	{
		return this.sep;
	}
}
