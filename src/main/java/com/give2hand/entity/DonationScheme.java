package com.give2hand.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Amala.S
 * @version V1.1
 * @since 14-02-2020
 *
 */
@Getter
@Setter
@Entity
public class DonationScheme {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer schemeId;
	private String schemeName;
	private String description;
	private Double taxBenefit;
	private Double amount;
	private String imageUrl;

}
