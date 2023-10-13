package com.example.member;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // 컨트롤러임을 선언
@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성해줌
@Slf4j  // 로그를 위한 어노테이션
@RequestMapping("/member") // 기본적인 URL 매핑
public class MemberController {
  private final MemberRepository memberRepo;


  @RequestMapping("/list")
  public String getMemberList(Model model) {
    model.addAttribute("members", memberRepo.findAll());
    model.addAttribute("total", memberRepo.findAll().spliterator().getExactSizeIfKnown());
    return "member/member_list";
  }

  @RequestMapping("/form")
  public String addMember(Model model) {
    model.addAttribute("total", memberRepo.findAll().spliterator().getExactSizeIfKnown());
    return "member/member_form";
  }

  @RequestMapping("/{id}")
  public String getMemberById(@PathVariable int id, Model model) {
    model.addAttribute("member", memberRepo.findById(id).orElse(null));
    model.addAttribute("total", memberRepo.findAll().spliterator().getExactSizeIfKnown());
    return "member/member_info";
  }

  @PostMapping("/register")
  public ModelAndView registerMember(@RequestParam String username, @RequestParam String email) {
    System.out.println("회원 가입: " + username + ", 이메일: " + email);
    memberRepo.save(new Member((int) memberRepo.findAll().spliterator().getExactSizeIfKnown() + 1, username, email));


    return new ModelAndView("redirect:/member/list");
  }
}


