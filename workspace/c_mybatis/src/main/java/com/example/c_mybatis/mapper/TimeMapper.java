package com.example.c_mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

// Mapper 어노테이션
// 데이터 베이스의 작업(select, update, delete, insert)을 추상화하여
// 코드 내에서 간단하게 호출할 수 있는 메서드로 변환한다. -->
// 작업의 결과도, 쿼리 내에 들어가는 파라미터(변수)도 자동으로 매핑을 해주는 역할을 합니다.
@Mapper
public interface TimeMapper {

    // SQL과 매핑할 메서드
    String getTime();

}
