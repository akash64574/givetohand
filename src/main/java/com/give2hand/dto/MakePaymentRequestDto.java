package com.give2hand.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.give2hand.common.GiveToHandEnum.PaymentType;

import lombok.Data;

@Data
public class MakePaymentRequestDto {
	
	private Integer schemeId;
	private String name;
	private String email;
	private Long phoneNumber;
	private String panNumber;
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;

}
