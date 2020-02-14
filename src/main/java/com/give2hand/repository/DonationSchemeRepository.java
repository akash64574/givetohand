package com.give2hand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.give2hand.entity.DonationScheme;

@Repository
public interface DonationSchemeRepository extends JpaRepository<DonationScheme, Integer> {

}
