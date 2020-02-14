package com.give2hand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.give2hand.entity.DonationScheme;
import com.give2hand.repository.DonationSchemeRepository;

/**
 * Scheme Service Impl class we are implementing the all details regarding scheme
 * 
 * 
 * @author Amala .S
 * @since 14-02-2020
 * @version V1.1
 * 
 *
 */
@Service
public class DonationSchemeServiceImpl implements DonationSchemeService{

	@Autowired
	DonationSchemeRepository donationSchemeRepository;
	@Override
	public List<DonationScheme> getAllSchemes() {
		return donationSchemeRepository.findAll();
	}

}
