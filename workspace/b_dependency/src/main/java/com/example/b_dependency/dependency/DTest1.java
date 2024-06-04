package com.example.b_dependency.dependency;

import org.springframework.stereotype.Component;

// @Component : 스프링 컨테이너에 클래스를 등록한다.
@Component
public class DTest1 {

    public void print(){
        System.out.println("DTest1 테스트 중~~");
    }

}
