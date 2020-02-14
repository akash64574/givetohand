package com.give2hand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.give2hand.entity.DonationScheme;
import com.give2hand.entity.UserDonationScheme;

@Repository
public interface UserDonationSchemeRepository extends JpaRepository<UserDonationScheme, Integer> {

	List<UserDonationScheme> findAllByScheme(DonationScheme donationScheme);

}
