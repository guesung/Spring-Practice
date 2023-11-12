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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id", nullable = false, unique = true)
  private Long id;

  @OneToOne
  @JoinColumn(name = "member_info_id")
  private MemberInfo memberInfo;

  @Column(nullable = false, unique = true)
  @NotBlank(message = "이름은 반드시 입력 해야 합니다!!")
  private String username;

  @NotBlank(message = "이메일은 반드시 입력 해야 합니다!!")
  @Email(message = "이메일 형식을 따라야 합니다!!")
  private String email;

  public void setMemberInfo(MemberInfo memberInfo) {
    this.memberInfo = memberInfo;
    memberInfo.setMember(this);
  }
}

