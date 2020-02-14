package com.give2hand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.give2hand.entity.Scheme;
import com.give2hand.entity.User;

public interface SchemeRepository extends JpaRepository<Scheme, Integer> {

}
