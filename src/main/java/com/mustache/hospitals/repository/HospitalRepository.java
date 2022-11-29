package com.mustache.hospitals.repository;

import com.mustache.hospitals.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    // findBYBusinessTypeNameIn 사용하기 In 연산자 사용
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
}
