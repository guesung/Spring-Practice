package member;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Slf4j
public class MemberApiController {
  private final MemberRepository memberRepository;

  @GetMapping("")
  public Iterable<Member> getAllMember() {
    return memberRepository.findAll();
  }

  @GetMapping("{id}")
  public Member getMember(@PathVariable long id) {
    return memberRepository.findById(id).orElseThrow(() -> new MemberApiException(MemberApiStatus.MEMBER_NOT_FOUND));
  }

  @DeleteMapping("{id}")
  public void delMember(@PathVariable long id, HttpServletRequest request) {
    memberRepository.deleteById(id);
  }


}
