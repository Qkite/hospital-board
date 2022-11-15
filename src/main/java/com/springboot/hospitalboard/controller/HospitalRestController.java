package com.springboot.hospitalboard.controller;


import com.springboot.hospitalboard.domain.Hospital;
import com.springboot.hospitalboard.domain.HospitalResponse;
import com.springboot.hospitalboard.repository.HospitalRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    private final HospitalRepository hospitalRepository;

    public HospitalRestController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;

    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id){
        Optional<Hospital> hospital = hospitalRepository.findById(id); // entity
        HospitalResponse hospitalResponse = new HospitalResponse(); // DTO
        return ResponseEntity.ok().body(hospitalResponse); // return은 DTO로
    }
}
