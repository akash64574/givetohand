package com.give2hand.dto;

import javax.validation.constraints.NotNull;

import com.give2hand.constant.AppConstant;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDto {

	private Long phoneNumber;
	@NotNull(message = AppConstant.PWD_SHOULD_BE_NOT_NULL)
	private String password;
}
