package com.give2hand.service;

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

import com.give2hand.dto.SchemeChartDto;
import com.give2hand.entity.DonationScheme;
import com.give2hand.entity.UserDonationScheme;
import com.give2hand.repository.UserDonationSchemeRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DonationSchemeServiceImplTest {

	@InjectMocks
	DonationSchemeServiceImpl donationSchemeServiceImpl;
	
	@Mock
	UserDonationSchemeRepository userDonationSchemeRepository;

	List<UserDonationScheme> schemeCharts = new ArrayList<>();
	UserDonationScheme userDonationScheme = new UserDonationScheme();
	DonationScheme donationScheme = new DonationScheme();

	@Before
	public void init() {
		
		donationScheme.setSchemeId(1);
		userDonationScheme.setScheme(donationScheme);
		
		schemeCharts.add(userDonationScheme);
	}
	
	@Test
	public void testGetStatisticsForScheme() {
		when(userDonationSchemeRepository.findAll()).thenReturn(schemeCharts);
		List<SchemeChartDto> response = donationSchemeServiceImpl.getStatisticsForScheme();
		assertThat(response).hasSize(1);
	}
}
