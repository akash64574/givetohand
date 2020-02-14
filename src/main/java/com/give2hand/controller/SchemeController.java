package com.give2hand.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foreignexchange.constant.AppConstant;
import com.foreignexchange.controller.CurrencyController;
import com.foreignexchange.dto.UserTransactionResponceDto;
import com.foreignexchange.exception.UserAccountNotFoundException;
import com.foreignexchange.exception.UserNotFoundException;
import com.give2hand.dto.GetAllSchemesDto;
import com.give2hand.service.SchemeService;

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
public class SchemeController {

	@Autowired
	SchemeService schemeService;

	@GetMapping
	public ResponseEntity<List<GetAllSchemesDto>> getAllSchemes() {
		
		schemeService.getAllSchemes();
		return null;

		

	}

}
