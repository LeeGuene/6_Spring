package com.example.b_dependency.dependency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

// @SpringBootTest : 테스트용 코드임을 스프링 컨테이너에 알린다.
@SpringBootTest
class DTest1Test {
    
    // 필드 주입
//    @Autowired
//    private DTest1 dTest1;

    // setter 주입
//    private DTest1 dTest1;

//    @Autowired
//    public void setTest1(DTest1 dTest1){
//        this.dTest1 = dTest1;
//    }

    // 생성자 주입 (final 키워드 입력가능)
//    private final DTest1 dTest1;

//    @Autowired
    // @Autowired는 테스트 환경에서는 무조건 붙여야 한다.
//    public DTest1Test(DTest1 dTest1) {
//        this.dTest1 = dTest1;
//    }


//    @Test
//    void print(){
//        DTest1 test1 = new DTest1();
//        test1.print();
//        dTest1.print();
//    }



}






















