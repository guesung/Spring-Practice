package com.news;

public class News {
  private int aid; // 고유의 ID
  private String title;
  private String img; // DB에 이미지를 통으로 집어넣는 것이 가능하지만 효율성이 떨어짐(직렬화 > 복구..). 그래서 파일명만 저장하고 실제 이미지는 파일로 파일 시스템에 저장하는 것이 좋음.
  private String date;
  private String content;

  public int getAid() {
    return aid;
  }

  public void setAid(int aid) {
    this.aid = aid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
