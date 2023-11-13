package member.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import member.dto.MemberDto;
import member.entity.JobEnum;
import member.entity.Member;
import member.entity.MemberInfo;
import member.repository.MemberInfoRepository;
import member.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller // 컨트롤러임을 선언
@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성해줌
@Slf4j  // 로그를 위한 어노테이션
@RequestMapping("member") // 기본적인 URL 매핑
public class MemberController {
  private final MemberRepository memberRepo;
  private final MemberInfoRepository memberInfoRepo;


  @ModelAttribute
  public void addAttributes(Model model) {
    model.addAttribute("total", memberRepo.findAll().spliterator().getExactSizeIfKnown());
  }

  @GetMapping("list")
  public String getMemberList(Model model) {
    model.addAttribute("members", memberRepo.findAll());
    return "member/member_list";
  }

  @GetMapping("form")
  public String addMember(Model model) {
    model.addAttribute("jobs", JobEnum.values());
    return "member/member_form";
  }

  @GetMapping("{id}")
  public String getMemberById(@PathVariable long id, Model model) {
    model.addAttribute("member", memberRepo.findById(id).orElse(null));
    model.addAttribute("memberInfo", memberInfoRepo.findById(id).orElse(null));

    return "member/member_info";
  }

  @PostMapping("register")
  public String signUp(@ModelAttribute @Valid MemberDto memberDto, BindingResult errors, Model model, RedirectAttributes redirectAttributes) {
    if (errors.hasErrors()) {
      List<FieldError> list = errors.getFieldErrors();
      List<String> errorMessageList = new ArrayList<>();
      list.forEach(e -> errorMessageList.add(e.getDefaultMessage()));
      System.out.println(errorMessageList);
      redirectAttributes.addFlashAttribute("username", memberDto.getUsername());
      redirectAttributes.addFlashAttribute("email", memberDto.getEmail());
      redirectAttributes.addFlashAttribute("errors", errorMessageList);

      return "redirect:/member/form";
    } else {
      Member member = Member.builder()
          .username(memberDto.getUsername())
          .email(memberDto.getEmail())
          .build();

      MemberInfo memberInfo = MemberInfo.builder()
          .phoneNumber(memberDto.getPhoneNumber())
          .job(memberDto.getJob())
          .member(member)
          .build();

      memberInfoRepo.save(memberInfo);
      return "redirect:/member/list";
    }
  }

  @RequestMapping("delete/{id}")
  public String deleteMember(@PathVariable long id) {
    memberRepo.deleteById(id);
    return "redirect:/member/list";
  }
}


