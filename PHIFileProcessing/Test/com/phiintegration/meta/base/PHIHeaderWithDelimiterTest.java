package com.phiintegration.meta.base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.phiintegration.phienum.PHINormalizeColumnNameEnum;
import com.phiintegration.phiexception.ColumnIndexOrNameNotFoundException;
import com.phiintegration.phiexception.DuplicateColumnCustomIndexException;
import com.phiintegration.phiexception.DuplicateColumnNameException;
import com.phiintegration.phiexception.EmptyColumnNameException;
import com.phiintegration.phiexception.NormalizerNotDefined;
import com.phiintegration.phiexception.NormalizerNotImplementedException;

public class PHIHeaderWithDelimiterTest {
	@Test(expected = EmptyColumnNameException.class)
	public void testEmptyColumnName1() throws DuplicateColumnNameException, EmptyColumnNameException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "NAMA||KELAS|TANGGAL_LAHIR";
		new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.NONE);
	}
	
	@Test(expected = EmptyColumnNameException.class)
	public void testEmptyColumnName2() throws DuplicateColumnNameException, EmptyColumnNameException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "|||";
		new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.NONE);
	}
	
	@Test(expected = EmptyColumnNameException.class)
	public void testEmptyColumnName3() throws DuplicateColumnNameException, EmptyColumnNameException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "NAMA|KELAS|TANGGAL_LAHIR|";
		new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.NONE);
	}
	
	@Test(expected = EmptyColumnNameException.class)
	public void testEmptyColumnName4() throws DuplicateColumnNameException, EmptyColumnNameException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "|NAMA|KELAS|TANGGAL_LAHIR";
		new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.NONE);
	}
	
	
	@Test(expected = DuplicateColumnNameException.class)
	public void testDuplicateColumnName1() throws DuplicateColumnNameException, EmptyColumnNameException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "NAMA|ALAMAT|KELAS|TANGGAL_LAHIR|KELAS";
		new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.NONE);
	}

	@Test(expected = DuplicateColumnNameException.class)
	public void testDuplicateColumnName2() throws DuplicateColumnNameException, EmptyColumnNameException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "NAMA|NAMA|KELAS|TANGGAL_LAHIR|KOTA";
		new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.NONE);
	}
	
	@Test(expected = DuplicateColumnNameException.class)
	public void testDuplicateColumnName3() throws DuplicateColumnNameException, EmptyColumnNameException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "NAMA|TANGGAL_LAHIR|KELAS|TANGGAL_LAHIR|KOTA";
		new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.NONE);
	}
	
	@Test(expected = ColumnIndexOrNameNotFoundException.class)
	public void testColumnNameNotFound1() throws DuplicateColumnNameException, EmptyColumnNameException, ColumnIndexOrNameNotFoundException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "NAMA|ALAMAT|TEMPA_LAHIR|TANGGAL_LAHIR|KOTA";
		PHIHeaderWithSeparator headers = new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.NONE);
		
		headers.getIndex("TANGGAL");
	}
	
	@Test(expected = ColumnIndexOrNameNotFoundException.class)
	public void testColumnNameNotFound2() throws DuplicateColumnNameException, EmptyColumnNameException, ColumnIndexOrNameNotFoundException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "NAMA|ALAMAT|TEMPA_LAHIR|TANGGAL_LAHIR|KOTA";
		PHIHeaderWithSeparator headers = new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.NONE);
		
		headers.getFieldName("ADAAJA");
	}
	
	@Test(expected = ColumnIndexOrNameNotFoundException.class)
	public void testColumnNameNotFound3() throws DuplicateColumnNameException, EmptyColumnNameException, ColumnIndexOrNameNotFoundException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "NAMA|ALAMAT|TEMPAT_LAHIR|TANGGAL_LAHIR|KOTA";
		PHIHeaderWithSeparator headers = new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.NONE);
		
		headers.getFieldName("test");
	}
	
	@Test
	public void test1() throws DuplicateColumnNameException, EmptyColumnNameException, ColumnIndexOrNameNotFoundException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "NAMA|ALAMAT|TEMPAT_LAHIR|TANGGAL_LAHIR|KOTA";
		PHIHeaderWithSeparator headers = new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.NONE);
		
		assertEquals(headers.getIndex("NAMA"), new Integer(1));
		assertEquals(headers.getIndex("ALAMAT"), new Integer(2));
		assertEquals(headers.getIndex("TEMPAT_LAHIR"), new Integer(3));
		assertEquals(headers.getIndex("TANGGAL_LAHIR"), new Integer(4));
		assertEquals(headers.getIndex("KOTA"), new Integer(5));
		
		assertEquals(headers.getIndex("NAMA")==1, true);
		assertEquals(headers.getIndex("ALAMAT")==2, true);
		assertEquals(headers.getIndex("TEMPAT_LAHIR")==3, true);
		assertEquals(headers.getIndex("TANGGAL_LAHIR")==4, true);
		assertEquals(headers.getIndex("KOTA")==5, true);

		assertEquals(headers.getFieldName(1), "NAMA");
		assertEquals(headers.getFieldName(2), "ALAMAT");
		assertEquals(headers.getFieldName(3), "TEMPAT_LAHIR");
		assertEquals(headers.getFieldName(4), "TANGGAL_LAHIR");
		assertEquals(headers.getFieldName(5), "KOTA");
		
		assertEquals(headers.getNumOfColumns(), new Integer(5));
		assertEquals(headers.getNumOfColumns()==5, true);
	}
	
	@Test
	public void test2() throws DuplicateColumnNameException, EmptyColumnNameException, ColumnIndexOrNameNotFoundException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "  NAMA|ALAMAT | TEMPAT_LAHIR |TANGGAL_LAHIR|KOTA";
		PHIHeaderWithSeparator headers = new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.TRIM_UPPER);
		
		assertEquals(headers.getIndex("NAMA"), new Integer(1));
		assertEquals(headers.getIndex("ALAMAT"), new Integer(2));
		assertEquals(headers.getIndex("TEMPAT_LAHIR"), new Integer(3));
		assertEquals(headers.getIndex("TANGGAL_LAHIR"), new Integer(4));
		assertEquals(headers.getIndex("KOTA"), new Integer(5));
		
		assertEquals(headers.getIndex("NAMA")==1, true);
		assertEquals(headers.getIndex("ALAMAT")==2, true);
		assertEquals(headers.getIndex("TEMPAT_LAHIR")==3, true);
		assertEquals(headers.getIndex("TANGGAL_LAHIR")==4, true);
		assertEquals(headers.getIndex("KOTA")==5, true);

		assertEquals(headers.getFieldName(1), "NAMA");
		assertEquals(headers.getFieldName(2), "ALAMAT");
		assertEquals(headers.getFieldName(3), "TEMPAT_LAHIR");
		assertEquals(headers.getFieldName(4), "TANGGAL_LAHIR");
		assertEquals(headers.getFieldName(5), "KOTA");
		
		assertEquals(headers.getNumOfColumns(), new Integer(5));
		assertEquals(headers.getNumOfColumns()==5, true);
	}
	
	@Test
	public void test3() throws DuplicateColumnNameException, EmptyColumnNameException, ColumnIndexOrNameNotFoundException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "  nama|Alamat | Tempat Lahir |tgl lahir |kota";
		PHIHeaderWithSeparator headers = new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.TRIM_UPPER);
		
		assertEquals(headers.getIndex("NAMA"), new Integer(1));
		assertEquals(headers.getIndex("ALAMAT"), new Integer(2));
		assertEquals(headers.getIndex("TEMPAT LAHIR"), new Integer(3));
		assertEquals(headers.getIndex("TGL LAHIR"), new Integer(4));
		assertEquals(headers.getIndex("KOTA"), new Integer(5));
		
		assertEquals(headers.getIndex("NAMA")==1, true);
		assertEquals(headers.getIndex("ALAMAT")==2, true);
		assertEquals(headers.getIndex("TEMPAT LAHIR")==3, true);
		assertEquals(headers.getIndex("TGL LAHIR")==4, true);
		assertEquals(headers.getIndex("KOTA")==5, true);

		assertEquals(headers.getFieldName(1), "NAMA");
		assertEquals(headers.getFieldName(2), "ALAMAT");
		assertEquals(headers.getFieldName(3), "TEMPAT LAHIR");
		assertEquals(headers.getFieldName(4), "TGL LAHIR");
		assertEquals(headers.getFieldName(5), "KOTA");
		
		assertEquals(headers.getNumOfColumns(), new Integer(5));
		assertEquals(headers.getNumOfColumns()==5, true);
	}
	
	@Test
	public void test4() throws DuplicateColumnNameException, EmptyColumnNameException, ColumnIndexOrNameNotFoundException, NormalizerNotDefined, DuplicateColumnCustomIndexException, NormalizerNotImplementedException {
		String header = "NAMA|ALAMAT|TEMPAT_LAHIR|TANGGAL_LAHIR|KOTA";
		String detail = "Budi Wijaya|Taman Ayu|Semarang|01-01-1987|Semarang";
		PHIHeaderWithSeparator headerHandler = new PHIHeaderWithSeparator(header,"\\|",PHINormalizeColumnNameEnum.NONE);
		//PHICSVDetailRowText detailHandler = new PHICSVDetailRowText(headerHandler);
		
		//detailHandler.proses(detail, "\\|");
	}
}
