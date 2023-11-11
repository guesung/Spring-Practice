package member;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class MemberInfo {
  @Id
  private Long member_info_id;

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
