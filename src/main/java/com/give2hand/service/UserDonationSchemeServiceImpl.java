package com.give2hand.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.give2hand.common.GiveToHandEnum.PaymentStatus;
import com.give2hand.constant.AppConstant;
import com.give2hand.dto.MakePaymentRequestDto;
import com.give2hand.dto.MakePaymentResponseDto;
import com.give2hand.entity.DonationScheme;
import com.give2hand.entity.UserDonationScheme;
import com.give2hand.exception.DonationNotFoundException;
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

	/**
	 * 
	 * @author Raghu.
	 * 
	 *         This method will will make the payment and and save the donar.
	 * 
	 * @since 2020-02-14.
	 * @param donar details, like name, donarId, panNumber and tax percentage.
	 * @return donarId generated in database.
	 * 
	 */
	@Override
	@Transactional
	public MakePaymentResponseDto makePayment(MakePaymentRequestDto makePaymentRequestDto)
			throws FileNotFoundException, DocumentException {

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

	@Override
	public byte[] getTaxCertificate(Integer donationId) throws IOException, DonationNotFoundException {
		Optional<UserDonationScheme> userDonationScheme = userDonationSchemeRepository.findById(donationId);
		if(!userDonationScheme.isPresent()) {
			 throw new DonationNotFoundException(AppConstant.DONATION_NOT_FOUND);
		}
		File file = new File(userDonationScheme.get().getTaxCertificateUrl());
	      FileInputStream fis = new FileInputStream(file);
	      byte [] data = new byte[(int)file.length()];
	      fis.read(data);
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      data = bos.toByteArray();
	      fis.close();
		return data;
	}

}
