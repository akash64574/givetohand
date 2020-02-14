package com.give2hand.dto;

import lombok.Data;

@Data
public class MakePaymentRequestDto {
	
	private Integer schemeId;
	private String userName;
	private String email;
	private Long mobile;
	private String panNumber;

}
