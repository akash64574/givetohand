package com.give2hand.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.give2hand.dto.LoginRequestDto;
import com.give2hand.dto.LoginDto;
import com.give2hand.exception.UserNotFoundException;
import com.give2hand.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@InjectMocks
	LoginController loginController;

	@Mock
	UserService userService;

	LoginRequestDto loginRequestDto = new LoginRequestDto();
	@Before
	public void init() {
		loginRequestDto.setPhoneNumber(8675958381L);
		loginRequestDto.setPassword("start@123");
	}

	@Test
	public void testUserLogin() throws UserNotFoundException {
          when(userService.userLogin(loginRequestDto)).thenReturn(new LoginDto());
          ResponseEntity<LoginDto> response = loginController.userLogin(loginRequestDto);
          assertEquals(200, response.getBody().getStatusCode());
	}

}
