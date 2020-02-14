package com.give2hand.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.give2hand.dto.DonationSchemesReponseDto;
import com.give2hand.repository.DonationSchemeRepository;

@RunWith(MockitoJUnitRunner.class)
public class DonationSchemeServiceImplTest {

	@InjectMocks
	DonationSchemeServiceImpl donationSchemeServiceImpl;

	@Mock
	DonationSchemeRepository donationSchemeRepository;

	@Test
	public void testGetAllSchemes() {
		List<DonationSchemesReponseDto> listOfSchemes = new ArrayList<DonationSchemesReponseDto>();
		DonationSchemesReponseDto donationSchemesReponceDto = new DonationSchemesReponseDto();
		donationSchemesReponceDto.setSchemeName("Education");
		DonationSchemesReponseDto donationSchemesReponceDto1 = new DonationSchemesReponseDto();
		donationSchemesReponceDto.setSchemeName("Food");
		listOfSchemes.add(donationSchemesReponceDto);
		listOfSchemes.add(donationSchemesReponceDto1);

		Mockito.when(donationSchemeServiceImpl.getAllSchemes()).thenReturn(listOfSchemes);
		assertEquals(2, listOfSchemes.size());

	}

}
