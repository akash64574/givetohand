package com.give2hand.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.give2hand.common.GiveToHandEnum.PaymentStatus;
import com.give2hand.common.GiveToHandEnum.PaymentType;

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
public class UserDonationScheme {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer donationId;
	@ManyToOne
	@JoinColumn(name = "scheme_id")
	private DonationScheme scheme;
	private String taxCertificateUrl;
	private String name;
	private Long phoneNumber;
	private String panNumber;
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStaus;

}
