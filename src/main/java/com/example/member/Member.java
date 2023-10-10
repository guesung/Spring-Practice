package com.example.member;

import lombok.*;

@Getter // getter 메소드 자동 생성
@Setter // setter 메소드 자동 생성
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자
@ToString // toString 메소드 자동 생성
@NoArgsConstructor // 기본 생성자
public class Member {
    private Integer id;
    private String name;
    private String email;
}
