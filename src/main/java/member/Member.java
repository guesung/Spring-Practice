package member;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Member {

  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "member_id", nullable = false, unique = true)
  private Long id;

  @OneToOne
  @JoinColumn(name = "id")
  private MemberInfo memberInfo; // Link to the MemberInfo entity

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false, unique = true)
  private String email;


}

