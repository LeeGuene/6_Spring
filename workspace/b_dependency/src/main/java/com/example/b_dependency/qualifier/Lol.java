package com.example.b_dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Slf4j
// 2. 구현체(클래스)에 직접 설정
// @Primary : 해당 구현체를 먼저 실행하도록 설정하는 어노테이션
@Primary
public class Lol implements Game{

    @Override
    public void play() {
        log.info("Playing Lol");
    }
}
