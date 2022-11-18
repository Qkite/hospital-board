package com.springboot.hospitalboard.service;

import com.springboot.hospitalboard.domain.Hospital;
import com.springboot.hospitalboard.domain.HospitalResponse;
import com.springboot.hospitalboard.repository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HospitalServiceTest {

    private HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);

    HospitalService hospitalService;

    @BeforeEach
    void setting(){
        hospitalService = new HospitalService(hospitalRepository);
    }


    @Test
    void test(){
        Hospital hospital = new Hospital(12, 1, 1,0,0);
        Hospital hospital1 = new Hospital(14, 3, 1,0,0);

        Mockito.when(hospitalRepository.findById(12))
                .thenReturn(Optional.of(hospital));


        HospitalResponse hospitalResponse = hospitalService.getHospital(12);
        assertEquals(hospitalResponse.getBusinessStatusName(), "영업중");

        Mockito.when(hospitalRepository.findById(14))
                .thenReturn(Optional.of(hospital1));
        HospitalResponse hospitalResponse1 = hospitalService.getHospital(14);
        assertEquals(hospitalResponse1.getBusinessStatusName(), "폐업");









    }




}