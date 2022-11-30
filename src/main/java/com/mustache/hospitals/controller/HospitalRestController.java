package com.mustache.hospitals.controller;

import com.mustache.hospitals.dto.HospitalResponse;
import com.mustache.hospitals.entity.Hospital;
import com.mustache.hospitals.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController // 쓰는 이유 데이터를 ui로 전달하지 않고 json형식으로 데이터를 전달하기 위해 사용
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalRepository hospitalRepository;

    public HospitalRestController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/{id}")
    // hospital을 hospitalResponse로 바꿔줌
    // ResponseEntity<HospitalResponse>이거 사용해서 ison으로 전달하는거야
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) { // ResponseEntity도 DTO로
        Optional<Hospital> hospital = hospitalRepository.findById(id); //Entity
        HospitalResponse hospitalResponse = Hospital.of(hospital.get()); // DTO
        return ResponseEntity.ok().body(hospitalResponse); // Return은 DTO로
    }
    // 결과 잘나옴
    // {"id":2321,"roadNameAddress":"노소아청소년과의원",
    // "hospitalName":"서울특별시 서초구 서초중앙로 230, 202호 (반포동, 동화반포프라자빌딩)",
    // "patientRoomCount":0,"totalNumberOfBeds":0,"businessTypeName":"의원","totalAreaSize":0.0}
}


