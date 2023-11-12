package member;

import jakarta.persistence.*;
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

  @Column(name = "phone_number")
  private String phoneNumber; // A unique number for the member

  @Column(name = "job")
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
