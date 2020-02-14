package com.give2hand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.give2hand.dto.GetAllSchemesDto;
import com.give2hand.repository.SchemeRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Scheme Service Impl class we are implementing the all details regarding
 * scheme
 * 
 * 
 * @author Amala .S
 * @since 14-02-2020
 * @version V1.1
 * 
 *
 */
@Service
@Slf4j
public class SchemeServiceImpl implements SchemeService {
	@Autowired
	SchemeRepository schemeRepository;

	@Override
	public List<GetAllSchemesDto> getAllSchemes() {
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
