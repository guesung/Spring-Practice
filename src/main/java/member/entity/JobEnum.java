package member.entity;

import lombok.Getter;

@Getter
public enum JobEnum {
  STUDENT("학생"),
  CIVIL_SERVANT("공무원"),
  PROFESSIONAL("전문직"),
  SELF_EMPLOYED("자영업"),
  FREELANCER("프리랜서"),
  SOLDIER("군인"),
  OFFICE_WORKER("사무/관리직"),
  CONSTRUCTION_WORKER("건설업"),
  ENTERTAINMENT("유흥업"),
  JOURNALIST("언론인"),
  FINANCIAL("금융"),
  RELIGIOUS("종교"),
  POLITICIAN("정치"),
  SERVICE_INDUSTRY("서비스업"),
  AGRICULTURE("농/축/수산업");

  private final String label;

  JobEnum(String label) {
    this.label = label;
  }

}
