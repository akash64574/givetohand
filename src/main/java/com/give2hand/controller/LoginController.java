package com.give2hand.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.give2hand.constant.AppConstant;
import com.give2hand.dto.LoginRequestDto;
import com.give2hand.dto.LoginResponseDto;
import com.give2hand.exception.UserNotFoundException;
import com.give2hand.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * LoginController Class - we have the rest api calls for user activities such
 * as check user login activity and get all users.
 * 
 * @author Govindasamy.C
 * @since 14-02-2020
 *
 */
@RestController
@RequestMapping("/login")
@CrossOrigin
@Slf4j
public class LoginController {

	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<LoginResponseDto> userLogin(@Valid @RequestBody LoginRequestDto loginRequestDto)
			throws UserNotFoundException {
		log.info("check the user login based on the phone number and password...");
		LoginResponseDto loginResponseDto = userService.userLogin(loginRequestDto);
		loginResponseDto.setStatusCode(HttpStatus.OK.value());
		loginResponseDto.setMessage(AppConstant.LOGIN_SCCUESS_MESSAGE);
		return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
	}
}
