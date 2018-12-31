package com.phiintegration.meta.base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.phiintegration.phienum.PHINormalizeColumnNameEnum;
import com.phiintegration.phiexception.ColumnIndexOrNameNotFoundException;
import com.phiintegration.phiexception.DuplicateColumnCustomIndexException;
import com.phiintegration.phiexception.DuplicateColumnNameException;
import com.phiintegration.phiexception.NormalizerNotDefined;
import com.phiintegration.phiexception.NormalizerNotImplementedException;

public class PHIFieldNameIndexPairTest {	
	@Test
	public void testGetPositionByIndexAndName1() throws ColumnIndexOrNameNotFoundException, DuplicateColumnNameException, DuplicateColumnCustomIndexException, NormalizerNotDefined, NormalizerNotImplementedException {
		PHINameIndexPair phiNameIndex = new PHINameIndexPair(PHINormalizeColumnNameEnum.TRIM);
		phiNameIndex.add("Nama", 2);
		phiNameIndex.add("Alamat", 1);
		phiNameIndex.add("Tempat", 4);
		phiNameIndex.add("Tanggal Lahir", 3);
		
		assertEquals(phiNameIndex.getNameByIndex(1), "Nama");
		assertEquals(phiNameIndex.getNameByIndex(2), "Alamat");
		assertEquals(phiNameIndex.getNameByIndex(3), "Tempat");
		assertEquals(phiNameIndex.getNameByIndex(4), "Tanggal Lahir");

		assertEquals(phiNameIndex.getNameByCustomIndex(2), "Nama");
		assertEquals(phiNameIndex.getNameByCustomIndex(1), "Alamat");
		assertEquals(phiNameIndex.getNameByCustomIndex(4), "Tempat");
		assertEquals(phiNameIndex.getNameByCustomIndex(3), "Tanggal Lahir");
		

		assertEquals(phiNameIndex.getIndexByCustomIndex(2), new Integer(1));
		assertEquals(phiNameIndex.getIndexByCustomIndex(1), new Integer(2));
		assertEquals(phiNameIndex.getIndexByCustomIndex(4), new Integer(3));
		assertEquals(phiNameIndex.getIndexByCustomIndex(3), new Integer(4));

		assertEquals(phiNameIndex.getIndexByFieldName("Nama"), new Integer(1));
		assertEquals(phiNameIndex.getIndexByFieldName("Alamat"), new Integer(2));
		assertEquals(phiNameIndex.getIndexByFieldName("Tempat"), new Integer(3));
		assertEquals(phiNameIndex.getIndexByFieldName("Tanggal Lahir"), new Integer(4));
		
		assertEquals(phiNameIndex.getCustomIndexByIndex(1), new Integer(2));
		assertEquals(phiNameIndex.getCustomIndexByIndex(2), new Integer(1));
		assertEquals(phiNameIndex.getCustomIndexByIndex(3), new Integer(4));
		assertEquals(phiNameIndex.getCustomIndexByIndex(4), new Integer(3));

		assertEquals(phiNameIndex.getCustomIndexByFieldName("Nama"), new Integer(2));
		assertEquals(phiNameIndex.getCustomIndexByFieldName("Alamat"), new Integer(1));
		assertEquals(phiNameIndex.getCustomIndexByFieldName("Tempat"), new Integer(4));
		assertEquals(phiNameIndex.getCustomIndexByFieldName("Tanggal Lahir"), new Integer(3));
	}

	@Test
	public void testGetPositionByIndexAndName2() throws ColumnIndexOrNameNotFoundException, DuplicateColumnNameException, DuplicateColumnCustomIndexException, NormalizerNotDefined, NormalizerNotImplementedException {
		PHINameIndexPair phiNameIndex = new PHINameIndexPair(PHINormalizeColumnNameEnum.TRIM);
		phiNameIndex.add(" Nama ", 2);
		phiNameIndex.add("  Alamat ", 1);
		phiNameIndex.add(" Tempat ", 4);
		phiNameIndex.add(" Tanggal Lahir  ", 3);
		
		assertEquals(phiNameIndex.getNameByIndex(1), "Nama");
		assertEquals(phiNameIndex.getNameByIndex(2), "Alamat");
		assertEquals(phiNameIndex.getNameByIndex(3), "Tempat");
		assertEquals(phiNameIndex.getNameByIndex(4), "Tanggal Lahir");

		assertEquals(phiNameIndex.getNameByCustomIndex(2), "Nama");
		assertEquals(phiNameIndex.getNameByCustomIndex(1), "Alamat");
		assertEquals(phiNameIndex.getNameByCustomIndex(4), "Tempat");
		assertEquals(phiNameIndex.getNameByCustomIndex(3), "Tanggal Lahir");
		

		assertEquals(phiNameIndex.getIndexByCustomIndex(2), new Integer(1));
		assertEquals(phiNameIndex.getIndexByCustomIndex(1), new Integer(2));
		assertEquals(phiNameIndex.getIndexByCustomIndex(4), new Integer(3));
		assertEquals(phiNameIndex.getIndexByCustomIndex(3), new Integer(4));

		assertEquals(phiNameIndex.getIndexByFieldName("Nama"), new Integer(1));
		assertEquals(phiNameIndex.getIndexByFieldName("Alamat"), new Integer(2));
		assertEquals(phiNameIndex.getIndexByFieldName("Tempat"), new Integer(3));
		assertEquals(phiNameIndex.getIndexByFieldName("Tanggal Lahir"), new Integer(4));
		
		assertEquals(phiNameIndex.getCustomIndexByIndex(1), new Integer(2));
		assertEquals(phiNameIndex.getCustomIndexByIndex(2), new Integer(1));
		assertEquals(phiNameIndex.getCustomIndexByIndex(3), new Integer(4));
		assertEquals(phiNameIndex.getCustomIndexByIndex(4), new Integer(3));

		assertEquals(phiNameIndex.getCustomIndexByFieldName("Nama"), new Integer(2));
		assertEquals(phiNameIndex.getCustomIndexByFieldName("Alamat"), new Integer(1));
		assertEquals(phiNameIndex.getCustomIndexByFieldName("Tempat"), new Integer(4));
		assertEquals(phiNameIndex.getCustomIndexByFieldName("Tanggal Lahir"), new Integer(3));
	}

	@Test
	public void testGetPositionByIndexAndName3() throws ColumnIndexOrNameNotFoundException, DuplicateColumnNameException, DuplicateColumnCustomIndexException, NormalizerNotDefined, NormalizerNotImplementedException {
		PHINameIndexPair phiNameIndex = new PHINameIndexPair(PHINormalizeColumnNameEnum.TRIM_UPPER_UNDERSCORE);
		phiNameIndex.add(" Nama ", 2);
		phiNameIndex.add("  Alamat ", 1);
		phiNameIndex.add(" Tempat ", 4);
		phiNameIndex.add(" Tanggal Lahir  ", 3);
		
		assertEquals(phiNameIndex.getNameByIndex(1), "NAMA");
		assertEquals(phiNameIndex.getNameByIndex(2), "ALAMAT");
		assertEquals(phiNameIndex.getNameByIndex(3), "TEMPAT");
		assertEquals(phiNameIndex.getNameByIndex(4), "TANGGAL_LAHIR");

		assertEquals(phiNameIndex.getOriginalNameByIndex(1), " Nama ");
		assertEquals(phiNameIndex.getOriginalNameByIndex(2), "  Alamat ");
		assertEquals(phiNameIndex.getOriginalNameByIndex(3), " Tempat ");
		assertEquals(phiNameIndex.getOriginalNameByIndex(4), " Tanggal Lahir  ");

		assertEquals(phiNameIndex.getNameByCustomIndex(2), "NAMA");
		assertEquals(phiNameIndex.getNameByCustomIndex(1), "ALAMAT");
		assertEquals(phiNameIndex.getNameByCustomIndex(4), "TEMPAT");
		assertEquals(phiNameIndex.getNameByCustomIndex(3), "TANGGAL_LAHIR");
		
		assertEquals(phiNameIndex.getOriginalNameByCustomIndex(2), " Nama ");          
		assertEquals(phiNameIndex.getOriginalNameByCustomIndex(1), "  Alamat ");       
		assertEquals(phiNameIndex.getOriginalNameByCustomIndex(4), " Tempat ");        
		assertEquals(phiNameIndex.getOriginalNameByCustomIndex(3), " Tanggal Lahir  ");

		assertEquals(phiNameIndex.getIndexByCustomIndex(2), new Integer(1));
		assertEquals(phiNameIndex.getIndexByCustomIndex(1), new Integer(2));
		assertEquals(phiNameIndex.getIndexByCustomIndex(4), new Integer(3));
		assertEquals(phiNameIndex.getIndexByCustomIndex(3), new Integer(4));

		assertEquals(phiNameIndex.getIndexByFieldName("NAMA"), new Integer(1));
		assertEquals(phiNameIndex.getIndexByFieldName("ALAMAT"), new Integer(2));
		assertEquals(phiNameIndex.getIndexByFieldName("TEMPAT"), new Integer(3));
		assertEquals(phiNameIndex.getIndexByFieldName("TANGGAL_LAHIR"), new Integer(4));
		
		assertEquals(phiNameIndex.getIndexByOriginalFieldName(" Nama "), new Integer(1));
		assertEquals(phiNameIndex.getIndexByOriginalFieldName("  Alamat "), new Integer(2));
		assertEquals(phiNameIndex.getIndexByOriginalFieldName(" Tempat "), new Integer(3));
		assertEquals(phiNameIndex.getIndexByOriginalFieldName(" Tanggal Lahir  "), new Integer(4));

		assertEquals(phiNameIndex.getCustomIndexByOriginalFieldName(" Nama "), new Integer(2));
		assertEquals(phiNameIndex.getCustomIndexByOriginalFieldName("  Alamat "), new Integer(1));
		assertEquals(phiNameIndex.getCustomIndexByOriginalFieldName(" Tempat "), new Integer(4));
		assertEquals(phiNameIndex.getCustomIndexByOriginalFieldName(" Tanggal Lahir  "), new Integer(3));

		assertEquals(phiNameIndex.getCustomIndexByIndex(1), new Integer(2));
		assertEquals(phiNameIndex.getCustomIndexByIndex(2), new Integer(1));
		assertEquals(phiNameIndex.getCustomIndexByIndex(3), new Integer(4));
		assertEquals(phiNameIndex.getCustomIndexByIndex(4), new Integer(3));

		assertEquals(phiNameIndex.getCustomIndexByFieldName("NAMA"), new Integer(2));
		assertEquals(phiNameIndex.getCustomIndexByFieldName("ALAMAT"), new Integer(1));
		assertEquals(phiNameIndex.getCustomIndexByFieldName("TEMPAT"), new Integer(4));
		assertEquals(phiNameIndex.getCustomIndexByFieldName("TANGGAL_LAHIR"), new Integer(3));
		
		assertEquals(phiNameIndex.numOfColumns(), new Integer(4));
	}
}
