package com.give2hand.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.give2hand.constant.AppConstant;
import com.give2hand.dto.MakePaymentRequestDto;
import com.give2hand.dto.MakePaymentResponseDto;
import com.give2hand.exception.DonationNotFoundException;
import com.give2hand.service.UserDonationSchemeService;
import com.itextpdf.text.DocumentException;

import lombok.extern.slf4j.Slf4j;

/**
 * This class performs the operations related to the donar like save donar
 * generate pdf for donar tax certificate
 * 
 * @author Raghu M
 * @since Feb-14-2020
 * @version v1.0
 *
 */
@RestController
@RequestMapping("/donations")
@CrossOrigin
@Slf4j
public class UserDonationSchemeController {

	@Autowired
	UserDonationSchemeService userDonationSchemeService;

	/**
	 * 
	 * @author Raghu.
	 * 
	 *         This method will will make a call to service layer to make the
	 *         payment and save the donar.
	 * 
	 * @since 2020-02-14.
	 * @param donar details, like name, donarId, panNumber and tax percentage.
	 * @return donarId generated in database with status code and message.
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 * 
	 */
	@PostMapping
	public MakePaymentResponseDto makePayment(@RequestBody MakePaymentRequestDto makePaymentRequestDto)
			throws FileNotFoundException, DocumentException, UnsupportedEncodingException, MessagingException {
		log.info("UserDonationSchemeController makePayment ---> making payment");
		MakePaymentResponseDto makePaymentResponseDto = userDonationSchemeService.makePayment(makePaymentRequestDto);
		makePaymentResponseDto.setStatusCode(HttpStatus.OK.value());
		makePaymentResponseDto.setMessage(AppConstant.SUCCESS_MESSAGE);
		return makePaymentResponseDto;

	}
	/**
	 * 
	 * @author Raghu.
	 * 
	 *         This method will will make a call to service layer to get the tax certificate
	 * 
	 * @since 2020-02-14.
	 * @param donar id.
	 * @return array of byte of data which contains the tax certificate.
	 * 
	 */
	@GetMapping("/{donationId}")
	public ResponseEntity<byte[]> getTaxCertificate(@PathVariable("donationId") Integer donationId)
			throws IOException, DonationNotFoundException {
		log.info("UserDonationSchemeController getTaxCertificate ---> fetching tax certificate");
		return ResponseEntity.ok().body(userDonationSchemeService.getTaxCertificate(donationId));
	}

}
