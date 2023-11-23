package member.entity;

import lombok.Getter;

@Getter
public enum JobEnum {
  DEVELOPER("개발자"),
  DESIGNER("디자이너"),
  PLANNER("기획자"),
  MARKETER("마케터"),
  RESEARCHER("연구원"),
  PROFESSOR("교수"),
  DOCTOR("의사"),
  LAWYER("변호사"),
  JOURNALIST("기자"),
  ARTIST("예술가"),
  CHEF("요리사"),
  ENGINEER("엔지니어"),
  SALESPERSON("세일즈맨"),
  TEACHER("교사"),
  POLICE_OFFICER("경찰관");

  private final String label;

  JobEnum(String label) {
    this.label = label;
  }

}
