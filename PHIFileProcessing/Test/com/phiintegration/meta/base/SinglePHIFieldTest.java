package com.phiintegration.meta.base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SinglePHIFieldTest {	
	@Test
	public void test1() {
		PHIFieldValue phiField = new PHIFieldValue();
		phiField.setFieldName("Nama");
		phiField.setFieldValue("Budi Wijaya");
		
		assertEquals(phiField.getFieldName(), "Nama");
		assertEquals(phiField.getFieldValue(), "Budi Wijaya");
	}
}
