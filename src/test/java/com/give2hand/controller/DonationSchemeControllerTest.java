package com.give2hand.controller;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.give2hand.dto.DonorResponseDto;
import com.give2hand.dto.DonorsDto;
import com.give2hand.dto.SchemeChartDto;
import com.give2hand.dto.SchemeStatisticResponseDto;
import com.give2hand.entity.DonationScheme;
import com.give2hand.exception.SchemeNotFoundException;
import com.give2hand.service.DonationSchemeService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DonationSchemeControllerTest {
	@InjectMocks
	DonationSchemeController donationSchemeController;
	@Mock
	DonationSchemeService donationSchemeService;

	DonationScheme donationScheme = new DonationScheme();

	SchemeChartDto schemeChartDto = new SchemeChartDto();
	List<SchemeChartDto> schemeCharts = new ArrayList<>();

	@Before
	public void init() {
		schemeChartDto.setSchemeId(1);
		schemeChartDto.setCount(1);

		schemeCharts.add(schemeChartDto);
	}

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
		assertThat(allSchemes.getBody()).hasSize(2);
	}

	@Test
	public void testGetStatisticsForScheme() {
		when(donationSchemeService.getStatisticsForScheme()).thenReturn(schemeCharts);
		ResponseEntity<SchemeStatisticResponseDto> response = donationSchemeController.getStatisticsForScheme();
		assertThat(response.getBody().getSchemes()).hasSize(1);
	}
	
	@Test
	public void testGetSchemeBySchemeId() throws SchemeNotFoundException {
		List<DonorsDto> doctors = new ArrayList<>();
		when(donationSchemeService.getSchemeBySchemeId(1)).thenReturn(doctors);
		ResponseEntity<DonorResponseDto> response = donationSchemeController.getSchemeBySchemeId(1);
		assertEquals(200, response.getBody().getStatusCode());
		
	}

}
