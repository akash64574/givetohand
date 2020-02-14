package com.give2hand.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponseDto extends ResponseDto {

	private Integer userId;
	private String name;
}
