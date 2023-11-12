package member;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Slf4j
public class MemberApiController {
  private final MemberRepository memberRepository;
  private final MemberInfoRepository memberInfoRepository;

  @GetMapping("")
  public Iterable<Member> getAllMember() {
    return memberRepository.findAll();
  }

  @GetMapping("{id}")
  public Member getMember(@PathVariable long id) {
    return memberRepository.findById(id).orElseThrow(() -> new MemberApiException(MemberApiStatus.MEMBER_NOT_FOUND));
  }


  @PostMapping("")
  public void addMember(@RequestBody Member memberTotal) {
    Member member = new Member();
    member.setId(Long.parseLong("4"));
    member.setUsername(memberTotal.getUsername());
    member.setEmail(memberTotal.getEmail());
    memberRepository.save(member);

    MemberInfo memberInfo = new MemberInfo();
    memberInfo.setId(Long.parseLong("4"));
    memberInfo.setJob(memberInfo.getJob());
    memberInfo.setPhoneNumber(memberInfo.getPhoneNumber());
    memberInfoRepository.save(memberInfo);
  }

  @DeleteMapping("{id}")
  public void deleteMemberInfo(@PathVariable long id) {
    memberRepository.deleteById(id);
    memberInfoRepository.deleteById(id);
  }

  @PutMapping("{id}")
  public void updateMemberInfo(@PathVariable long id, @RequestBody Member memberTotal) {
    Member member = memberRepository.findById(id).orElseThrow(() -> new MemberApiException(MemberApiStatus.MEMBER_NOT_FOUND));
    member.setUsername(memberTotal.getUsername());
    member.setEmail(memberTotal.getEmail());
    memberRepository.save(member);

    MemberInfo memberInfo = memberInfoRepository.findById(id).orElseThrow(() -> new MemberApiException(MemberApiStatus.MEMBER_NOT_FOUND));
    memberInfo.setJob(memberInfo.getJob());
    memberInfo.setPhoneNumber(memberInfo.getPhoneNumber());
    memberInfoRepository.save(memberInfo);
  }
}
