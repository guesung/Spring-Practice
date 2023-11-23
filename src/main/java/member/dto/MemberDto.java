package member.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import member.entity.JobEnum;
import member.entity.Member;

@Data
@AllArgsConstructor
public class MemberDto {
  private Long id;

  @NotBlank(message = "이름은 반드시 입력해야 합니다.")
  private String username;

  @NotBlank(message = "이메일은 반드시 입력해야 합니다.")
  @Email(message = "이메일 형식을 반드시 지켜야 합니다.")
  private String email;

  @NotBlank(message = "전화번호는 반드시 입력해야 합니다.")
  private String phoneNumber;

  private JobEnum job;

  public static MemberDto of(Member member) {
    return new MemberDto(member.getId(), member.getUsername(), member.getEmail(), member.getMemberInfo().getPhoneNumber(), member.getMemberInfo().getJob());
  }
}

