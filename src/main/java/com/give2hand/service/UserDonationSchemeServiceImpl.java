package com.give2hand.service;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.give2hand.common.GiveToHandEnum.PaymentStatus;
import com.give2hand.dto.MakePaymentRequestDto;
import com.give2hand.dto.MakePaymentResponseDto;
import com.give2hand.entity.DonationScheme;
import com.give2hand.entity.UserDonationScheme;
import com.give2hand.repository.UserDonationSchemeRepository;
import com.itextpdf.text.DocumentException;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 
 * 
 * @author Amala .S
 * @since 14-02-2020
 * @version V1.1
 * 
 *
 */
@Service
@Slf4j
public class UserDonationSchemeServiceImpl implements UserDonationSchemeService {

	@Autowired
	UserDonationSchemeRepository userDonationSchemeRepository;

	@Autowired
	TaxCertificateGenerationService taxCertificateGenerationService;
	
	@Autowired
	MailService mailService;

	/**
	 * 
	 * @author Raghu.
	 * 
	 *         This method will will make the payment and and save the donar.
	 * 
	 * @since 2020-02-14.
	 * @param donar details, like name, donarId, panNumber and tax percentage.
	 * @return donarId generated in database.
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 * 
	 */
	@Override
	@Transactional
	public MakePaymentResponseDto makePayment(MakePaymentRequestDto makePaymentRequestDto)
			throws FileNotFoundException, DocumentException, UnsupportedEncodingException, MessagingException {

		log.info("UserDonationSchemeServiceImpl makePayment --> making payment");
		DonationScheme donationScheme = new DonationScheme();
		donationScheme.setSchemeId(makePaymentRequestDto.getSchemeId());
		UserDonationScheme userDonationScheme = new UserDonationScheme();
		BeanUtils.copyProperties(makePaymentRequestDto, userDonationScheme);
		userDonationScheme.setPaymentStaus(PaymentStatus.SUCCESS);
		userDonationScheme.setScheme(donationScheme);
		userDonationScheme = userDonationSchemeRepository.save(userDonationScheme);
		userDonationScheme
				.setTaxCertificateUrl(taxCertificateGenerationService.generateTaxCertificate(userDonationScheme));
		userDonationSchemeRepository.save(userDonationScheme);
		log.info("UserDonationSchemeServiceImpl makePayment --> payment done tax pdf generated");
		MakePaymentResponseDto makePaymentResponseDto = new MakePaymentResponseDto();
		makePaymentResponseDto.setDonationId(userDonationScheme.getDonationId());
		return makePaymentResponseDto;
	}

}
