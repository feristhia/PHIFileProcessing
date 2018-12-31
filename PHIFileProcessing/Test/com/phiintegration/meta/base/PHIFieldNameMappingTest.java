package com.phiintegration.meta.base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.phiintegration.phiexception.ColumnIndexOrNameNotFoundException;

public class PHIFieldNameMappingTest {	
	@Test
	public void testGetPositionByIndexAndName() throws ColumnIndexOrNameNotFoundException {
		PHIFieldNameMapping phiFieldNameMapping = new PHIFieldNameMapping();
		phiFieldNameMapping.add("Nama", 3);
		phiFieldNameMapping.add("Alamat", 3);
		phiFieldNameMapping.add("Tempat", 3);
		phiFieldNameMapping.add("Tanggal Lahir", 3);
		
		assertEquals(phiFieldNameMapping.getNameLowerCase(1), "nama");
		assertEquals(phiFieldNameMapping.getNameLowerCase(2), "alamat");
		assertEquals(phiFieldNameMapping.getNameLowerCase(3), "tempat");
		assertEquals(phiFieldNameMapping.getNameLowerCase(4), "tanggal lahir");

		assertEquals(phiFieldNameMapping.getIndexByLower("nama"),new Integer(1));
		assertEquals(phiFieldNameMapping.getIndexByLower("alamat"),new Integer(2));
		assertEquals(phiFieldNameMapping.getIndexByLower("tempat"),new Integer(3));
		assertEquals(phiFieldNameMapping.getIndexByLower("tanggal lahir"),new Integer(4));
		
		assertEquals(phiFieldNameMapping.getNameUpperCase(1), "NAMA");
		assertEquals(phiFieldNameMapping.getNameUpperCase(2), "ALAMAT");
		assertEquals(phiFieldNameMapping.getNameUpperCase(3), "TEMPAT");
		assertEquals(phiFieldNameMapping.getNameUpperCase(4), "TANGGAL LAHIR");

		assertEquals(phiFieldNameMapping.getIndexByUpper("NAMA"),new Integer(1));
		assertEquals(phiFieldNameMapping.getIndexByUpper("ALAMAT"),new Integer(2));
		assertEquals(phiFieldNameMapping.getIndexByUpper("TEMPAT"),new Integer(3));
		assertEquals(phiFieldNameMapping.getIndexByUpper("TANGGAL LAHIR"),new Integer(4));
		
		assertEquals(phiFieldNameMapping.getNameOriginal(1), "Nama");
		assertEquals(phiFieldNameMapping.getNameOriginal(2), "Alamat");
		assertEquals(phiFieldNameMapping.getNameOriginal(3), "Tempat");
		assertEquals(phiFieldNameMapping.getNameOriginal(4), "Tanggal Lahir");
		
		assertEquals(phiFieldNameMapping.getIndexByOriginal("Nama"),new Integer(1));
		assertEquals(phiFieldNameMapping.getIndexByOriginal("Alamat"),new Integer(2));
		assertEquals(phiFieldNameMapping.getIndexByOriginal("Tempat"),new Integer(3));
		assertEquals(phiFieldNameMapping.getIndexByOriginal("Tanggal Lahir"),new Integer(4));
	}
	
	@Test
	public void testSpacesPrefixSuffix() throws ColumnIndexOrNameNotFoundException {
		PHIFieldNameMapping phiFieldNameMapping = new PHIFieldNameMapping();
		phiFieldNameMapping.add("  Nama", 3);
		phiFieldNameMapping.add("Alamat  ", 3);
		phiFieldNameMapping.add("  Tempat ", 3);
		phiFieldNameMapping.add("   Tanggal Lahir    ", 3);
		
		assertEquals(phiFieldNameMapping.getNameLowerCase(1), "nama");
		assertEquals(phiFieldNameMapping.getNameLowerCase(2), "alamat");
		assertEquals(phiFieldNameMapping.getNameLowerCase(3), "tempat");
		assertEquals(phiFieldNameMapping.getNameLowerCase(4), "tanggal lahir");

		assertEquals(phiFieldNameMapping.getNameUpperCase(1), "NAMA");
		assertEquals(phiFieldNameMapping.getNameUpperCase(2), "ALAMAT");
		assertEquals(phiFieldNameMapping.getNameUpperCase(3), "TEMPAT");
		assertEquals(phiFieldNameMapping.getNameUpperCase(4), "TANGGAL LAHIR");

		assertEquals(phiFieldNameMapping.getNameOriginal(1), "Nama");
		assertEquals(phiFieldNameMapping.getNameOriginal(2), "Alamat");
		assertEquals(phiFieldNameMapping.getNameOriginal(3), "Tempat");
		assertEquals(phiFieldNameMapping.getNameOriginal(4), "Tanggal Lahir");
	}
}
