package member;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class MemberInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String phoneNumber; // A unique number for the member

  @Enumerated(EnumType.STRING)
  private Job job;
  @OneToOne
  @MapsId
  @JoinColumn(name = "id")
  private Member member; // Links back to the Member entity


  public MemberInfo(String phoneNumber, Job job, Member member) {
    this.phoneNumber = phoneNumber;
    this.job = job;
    this.member = member;
  }

  public enum Job {
    DEVELOPER,
    TEACHER,
    DOCTOR,
    ENGINEER
    // 다른 직업들을 여기에 추가할 수 있습니다.
  }
}
