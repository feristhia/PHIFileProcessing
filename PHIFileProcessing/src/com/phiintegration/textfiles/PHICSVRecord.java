package com.phiintegration.textfiles;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.phiintegration.meta.base.PHIHeaderWithSeparator;
import com.phiintegration.phienum.PHIReadTextResult;
import com.phiintegration.phiexception.ColumnIndexOrNameNotFoundException;
import com.phiintegration.phiexception.DuplicateColumnNameException;
import com.phiintegration.phiexception.EmptyColumnNameException;

public class PHICSVRecord {
	/*
	String namaFile = null;
	String sep = null;
	
	InputStream  fileReader = null;
	Integer baris = null;
	
	String UTF8 = "utf8";
	int BUFFER_SIZE = 8192;
	
	BufferedReader buffReader = null;

	PHIHeaderWithSeparator csvHeader = null;
	PHICSVDetailRowText csvDetail = null;

	public PHICSVRecord(String namaFile, String sep) throws IOException, DuplicateColumnNameException, EmptyColumnNameException
	{
		this.sep = sep;
		
		fileReader = new FileInputStream(namaFile);
		buffReader = new BufferedReader(new InputStreamReader(fileReader,UTF8), BUFFER_SIZE);

		buffReader.mark(1);
		if (0xFEFF != buffReader.read()) buffReader.reset(); 
	
		String sCurrentLine;
		if((sCurrentLine = buffReader.readLine()) != null)
		{
			csvHeader = new PHIHeaderWithSeparator(sCurrentLine, sep);
			csvDetail = new PHICSVDetailRowText(csvHeader);
			baris = 0;
		}
	}

	public PHIReadTextResult read()
	{
		String sCurrentLine;
		PHIReadTextResult statusBaca = PHIReadTextResult.NULL;
		try {
			if((sCurrentLine = buffReader.readLine()) != null)
			{
				baris++;
				statusBaca = csvDetail.proses(sCurrentLine, sep);
			}
			else
			{
				return PHIReadTextResult.NULL;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ColumnIndexOrNameNotFoundException e) {
			e.printStackTrace();
		}
		return statusBaca;
	}

	public String getString(String namaField) throws ColumnIndexOrNameNotFoundException
	{
		return csvDetail.get(namaField);
	}
	
	public String getString(Integer idx) throws ColumnIndexOrNameNotFoundException
	{
		if(idx <= 0)
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index tidak boleh lebih kecil dari 1!");
		else if(idx > numOfColumns())
			throw new ColumnIndexOrNameNotFoundException(
					"Kolom Index tidak boleh lebih besar dari jumlah kolom!");
		return csvDetail.get(idx-1);
	}

	public String getFieldName(Integer idx) throws ColumnIndexOrNameNotFoundException
	{
		return csvHeader.getIndex(idx);
	}


	public Integer getFieldPosition(String idx) throws ColumnIndexOrNameNotFoundException
	{
		return csvHeader.getIndex(idx);
	}

	public Integer getHeaderLength()
	{
		return csvHeader.getNumOfColumns();
	}
	
	public void close() throws IOException
	{
		buffReader.close();
		fileReader.close();
	}
	
	public Integer numOfColumns()
	{
		return csvHeader.getNumOfColumns();
	}
	
	public Integer getCurrentLine()
	{
		return baris;
	}
	*/
}
