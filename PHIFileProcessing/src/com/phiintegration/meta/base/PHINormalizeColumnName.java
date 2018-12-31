package com.phiintegration.meta.base;

import com.phiintegration.phienum.PHINormalizeColumnNameEnum;
import com.phiintegration.phiexception.NormalizerNotImplementedException;

public class PHINormalizeColumnName {
	public String normalize(String teks, PHINormalizeColumnNameEnum normalizeenum) throws NormalizerNotImplementedException
	{
		if(teks == null)
			return teks;
		
		if(normalizeenum==PHINormalizeColumnNameEnum.NONE)
		{
			return teks;
		}
		
		String hasil = teks;
		if(normalizeenum==PHINormalizeColumnNameEnum.TRIM)
		{
			hasil = hasil.trim();
		}
		else if(normalizeenum==PHINormalizeColumnNameEnum.UNDERSCORE)
		{
			hasil = hasil.replaceAll("\\s", "_");
		}
		else if(normalizeenum==PHINormalizeColumnNameEnum.TRIM_LOWER)
		{
			hasil = hasil.trim().toLowerCase();
		}
		else if(normalizeenum==PHINormalizeColumnNameEnum.TRIM_UPPER)
		{
			hasil = hasil.trim().toUpperCase();
		}
		else if(normalizeenum==PHINormalizeColumnNameEnum.TRIM_UNDERSCORE)
		{
			hasil = hasil.trim().replaceAll("\\s", "_");
		}
		else if(normalizeenum==PHINormalizeColumnNameEnum.TRIM_LOWER_UNDERSCORE)
		{
			hasil = hasil.trim().toLowerCase().replaceAll("\\s", "_");
		}
		else if(normalizeenum==PHINormalizeColumnNameEnum.TRIM_UPPER_UNDERSCORE)
		{
			hasil = hasil.trim().toUpperCase().replaceAll("\\s", "_");
		}
		else if(normalizeenum==PHINormalizeColumnNameEnum.TRIM_LOWER_UNDERSCORE_NOREPEATINGSPACE)
		{
			hasil = hasil.trim().toLowerCase().replaceAll("\\s+", "_");
		}
		else if(normalizeenum==PHINormalizeColumnNameEnum.TRIM_UPPER_UNDERSCORE_NOREPEATINGSPACE)
		{
			hasil = hasil.trim().toUpperCase().replaceAll("\\s+", "_");
		}
		else
		{			
			throw new NormalizerNotImplementedException("Method " + normalizeenum.toString() + " belum diimplementasikan");
		}
		return hasil;
	}
}
