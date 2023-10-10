package com.example.member;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 컨트롤러임을 선언
@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성해줌
@Slf4j  // 로그를 위한 어노테이션
@RequestMapping("/member") // 기본적인 URL 매핑
public class MemberController {
  private final MemberRepository memberRepo;

  @RequestMapping("/list")
  @ResponseBody
  public Iterable<Member> test2() {
    return memberRepo.findAll();
  }

}
