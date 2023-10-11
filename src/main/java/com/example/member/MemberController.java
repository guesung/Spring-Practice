package com.example.member;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 컨트롤러임을 선언
@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성해줌
@Slf4j  // 로그를 위한 어노테이션
@RequestMapping("/member") // 기본적인 URL 매핑
public class MemberController {
  private final MemberRepository memberRepo;

  @RequestMapping("/list")
  public String getMemberList() {
    return "member/member_list";
  }

  @RequestMapping("/form")
  public String addMember() {
    return "member/member_form";
  }

  @RequestMapping("/{id}")
  public String getMemberById(@PathVariable int id) {
    return "member/member_info";
  }
}


