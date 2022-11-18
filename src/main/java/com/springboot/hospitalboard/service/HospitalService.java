package com.springboot.hospitalboard.service;

import com.springboot.hospitalboard.domain.Hospital;
import com.springboot.hospitalboard.domain.HospitalResponse;
import com.springboot.hospitalboard.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;


    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse getHospital(Integer id){

        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        Hospital hospital = optionalHospital.get();
        HospitalResponse hospitalResponse = Hospital.of(hospital);
        if(hospital.getBusinessStatus() == 1){
            hospitalResponse.setBusinessStatusName("영업중");
        } else if (hospital.getBusinessStatus() == 2) {
            hospitalResponse.setBusinessStatusName("휴업");
        } else if (hospital.getBusinessStatus() == 3) {
            hospitalResponse.setBusinessStatusName("폐업");
        } else if (hospital.getBusinessStatus() == 4) {
            hospitalResponse.setBusinessStatusName("말소");
        }

        return hospitalResponse;
    }




}
