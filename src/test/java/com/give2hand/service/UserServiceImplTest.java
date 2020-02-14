package com.give2hand.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.give2hand.dto.LoginRequestDto;
import com.give2hand.dto.LoginDto;
import com.give2hand.entity.User;
import com.give2hand.exception.UserNotFoundException;
import com.give2hand.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;

	LoginRequestDto loginRequestDto = new LoginRequestDto();
	User user = new User();

	@Before
	public void init() {
		loginRequestDto.setPhoneNumber(8675958381L);
		loginRequestDto.setPassword("start@123");
		
		user.setUserId(1);
	}

	@Test
	public void testUserLogin() throws UserNotFoundException {
		when(userRepository.findByPhoneNumberAndPassword(loginRequestDto.getPhoneNumber(),
				loginRequestDto.getPassword())).thenReturn(Optional.of(user));
		LoginDto response = userServiceImpl.userLogin(loginRequestDto);
		assertEquals(1, response.getUserId());
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testUserLoginForUserNotFoundEx() throws UserNotFoundException {
		when(userRepository.findByPhoneNumberAndPassword(loginRequestDto.getPhoneNumber(),
				loginRequestDto.getPassword())).thenReturn(Optional.ofNullable(null));
		userServiceImpl.userLogin(loginRequestDto);
	}
}
