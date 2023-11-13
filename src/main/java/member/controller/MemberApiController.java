package member.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import member.MemberApiException;
import member.MemberApiStatus;
import member.dto.MemberDto;
import member.entity.Member;
import member.entity.MemberInfo;
import member.repository.MemberInfoRepository;
import member.repository.MemberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Slf4j
public class MemberApiController {
  private final MemberRepository memberRepository;
  private final MemberInfoRepository memberInfoRepository;

  @GetMapping("")
  public Iterable<MemberDto> getAllMember() {
    Iterable<Member> members = memberRepository.findAll();
    List<MemberDto> memberDtoList = new ArrayList<>();
    for (Member member : members) {
      memberDtoList.add(MemberDto.of(member));
    }
    return memberDtoList;
  }

  @GetMapping("{id}")
  public Member getMember(@PathVariable long id) {
    return memberRepository.findById(id).orElseThrow(() -> new MemberApiException(MemberApiStatus.MEMBER_NOT_FOUND));
  }


  @PostMapping("")
  public void addMember(@RequestBody Member memberTotal) {
    Member member = new Member();
    memberRepository.save(member);

    MemberInfo memberInfo = new MemberInfo();
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
    memberRepository.save(member);

    MemberInfo memberInfo = memberInfoRepository.findById(id).orElseThrow(() -> new MemberApiException(MemberApiStatus.MEMBER_NOT_FOUND));
    memberInfoRepository.save(memberInfo);
  }
}
