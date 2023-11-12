package member;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Member {
  @Id
  @Column(name = "member_id", nullable = false, unique = true)
  private Long id;

  @OneToOne
  @JoinColumn(name = "member_info_id")
  private MemberInfo memberInfo;

  @NotBlank(message = "이름을 입력해주세요.")
  @Email(message = "이름 형식이 올바르지 않습니다.")
  @Column(nullable = false, unique = true)
  private String username;

  @NotBlank(message = "이메일을 입력해주세요.")
  @Email(message = "이메일 형식이 올바르지 않습니다.")
  @Column(nullable = false, unique = true)
  private String email;
}

