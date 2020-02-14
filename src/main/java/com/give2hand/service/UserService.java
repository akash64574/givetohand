package com.give2hand.service;

import com.give2hand.dto.LoginRequestDto;
import com.give2hand.dto.LoginResponseDto;
import com.give2hand.exception.UserNotFoundException;

public interface UserService {

	public LoginResponseDto userLogin(LoginRequestDto loginRequestDto) throws UserNotFoundException;
}
