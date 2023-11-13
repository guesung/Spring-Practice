package member.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class MemberInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_info_id")
  private Long id;

  @OneToOne(mappedBy = "memberInfo")
  private Member member; // Link to the Member entity

  @Column(name = "phone_number")
  private String phoneNumber; // A unique number for the member

  @Column(name = "job")
  @Enumerated(EnumType.STRING)
  private JobEnum job;


}
