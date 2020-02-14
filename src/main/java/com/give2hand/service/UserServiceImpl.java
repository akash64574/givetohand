package com.give2hand.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.give2hand.constant.AppConstant;
import com.give2hand.dto.LoginRequestDto;
import com.give2hand.dto.LoginResponseDto;
import com.give2hand.entity.User;
import com.give2hand.exception.UserNotFoundException;
import com.give2hand.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * User Service Impl class we are implementing the user login activies for
 * phonenumber and password.
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
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public LoginResponseDto userLogin(LoginRequestDto loginRequestDto) throws UserNotFoundException {
		log.info("check the user login based on the phone number and password...");
		Optional<User> user = userRepository.findByPhoneNumberAndPassword(loginRequestDto.getPhoneNumber(),
				loginRequestDto.getPassword());
		if (!user.isPresent()) {
			throw new UserNotFoundException(AppConstant.INVALID_LOGIN);
		}
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		BeanUtils.copyProperties(user.get(), loginResponseDto);
		return loginResponseDto;
	}

}
