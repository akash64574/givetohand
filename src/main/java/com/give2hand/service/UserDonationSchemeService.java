package com.give2hand.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.give2hand.dto.MakePaymentRequestDto;
import com.give2hand.dto.MakePaymentResponseDto;
import com.give2hand.exception.DonationNotFoundException;
import com.itextpdf.text.DocumentException;

public interface UserDonationSchemeService {
	
	MakePaymentResponseDto makePayment(MakePaymentRequestDto makePaymentRequestDto) throws FileNotFoundException, DocumentException;
	
	byte[] getTaxCertificate(Integer donationId) throws IOException, DonationNotFoundException;

}
