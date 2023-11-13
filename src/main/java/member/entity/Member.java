package member.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member {

  //Primary Key
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  private String name;

  private String email;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "member")
  @PrimaryKeyJoinColumn
  private MemberInfo memberInfo;

  public Member(String name, String email) {
    this.name = name;
    this.email = email;
  }
}

