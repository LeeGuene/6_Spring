package com.example.b_dependency.qualifier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameTest {

    // 1. 주입받는 측에서 특정 구현체를 설정
    // @Qualifier : 특정 구현체를 실행하도록 설정 (소괄호 안에 구현체(클래스) 이름을 입력)
    // 반드시 쌍 따옴표 안에 구현체 이름을 입력해야 한다.
    @Autowired
    // @Qualifier("starCraft")
    private Game game;

    @Test
    void test(){
        // 스프링 컨테이너(인터페이스)을 구현한 구현체가 여러 개인 경우 ( 구현체 내 메서드 이름이 동일하다고 가정 )
        // 어떤 구현체의 메서드를 실행해야할지 알 수 없다.
        game.play();
    }
}
