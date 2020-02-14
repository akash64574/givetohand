package com.give2hand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.give2hand.constant.AppConstant;
import com.give2hand.dto.DonationSchemesReponseDto;
import com.give2hand.dto.DonorsDto;
import com.give2hand.dto.DonorsResponseDto;
import com.give2hand.exception.SchemeNotFoundException;
import com.give2hand.service.DonationSchemeService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Get the all currencies and get the exchange rate based on the currency code.
 * 
 * @author Amala.S
 * @since 14-02-2020
 * @version V1.1
 * 
 *
 */
@RestController
@RequestMapping("schemes")
@CrossOrigin
@Slf4j
public class DonationSchemeController {

	@Autowired
	DonationSchemeService donationSchemeService;

	@GetMapping
	public ResponseEntity<List<DonationSchemesReponseDto>> getAllSchemes() {

		return ResponseEntity.ok().body(donationSchemeService.getAllSchemes());

	}
	
	
	
	@GetMapping("/{schemeId}")
	public ResponseEntity<DonorsResponseDto> getSchemeBySchemeId(@PathVariable Integer schemeId) throws SchemeNotFoundException {
		DonorsResponseDto donorsResponseDto=new DonorsResponseDto();
		List<DonorsDto> donors = donationSchemeService.getSchemeBySchemeId(schemeId);
		donorsResponseDto.setDonors(donors);
		donorsResponseDto.setMessage(AppConstant.SUCCESS_MESSAGE);
		donorsResponseDto.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity(donorsResponseDto, HttpStatus.OK);
	}
	
	

}
