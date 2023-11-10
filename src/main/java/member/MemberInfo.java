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
public class MemberInfo {

  @Id
  private Long id; // This assumes a shared primary key with the Member entity

  @Column(nullable = false, unique = true)
  private String number; // A unique number for the member

  @Column(nullable = false)
  private String job; // The job title or occupation of the member

  @OneToOne
  @MapsId
  @JoinColumn(name = "id")
  private Member member; // Links back to the Member entity

  public MemberInfo(String number, String job, Member member) {
    this.number = number;
    this.job = job;
    this.member = member;
  }
}
