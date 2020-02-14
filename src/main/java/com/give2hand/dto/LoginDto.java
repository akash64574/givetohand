package com.give2hand.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDto extends ResponseDto {

	private Integer userId;
	private String name;
}
