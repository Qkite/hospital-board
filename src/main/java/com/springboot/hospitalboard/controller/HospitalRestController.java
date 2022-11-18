package com.springboot.hospitalboard.controller;


import com.springboot.hospitalboard.domain.Hospital;
import com.springboot.hospitalboard.domain.HospitalResponse;
import com.springboot.hospitalboard.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

// json 형식으로 데이터를 제공할 수 있음


@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id){
        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        // hospital.of()로 하면 다른 함수가 호출됨?
        return ResponseEntity.ok().body(hospitalResponse); // return은 DTO로
    }


}
