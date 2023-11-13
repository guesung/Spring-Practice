package member.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class MemberInfo {

  @Id
  @Column(name = "id")
  private Long id;

  private String phoneNumber;

  @Enumerated(EnumType.STRING)
  private JobEnum job;

  @OneToOne
  @MapsId
  @Setter
  @JoinColumn(name = "member_id")
  private Member member;
}
