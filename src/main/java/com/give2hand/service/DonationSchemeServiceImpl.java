package com.give2hand.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.give2hand.constant.AppConstant;
import com.give2hand.dto.DonationSchemesReponseDto;
import com.give2hand.dto.DonorsDto;
import com.give2hand.dto.SchemeChartDto;
import com.give2hand.entity.DonationScheme;
import com.give2hand.entity.UserDonationScheme;
import com.give2hand.exception.SchemeNotFoundException;
import com.give2hand.repository.DonationSchemeRepository;
import com.give2hand.repository.UserDonationSchemeRepository;
import com.give2hand.repository.UserRepository;

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
public class DonationSchemeServiceImpl implements DonationSchemeService {
	@Autowired
	DonationSchemeRepository donationSchemeRepository;
	@Autowired
	UserDonationSchemeRepository userDonationSchemeRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public List<DonationSchemesReponseDto> getAllSchemes() {
		List<DonationScheme> allSchemes = donationSchemeRepository.findAll();
		List<DonationSchemesReponseDto> donationSchemesReponceDtos = new ArrayList<>();

		allSchemes.forEach(allScheme -> {

			DonationSchemesReponseDto donationSchemesReponceDto = new DonationSchemesReponseDto();
			BeanUtils.copyProperties(allScheme, donationSchemesReponceDto);
			donationSchemesReponceDtos.add(donationSchemesReponceDto);
		});
		return donationSchemesReponceDtos;

	}

	@Override
	public List<DonorsDto> getSchemeBySchemeId(Integer schemeId) throws SchemeNotFoundException {
		Optional<DonationScheme> donationScheme = donationSchemeRepository.findById(schemeId);

		if (!donationScheme.isPresent()) {
			throw new SchemeNotFoundException(AppConstant.SCHEME_NOT_FOUND);
		}

		DonorsDto donorsDto = new DonorsDto();

		donorsDto.setTaxBenefit(donationScheme.get().getTaxBenefit());
		donorsDto.setAmount(donationScheme.get().getAmount());

		List<UserDonationScheme> allDonors = userDonationSchemeRepository.findAllByScheme(donationScheme.get());
		List<DonorsDto> donorDto = allDonors.stream().map(this::convertEntityToDto).collect(Collectors.toList());
		BeanUtils.copyProperties(donorsDto, donorDto);
		return donorDto;
	}

	private DonorsDto convertEntityToDto(UserDonationScheme userDonationScheme) {
		log.info("converting the user detail to dto...");
		DonorsDto donorDto = new DonorsDto();
		donorDto.setUserName(userDonationScheme.getName());
		donorDto.setPhoneNumber(userDonationScheme.getPhoneNumber());
		donorDto.setPanNumber(userDonationScheme.getPanNumber());
		donorDto.setPaymentType(userDonationScheme.getPaymentType());
		return donorDto;

	}

	/**
	 * Get the scheme statistics for the schemes.
	 * 
	 * @return list of scheme details with count and percentage
	 * @author Govindasamy.C
	 * @since 14-02-2020
	 */
	@Override
	public List<SchemeChartDto> getStatisticsForScheme() {
		log.info("get the statistic for schemes in service method...");

		// Get all the user donation schemes.
		log.debug("before calling the user donation history in service method...");
		List<UserDonationScheme> userDonations = userDonationSchemeRepository.findAll();
		Integer totalUserDonationCount = userDonations.size();
		List<SchemeChartDto> schemeChartDtos = new ArrayList<>();

		log.info("filtered schemes from getting user donations...");
		Map<DonationScheme, Integer> filteredSchemes = userDonations.stream()
				.collect(Collectors.groupingBy(UserDonationScheme::getScheme, Collectors.collectingAndThen(
						Collectors.mapping(UserDonationScheme::getScheme, Collectors.toList()), List::size)));
		filteredSchemes.forEach((donationScheme, schemeCount) -> {
			log.info("convert the each scheme to scheme detail list...");
			SchemeChartDto schemeChartDto = new SchemeChartDto();
			BeanUtils.copyProperties(donationScheme, schemeChartDto);
			schemeChartDto.setCount(schemeCount);
			// Calculate the percentage value.
			Double schemePercentage = calculatePercentage(totalUserDonationCount, schemeCount);
			schemeChartDto.setY(schemePercentage);
			log.info("before add the scheme detail to schemes list...");
			schemeChartDtos.add(schemeChartDto);
		});
		return schemeChartDtos;
	}

	/**
	 * Calculate the percentage value for the schemes.
	 * 
	 * @param totalCount - total scheme counts
	 * @param schemeCount - count of the scheme
	 * @return calculated the percentage value of the activity.
	 * @author Govindasamy.C
	 * @since 14-02-2020
	 */
	private Double calculatePercentage(Integer totalCount, Integer schemeCount) {
		log.info("calculatePercentage method - calculating the percentage for schemes");
		return ((Double.valueOf(schemeCount) * 100) / totalCount);
	}

}
