package com.give2hand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.give2hand.constant.AppConstant;
import com.give2hand.dto.SchemeChartDto;
import com.give2hand.dto.SchemeStatisticResponseDto;
import com.give2hand.entity.DonationScheme;
import com.give2hand.service.DonationSchemeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/schemes")
@CrossOrigin
@Slf4j
public class DonationSchemeController {

	@Autowired
	DonationSchemeService donationSchemeService;

	@GetMapping
	public ResponseEntity<List<DonationScheme>> getAllSchemes() {

		return new ResponseEntity<List<DonationScheme>>(donationSchemeService.getAllSchemes(), HttpStatus.OK);

	}

	/**
	 * Get the scheme statistics for the schemes.
	 * 
	 * @return list of scheme details with count and percentage
	 * @author Govindasamy.C
	 * @since 14-02-2020
	 */
	@GetMapping("/chart")
	public ResponseEntity<SchemeStatisticResponseDto> getStatisticsForScheme() {
		log.info("get the statistic for schemes...");
		SchemeStatisticResponseDto schemeStatisticResponseDto = new SchemeStatisticResponseDto();
		List<SchemeChartDto> schemeStatistics = donationSchemeService.getStatisticsForScheme();
		schemeStatisticResponseDto.setSchemes(schemeStatistics);
		schemeStatisticResponseDto.setMessage(AppConstant.SUCCESS_MESSAGE);
		schemeStatisticResponseDto.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(schemeStatisticResponseDto, HttpStatus.OK);
	}
}
