package com.give2hand.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.give2hand.dto.MakePaymentRequestDto;
import com.give2hand.dto.MakePaymentResponseDto;
import com.give2hand.service.UserDonationSchemeService;
import com.itextpdf.text.DocumentException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserDonationSchemeControllerTest {
	
	@InjectMocks
	UserDonationSchemeController userDonationSchemeController;
	
	@Mock
	UserDonationSchemeService userDonationSchemeService;
	
	@Test
	public void testMakePaymentSuccess() throws FileNotFoundException, DocumentException, UnsupportedEncodingException, MessagingException {
		
		Mockito.when(userDonationSchemeService.makePayment(Mockito.any())).thenReturn(new MakePaymentResponseDto());
		Integer actual = userDonationSchemeController.makePayment(new MakePaymentRequestDto()).getStatusCode();
		Integer expected = 200;
		assertEquals(expected, actual);
	}
}
