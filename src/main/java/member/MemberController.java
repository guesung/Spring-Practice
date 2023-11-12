package member;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    return "member/member_form";
  }

  @GetMapping("{id}")
  public String getMemberById(@PathVariable long id, Model model) {
    model.addAttribute("member", memberRepo.findById(id).orElse(null));
    model.addAttribute("memberInfo", memberInfoRepo.findById(id).orElse(null));

    return "member/member_info";
  }

  @PostMapping("register")
  public String registerMember(@Valid Member member, @Valid MemberInfo memberInfo, Errors errors, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("username", member.getUsername());
    redirectAttributes.addFlashAttribute("email", member.getEmail());
    redirectAttributes.addFlashAttribute("phoneNumber", memberInfo.getPhoneNumber());
    redirectAttributes.addFlashAttribute("job", memberInfo.getJob());
    if (errors.hasErrors()) {
      List<FieldError> list = errors.getFieldErrors();
      list.forEach(e -> {
        if (e.getField().equals("username")) {
          redirectAttributes.addFlashAttribute("error", "이름은 2글자 이상이어야 합니다.");
        } else if (e.getField().equals("email")) {
          redirectAttributes.addFlashAttribute("error", "이메일 형식이 올바르지 않습니다.");
        } else if (e.getField().equals("job")) {
          redirectAttributes.addFlashAttribute("error", "직업은 '개발자','디자이너','기획자','마케터','기타' 중 하나여야 합니다.");
        } else if (e.getField().equals("phoneNumber")) {
          redirectAttributes.addFlashAttribute("error", "전화번호는 숫자만 입력해야 합니다.");
        }
      });
      return "redirect:/member/form";
    }
    member.setId(Long.parseLong("5"));
    memberInfo.setId(Long.parseLong("5"));
    memberRepo.save(member);
    memberInfoRepo.save(memberInfo);
    return "redirect:/member/list";
  }

  @RequestMapping("delete/{id}")
  public String deleteMember(@PathVariable long id) {
    memberRepo.deleteById(id);
    return "redirect:/member/list";
  }
}


