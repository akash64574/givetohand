package com.give2hand.service;

import java.io.FileNotFoundException;

import com.give2hand.entity.UserDonationScheme;
import com.itextpdf.text.DocumentException;

public interface TaxCertificateGenerationService {

	String generateTaxCertificate(UserDonationScheme userDonationScheme)
			throws DocumentException, FileNotFoundException;

}
