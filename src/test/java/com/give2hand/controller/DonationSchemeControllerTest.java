package com.give2hand.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.give2hand.dto.SchemeChartDto;
import com.give2hand.dto.SchemeStatisticResponseDto;
import com.give2hand.service.DonationSchemeService;

@RunWith(MockitoJUnitRunner.class)
public class DonationSchemeControllerTest {

	@InjectMocks
	DonationSchemeController donationSchemeController;

	@Mock
	DonationSchemeService donationSchemeService;
	
	SchemeChartDto schemeChartDto = new SchemeChartDto();
	List<SchemeChartDto> schemeCharts = new ArrayList<>();

	@Before
	public void init() {
		schemeChartDto.setSchemeId(1);
		schemeChartDto.setCount(1);
		
		schemeCharts.add(schemeChartDto);
	}

	@Test
	public void testGetStatisticsForScheme() {
		when(donationSchemeService.getStatisticsForScheme()).thenReturn(schemeCharts);
		ResponseEntity<SchemeStatisticResponseDto> response = donationSchemeController.getStatisticsForScheme();
		assertThat(response.getBody().getSchemes()).hasSize(1);
	}

}
