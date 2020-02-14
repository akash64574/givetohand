package com.give2hand.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DonationSchemesReponseDto {
	private Integer schemeId;
	private String schemeName;
	private String description;
	private Double taxBenefit;
	private Double amount;
	private String imageUrl;

}
