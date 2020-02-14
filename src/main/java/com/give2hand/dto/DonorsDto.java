package com.give2hand.dto;

import com.give2hand.common.GiveToHandEnum.PaymentType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DonorsDto {
	private String userName;
	private String emailAddress;
	private Long phoneNumber;
	private String panNumber;
	private Double taxBenefit;
	private Double amount;
	private PaymentType paymentType;
}
