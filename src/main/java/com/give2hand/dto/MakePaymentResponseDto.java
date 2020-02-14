package com.give2hand.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MakePaymentResponseDto {

	private Integer donationId;
	private Integer statusCode;
	private String message;

}
