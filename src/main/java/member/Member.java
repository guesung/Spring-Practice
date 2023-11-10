package member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Member {

  @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
  @JoinColumn(name = "member_info_id")
  public MemberInfo memberInfo; // Link to the MemberInfo entity
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, unique = true)
  private String username;
  @Column(nullable = false, unique = true)
  private String email;

  public Member(String username, String email) {
    this.username = username;
    this.email = email;
  }

  public void setMemberInfo(MemberInfo memberInfo) {
    this.memberInfo = memberInfo;
    memberInfo.setMember(this);
  }
}

