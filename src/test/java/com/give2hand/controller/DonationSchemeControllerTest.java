package com.give2hand.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.give2hand.dto.DonationSchemesReponseDto;
import com.give2hand.dto.DonorsDto;
import com.give2hand.dto.DonorsResponseDto;
import com.give2hand.entity.DonationScheme;
import com.give2hand.exception.SchemeNotFoundException;
import com.give2hand.service.DonationSchemeService;

@RunWith(MockitoJUnitRunner.class)
public class DonationSchemeControllerTest {
	@InjectMocks
	DonationSchemeController donationSchemeController;
	@Mock
	DonationSchemeService donationSchemeService;
	
	DonationScheme donationScheme=new DonationScheme();


	@Test
	public void testGetAllSchemes() {
		List<DonationSchemesReponseDto> listOfSchemes = new ArrayList<DonationSchemesReponseDto>();
		DonationSchemesReponseDto donationSchemesReponceDto = new DonationSchemesReponseDto();
		donationSchemesReponceDto.setSchemeName("Education");
		DonationSchemesReponseDto donationSchemesReponceDto1 = new DonationSchemesReponseDto();
		donationSchemesReponceDto.setSchemeName("Food");
		listOfSchemes.add(donationSchemesReponceDto);
		listOfSchemes.add(donationSchemesReponceDto1);

		Mockito.when(donationSchemeService.getAllSchemes()).thenReturn(listOfSchemes);
		ResponseEntity<List<DonationSchemesReponseDto>> allSchemes = donationSchemeController.getAllSchemes();
		assertEquals(2, listOfSchemes.size());
	}

	



}
