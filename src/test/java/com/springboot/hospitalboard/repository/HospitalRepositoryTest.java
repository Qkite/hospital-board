package com.springboot.hospitalboard.repository;

import com.springboot.hospitalboard.domain.Hospital;
import com.springboot.hospitalboard.domain.Visit;
import org.junit.jupiter.api.DisplayName;
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

    @Autowired
    VisitRepository visitRepository;

    @Test
    void test1(){
        List<String> category = new ArrayList<>();
        category.add("보건지소");
        category.add("보건소");
        category.add("보건진료소");

//        List<Hospital> hospitalList = hospitalRepository.findByBusinessTypeNameIn(category);
//        for (Hospital hospital:hospitalList) {
//            System.out.println(hospital.getHospitalName());
//
//        }

        List<Hospital> hospitalList1 = hospitalRepository.findByBusinessTypeNameInAndRoadNameAddressContaining(category, "서울특별시 성북구");
        for (Hospital hospital:hospitalList1) {
            System.out.println(hospital.getHospitalName());

        }


    }

    @Test
    @DisplayName("병상 수가 10개 이상 20개 미만인 병원 리스트")
    void test2(){
        int start = 10;
        int end = 20;
        List<Hospital> hospitalList2 = hospitalRepository.findByTotalNumberOfBedsBetweenOrderByTotalNumberOfBedsDesc(start,end-1);

        for (Hospital hospital:hospitalList2) {
            System.out.print("병원명: " + hospital.getHospitalName());
            System.out.println(", 병상수: " + hospital.getTotalNumberOfBeds());

        }

    }

    @Test
    @DisplayName("서울시 병원 입원실 수 기준으로 정렬")
    void test3(){

        List<Hospital> hospitalList3 = hospitalRepository.findByRoadNameAddressContainingOrderByPatientRoomCount("서울특별시");

        for (Hospital hospital:hospitalList3) {
            System.out.print("병원명: " + hospital.getHospitalName());
            System.out.println(", 입원실수: " + hospital.getPatientRoomCount());
            System.out.println();


        }

    }

    @Test
    @DisplayName("Auditing이 제대로 작동하는지 테스트")
    public void auditingTest(){

        Visit visit = new Visit("손목통증", 2000);

        Visit visit1 = visitRepository.save(visit);

        System.out.println(visit1.getDisease());
        System.out.println(visit1.getCreatedAt());
    }


}