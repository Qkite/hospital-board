package com.springboot.hospitalboard.repository;

import com.springboot.hospitalboard.domain.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByHospitalNameContaining(String keyword);
    List<Hospital> findByBusinessTypeNameIn(List<String> categoryList);

    List<Hospital> findByBusinessTypeNameInAndRoadNameAddressContaining(List<String> categoryList, String roadNameAddress);

    List<Hospital> findByTotalNumberOfBedsBetween(int num1, int num2);

    List<Hospital> findByTotalNumberOfBedsBetweenOrderByPatientRoomCountDesc(int start, int end);

    List<Hospital> findByTotalNumberOfBedsBetweenOrderByTotalNumberOfBedsDesc(int start, int i);

    List<Hospital> findByRoadNameAddressContainingOrderByPatientRoomCount(String address);

    Page<Hospital> findByRoadNameAddressContaining(String keyword, Pageable pageable);
}

