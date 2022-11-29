package com.mustache.hospitals.controller;

import com.mustache.hospitals.dto.HospitalDto;
import com.mustache.hospitals.entity.Hospital;
import com.mustache.hospitals.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/hospitals")
@Slf4j
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/new")
    public String createArticleForm() {
        return "new";
    }

    @PostMapping("")
    public String createArticle(HospitalDto hospitalDto) {
        Hospital savedHospital = hospitalRepository.save(hospitalDto.toEntity());
        return String.format("redirect:/hospitals/%d", savedHospital.getId());
    }

    @GetMapping("/{id}")
    public String selectById(@PathVariable Integer id, Model model) {
        Optional<Hospital> optHospital = hospitalRepository.findById(id);
        if (!optHospital.isEmpty()) {
            model.addAttribute("hospitals", optHospital.get());
            return "show";
        } else {
            return "error";
        }
    }

    @GetMapping("")
    public String list(Pageable pageable, Model model) {
        Page<Hospital> hospitals = hospitalRepository.findAll(pageable);
        log.info("size:{}", hospitals.getSize()); // 로그찍기
        model.addAttribute("hospitals", hospitals);
        // page 연결시켜주기
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        return "list";
        //http://localhost:8080/hospitals?page=1 로 페이지 검색가능
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model, HospitalDto hospitalDto) {
        Hospital hospital = hospitalRepository.save(hospitalDto.toEntity());
        model.addAttribute("hospitals", hospital);
        return String.format("redirect:/hospitals/%d", hospital.getId());
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        if (!optionalHospital.isEmpty()) {
            model.addAttribute("hospitals", optionalHospital.get());
            return "show";
        } else {
            return "error";
        }
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        hospitalRepository.deleteById(id);
        model.addAttribute("hospitals", hospitalRepository.findAll());
        return "list";
    }
}
