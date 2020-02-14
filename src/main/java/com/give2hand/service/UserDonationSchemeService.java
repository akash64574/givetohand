package com.give2hand.service;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.give2hand.dto.MakePaymentRequestDto;
import com.give2hand.dto.MakePaymentResponseDto;
import com.itextpdf.text.DocumentException;

public interface UserDonationSchemeService {
	
	MakePaymentResponseDto makePayment(MakePaymentRequestDto makePaymentRequestDto) throws FileNotFoundException, DocumentException, UnsupportedEncodingException, MessagingException;
	
}
