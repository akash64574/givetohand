package com.give2hand.service;

import java.util.List;

import com.give2hand.dto.DonationSchemesReponseDto;
import com.give2hand.dto.DonorsDto;
import com.give2hand.dto.SchemeChartDto;
import com.give2hand.exception.SchemeNotFoundException;

public interface DonationSchemeService {

	List<DonationSchemesReponseDto> getAllSchemes();

	List<DonorsDto> getSchemeBySchemeId(Integer schemeId) throws SchemeNotFoundException;

	public List<SchemeChartDto> getStatisticsForScheme();

}
