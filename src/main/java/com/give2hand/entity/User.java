package com.give2hand.entity;

import java.time.LocalDate;

import javax.persistence.Column;
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
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String name;
	private String emailAddress;
	@Column(unique=true)
	private Long phoneNumber;
	private String password;
	private String panNumber;

}
