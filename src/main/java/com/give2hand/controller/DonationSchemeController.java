package com.give2hand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.give2hand.entity.DonationScheme;
import com.give2hand.service.DonationSchemeService;

@RestController
@RequestMapping("/schemes")
@CrossOrigin
public class DonationSchemeController {

	@Autowired
	DonationSchemeService donationSchemeService;

	@GetMapping
	public ResponseEntity<List<DonationScheme>> getAllSchemes(){
		
		return new ResponseEntity<List<DonationScheme>>(donationSchemeService.getAllSchemes(), HttpStatus.OK);
		
	}
}
