package com.example.b_dependency.lombok;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Member {

    @NonNull
    private String name;

    @NonNull
    private int age;
    private String gender;
    private String address;

}
