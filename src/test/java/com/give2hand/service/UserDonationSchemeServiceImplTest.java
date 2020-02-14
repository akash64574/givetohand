package com.give2hand.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

import javax.mail.MessagingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.give2hand.common.GiveToHandEnum.PaymentStatus;
import com.give2hand.common.GiveToHandEnum.PaymentType;
import com.give2hand.dto.MakePaymentRequestDto;
import com.give2hand.entity.DonationScheme;
import com.give2hand.entity.UserDonationScheme;
import com.give2hand.exception.DonationNotFoundException;
import com.give2hand.repository.UserDonationSchemeRepository;
import com.itextpdf.text.DocumentException;

@RunWith(MockitoJUnitRunner.class)
public class UserDonationSchemeServiceImplTest {

	@InjectMocks
	UserDonationSchemeServiceImpl userDonationSchemeServiceImpl;

	@InjectMocks
	TaxCertificateGenerationServiceImpl taxCertificateGenerationServiceImpl;

	@Mock
	UserDonationSchemeRepository userDonationSchemeRepository;

	@Mock

	TaxCertificateGenerationService taxCertificateGenerationService;

	UserDonationScheme userDonationScheme = new UserDonationScheme();

	MakePaymentRequestDto makePaymentRequestDto = new MakePaymentRequestDto();

	@Before
	public void setup() {
		makePaymentRequestDto.setEmail("test");
		makePaymentRequestDto.setName("test");
		makePaymentRequestDto.setPanNumber("test");
		makePaymentRequestDto.setPaymentType(PaymentType.CREDIT);
		makePaymentRequestDto.setPhoneNumber(1L);
		makePaymentRequestDto.setSchemeId(1);

		DonationScheme donationScheme = new DonationScheme();
		donationScheme.setSchemeId(1);

		userDonationScheme.setDonationId(1);
		userDonationScheme.setName("test");
		userDonationScheme.setPanNumber("test");
		userDonationScheme.setPaymentStaus(PaymentStatus.SUCCESS);
		userDonationScheme.setPaymentType(PaymentType.CREDIT);
		userDonationScheme.setPhoneNumber(1L);
		userDonationScheme.setScheme(donationScheme);
		userDonationScheme.setTaxCertificateUrl("C:\\Users\\User1\\Desktop\\pdf\\tax13.pdf");
	}

	@Test
	public void testMakePaymentSuccess()
			throws FileNotFoundException, DocumentException, UnsupportedEncodingException, MessagingException {

		Mockito.when(userDonationSchemeRepository.save(Mockito.any())).thenReturn(userDonationScheme);
		Mockito.when(taxCertificateGenerationService.generateTaxCertificate(userDonationScheme)).thenReturn("");
		Integer actual = userDonationSchemeServiceImpl.makePayment(makePaymentRequestDto).getDonationId();
		Integer expected = 1;
		assertEquals(expected, actual);

	}

	@Test(expected = DonationNotFoundException.class)
	public void testGetTaxCertificateDonationNotFoundException() throws IOException, DonationNotFoundException {
		Mockito.when(userDonationSchemeRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(null));
		userDonationSchemeServiceImpl.getTaxCertificate(13);

	}

//	@Test
//	public void testGenerateTaxCertificateSuccess() throws FileNotFoundException, DocumentException {
//		assertNotNull(taxCertificateGenerationService.generateTaxCertificate(userDonationScheme));
//		
//	}

}
