--전체찾기--
SELECT * FROM `likelion-db`.nation_wide_hospitals limit 100;

--경기도 수원시에 있는 피부과 찾기--
SELECT hospital_name, road_name_address FROM `likelion-db`.nation_wide_hospitals
where road_name_address like "경기도 수원시%"
;

SELECT hospital_name, road_name_address FROM `likelion-db`.nation_wide_hospitals
where road_name_address like "경기도 수원시%"
  and hospital_name like "%피부과%"
;

--business_type_name 보건소, 보건지소인 데이터--
SELECT business_type_name, hospital_name, road_name_address
FROM `likelion-db`.nation_wide_hospitals
where business_type_name in ('보건소', '보건지소')
;