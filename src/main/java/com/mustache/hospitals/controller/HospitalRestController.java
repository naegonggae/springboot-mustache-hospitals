package com.mustache.hospitals.controller;

import com.mustache.hospitals.dto.HospitalResponse;
import com.mustache.hospitals.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Api란 Json형식으로 데이터를 리턴해주는 서버 프로그램이다.
// 프레젠트 영역
@RestController // 쓰는 이유 데이터를 ui로 전달하지 않고 json형식으로 데이터를 전달하기 위해 사용
@RequestMapping("/api/v1/hospitals") // api를 쓰겠다고 암시해줌
public class HospitalRestController {

    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    // 목적 : hospital(entity)을 hospitalResponse(Dto)로 바꿔줌
    // ResponseEntity<HospitalResponse(Dto)>이거 사용하면 json형식으로 전달할 수 있어
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) { // ResponseEntity를 DTO로
        //Optional<Hospital> hospital = hospitalRepository.findById(id); //Entity
        HospitalResponse hospitalResponse = hospitalService.getHospital(id); // DTO
        return ResponseEntity.ok().body(hospitalResponse); // Return은 DTO로
    }
    // 결과 잘나옴
    // {"id":2321,"roadNameAddress":"노소아청소년과의원",
    // "hospitalName":"서울특별시 서초구 서초중앙로 230, 202호 (반포동, 동화반포프라자빌딩)",
    // "patientRoomCount":0,"totalNumberOfBeds":0,"businessTypeName":"의원","totalAreaSize":0.0}
}


