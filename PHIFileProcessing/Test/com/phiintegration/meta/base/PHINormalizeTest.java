package com.phiintegration.meta.base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.phiintegration.phienum.PHINormalizeColumnNameEnum;
import com.phiintegration.phiexception.EmptyColumnNameException;
import com.phiintegration.phiexception.NormalizerNotImplementedException;

public class PHINormalizeTest {	
	@Test
	public void testNull() throws NormalizerNotImplementedException {
		PHINormalizeColumnName normalisasi = new PHINormalizeColumnName();
		
		assertEquals(normalisasi.normalize(null, PHINormalizeColumnNameEnum.NONE), null);
		assertEquals(normalisasi.normalize(null, PHINormalizeColumnNameEnum.TRIM), null);
		assertEquals(normalisasi.normalize(null, PHINormalizeColumnNameEnum.LOWER), null);
		assertEquals(normalisasi.normalize(null, PHINormalizeColumnNameEnum.UPPER), null);
		assertEquals(normalisasi.normalize(null, PHINormalizeColumnNameEnum.OTHER), null);
	}

	@Test
	public void testNormalisasiDasar() throws NormalizerNotImplementedException {
		PHINormalizeColumnName normalisasi = new PHINormalizeColumnName();
		String teks = " TeMpAt 	laHiR ";
		
		assertEquals(normalisasi.normalize(null, PHINormalizeColumnNameEnum.NONE), null);
		
		assertEquals(normalisasi.normalize(teks, PHINormalizeColumnNameEnum.NONE), teks);
		assertEquals(normalisasi.normalize(teks, PHINormalizeColumnNameEnum.TRIM), "TeMpAt 	laHiR");
		assertEquals(normalisasi.normalize(teks, PHINormalizeColumnNameEnum.TRIM_LOWER), "tempat 	lahir");
		assertEquals(normalisasi.normalize(teks, PHINormalizeColumnNameEnum.TRIM_UPPER), "TEMPAT 	LAHIR");

		assertEquals(normalisasi.normalize(teks, PHINormalizeColumnNameEnum.TRIM_LOWER_UNDERSCORE), "tempat__lahir");
		assertEquals(normalisasi.normalize(teks, PHINormalizeColumnNameEnum.TRIM_UPPER_UNDERSCORE), "TEMPAT__LAHIR");
		
		assertEquals(normalisasi.normalize(teks, PHINormalizeColumnNameEnum.TRIM_LOWER_UNDERSCORE_NOREPEATINGSPACE), "tempat_lahir");
		assertEquals(normalisasi.normalize(teks, PHINormalizeColumnNameEnum.TRIM_UPPER_UNDERSCORE_NOREPEATINGSPACE), "TEMPAT_LAHIR");
	}

	@Test(expected = NormalizerNotImplementedException.class)
	public void testNormalizeException() throws NormalizerNotImplementedException {
		PHINormalizeColumnName normalisasi = new PHINormalizeColumnName();
		String teks = " TeMpAt 	laHiR ";
		
		assertEquals(normalisasi.normalize(null, PHINormalizeColumnNameEnum.NONE), null);

		assertEquals(normalisasi.normalize(teks, PHINormalizeColumnNameEnum.OTHER), "tempat_lahir");
	}
}
