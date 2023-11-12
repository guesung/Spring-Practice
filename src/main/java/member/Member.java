package member;

import jakarta.persistence.*;
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

  @
  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false, unique = true)
  private String email;
}

