package com.give2hand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.give2hand.dto.GetAllSchemesDto;
import com.give2hand.repository.SchemeRepository;

import lombok.extern.slf4j.Slf4j;

/**
<<<<<<< HEAD:src/main/java/com/give2hand/service/SchemeServiceImpl.java
 * Scheme Service Impl class we are implementing the all details regarding
 * scheme
=======
 * 
>>>>>>> c05c9e2858770054d76b471bfb74bc68b15fc6cf:src/main/java/com/give2hand/service/UserDonationSchemeServiceImpl.java
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
<<<<<<< HEAD:src/main/java/com/give2hand/service/SchemeServiceImpl.java
public class SchemeServiceImpl implements SchemeService {
	@Autowired
	SchemeRepository schemeRepository;

	@Override
	public List<GetAllSchemesDto> getAllSchemes() {
		
		
		
		// TODO Auto-generated method stub
		return null;
	}
=======
public class UserDonationSchemeServiceImpl implements UserDonationSchemeService{
>>>>>>> c05c9e2858770054d76b471bfb74bc68b15fc6cf:src/main/java/com/give2hand/service/UserDonationSchemeServiceImpl.java

}
