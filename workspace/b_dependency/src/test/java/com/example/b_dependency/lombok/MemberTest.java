package com.example.b_dependency.lombok;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberTest {

    @Test
    void test(){
        // @AllArgsConstructor 테스트
        // Member member = new Member("이근", 35, "남", "안양시 동안구");

        // @NoArgsConstructor 테스트
        Member member = new Member();

        // @RequiredArgsConstructor , @NonNull 테스트
        Member member1 = new Member("이근", 35);

        // Object 클래스의 toString() 메서드
        // member.toString();

        // @Getter 테스트
//        member.getAddress();
//        member.getAge();
//        member.getGender();

        // @Setter 테스트
//        member.setAddress("경기도 안양시");
//        member.setAge(35);
//        member.setName("이근");
        
        // @ToString 테스트
        log.info(member1.toString());



    }

}
