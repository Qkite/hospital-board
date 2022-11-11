package com.springboot.hospitalboard.controller;

import com.springboot.hospitalboard.domain.Hospital;
import com.springboot.hospitalboard.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hospital")
@Slf4j
public class HospitalController {

    private final HospitalRepository hospitalRepository;


    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("")
    public String mainDisplay(){

        return "redirect:/hospital/list";
    }


    @GetMapping("/list")
    public String hospitalList(Model model, Pageable pageable){
        Page<Hospital> hospitalList = hospitalRepository.findAll(pageable);
        // pageable을 받고 Page<>의 형태로 넣기

        model.addAttribute("hospitals", hospitalList);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        return "list";
    }
    
    // Pageable만 추가하면 page가 추가가 된다

}

