package com.example.member;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller // 컨트롤러임을 선언
@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성해줌
@Slf4j  // 로그를 위한 어노테이션
@RequestMapping("/member") // 기본적인 URL 매핑
public class MemberController {
  private final MemberRepository memberRepo;
  private Integer accumulatedNumber = 3;

  @ExceptionHandler(ClassNotFoundException.class)
  public String handleNotFoundException(Model model) {

    model.addAttribute("status", HttpStatus.NOT_FOUND.value());
    model.addAttribute("error", "Not Found");
    model.addAttribute("message", "The requested resource was not found");
    return "error";
  }

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
  public ModelAndView registerMember(@Valid Member member, Errors errors, RedirectAttributes redirectAttributes) {
    if (errors.hasErrors()) {
      List<FieldError> list = errors.getFieldErrors();
      list.forEach(e -> log.error(e.getDefaultMessage()));
      redirectAttributes.addFlashAttribute("username", member.getUsername());
      redirectAttributes.addFlashAttribute("email", member.getEmail());
      redirectAttributes.addFlashAttribute("isError", true);
      return new ModelAndView("redirect:/member/form");
    }
    member.setId(++accumulatedNumber);
    memberRepo.save(member);
    return new ModelAndView("redirect:/member/list");
  }

  @RequestMapping("/delete/{id}")
  public ModelAndView deleteMember(@PathVariable int id) {
    if (!memberRepo.existsById(id)) throw new RuntimeException("존재하는 아이디가 없습니다.");
    memberRepo.delete(id);
    return new ModelAndView("redirect:/member/list");
  }
}


