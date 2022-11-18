package com.springboot.hospitalboard.controller;

import com.springboot.hospitalboard.domain.Hospital;
import com.springboot.hospitalboard.domain.HospitalResponse;
import com.springboot.hospitalboard.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/hospital")
@Slf4j
public class HospitalController {

    private final HospitalRepository hospitalRepository;


    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

//    @GetMapping("")
//    public String mainDisplay(){
//
//        return "redirect:/hospital/list";
//    }


    @GetMapping("/list")
    public String hospitalList(Model model, @PageableDefault(page=1, size=20)
    @SortDefault.SortDefaults({@SortDefault(sort="healthcare_provider_count",
            direction = Sort.Direction.DESC),
            @SortDefault(sort = "patient_room_count",
                    direction = Sort.Direction.DESC)}) Pageable pageable){
        Page<Hospital> hospitalList = hospitalRepository.findAll(pageable);
        // pageable을 받고 Page<>의 형태로 넣기

        model.addAttribute("hospitals", hospitalList);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        return "list";
    }
    
    // Pageable만 추가하면 page가 추가가 된다

    @GetMapping("/search")
    public String search(String keyword, Model model){

        List<Hospital> searchList = hospitalRepository.findByHospitalNameContaining(keyword);

        model.addAttribute("searchList", searchList);

        return "search";
    }

    @GetMapping("")
    public String findHospitalUsingAddress(@RequestParam(required = false) String keyword, @PageableDefault(page=1, size=20) Pageable pageable , Model model){

        Page<Hospital> hospitalList = hospitalRepository.findByRoadNameAddressContaining(keyword, pageable);

        model.addAttribute("hospitals", hospitalList);
        model.addAttribute("keyword", keyword);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());

        return "list";
    }

}

