package koreait.spring.springtest1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // http://localhost:8080/test 주소로 테스트 가능
    // @GetMapping 어노테이션 뒤로 아무것도 입력하지 않으면 서버의 기본주소로 매핑된다. (http:://localhost:8080)
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
