package com.give2hand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.give2hand.entity.DonationScheme;
import com.give2hand.entity.Scheme;

public interface DonationSchemeRepository extends JpaRepository<DonationScheme, Integer> {

}
