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

  private String phoneNumber; // A unique number for the member

  @Enumerated(EnumType.STRING)
  private Job job;

  public enum Job {
    DEVELOPER,
    TEACHER,
    DOCTOR,
    ENGINEER
  }
}
