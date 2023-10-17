package com.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter // getter 메소드 자동 생성
@Setter // setter 메소드 자동 생성
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자
@ToString // toString 메소드 자동 생성
@NoArgsConstructor // 기본 생성자
@Data
public class Member {
  private Integer id;

  @NotBlank(message = "이름을 입력해주세요.")
  private String username;

  @NotBlank(message = "이메일을 입력해주세요.")
  @Email(message = "이메일 형식이 올바르지 않습니다.")
  private String email;
}
