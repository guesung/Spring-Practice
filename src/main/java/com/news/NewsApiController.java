package com.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/news") // API의 경로를 지정
public class NewsApiController {
  final NewsDAO dao; // final로 지정해서 잘못 입력되는 것을 방지

  @Autowired
  public NewsApiController(NewsDAO dao) {
    this.dao = dao;
  }  // 생성자를 통해 dao 객체를 주입받음

  // 뉴스 등록
  @PostMapping // POST Method
  public String addNews(@RequestBody News news) {
    try {
      dao.addNews(news);
    } catch (Exception e) {
      e.printStackTrace();
      return "News API: 뉴스 등록 실패!!";
    }
    return "News API: 뉴스 등록됨!!";
  }

  // 뉴스 삭제
  @DeleteMapping("{aid}") // DELETE Method
  public String delNews(@PathVariable("aid") int aid) {
    try {
      dao.delNews(aid);
    } catch (SQLException e) {
      e.printStackTrace();
      return "News API: 뉴스 삭제 실패!! - " + aid;
    }
    return "News API: 뉴스 삭제됨!! - " + aid;
  }

  // 뉴스 목록
  @GetMapping // GET Method
  public List<News> getNewsList() {
    List<News> newsList = null;

    try {
      newsList = dao.getAll();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return newsList;
  }

  // 뉴스 상세 정보
  @GetMapping("{aid}") // GET Method
  public News getNews(@PathVariable("aid") int aid) {
    News news = null;

    try {
      news = dao.getNews(aid);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return news;
  }
}
