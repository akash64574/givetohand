package com.give2hand.service;

import com.give2hand.dto.LoginRequestDto;
import com.give2hand.dto.LoginDto;
import com.give2hand.exception.UserNotFoundException;

public interface UserService {

	public LoginDto userLogin(LoginRequestDto loginRequestDto) throws UserNotFoundException;
}
