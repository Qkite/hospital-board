package com.springboot.hospitalboard.repository;

import com.springboot.hospitalboard.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByHospitalNameContaining(String keyword);

}

