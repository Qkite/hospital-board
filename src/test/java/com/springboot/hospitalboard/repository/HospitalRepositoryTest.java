package com.springboot.hospitalboard.repository;

import com.springboot.hospitalboard.domain.Hospital;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    void test1(){
        List<String> category = new ArrayList<>();
        category.add("보건지소");
        category.add("보건소");
        category.add("보건진료소");

        List<Hospital> hospitalList = hospitalRepository.findByBusinessTypeNameIn(category);
        for (Hospital hospital:hospitalList) {
            System.out.println(hospital.getHospitalName());

        }
    }


}