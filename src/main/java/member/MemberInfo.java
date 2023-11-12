package member;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class MemberInfo {
  @Id
  @Column(name = "member_info_id")
  private Long id;

  @OneToOne(mappedBy = "memberInfo")
  private Member member; // Link to the Member entity

  @NotBlank(message = "휴대폰 번호를 입력해주세요.")
  private String phoneNumber; // A unique number for the member

  @Enumerated(EnumType.STRING)
  private Job job;

  public enum Job {
    개발자,
    디자이너,
    기획자,
    마케터,
    기타

  }
}
