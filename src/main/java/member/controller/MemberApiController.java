package member.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import member.MemberApiException;
import member.MemberApiStatus;
import member.dto.MemberDto;
import member.entity.Member;
import member.entity.MemberInfo;
import member.repository.MemberInfoRepository;
import member.repository.MemberRepository;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
  public MemberDto getMember(@PathVariable long id) {
    Member member = memberRepository.findById(id).orElseThrow(() -> new MemberApiException(MemberApiStatus.MEMBER_NOT_FOUND));
    return MemberDto.of(member);
  }

  @DeleteMapping("{id}")
  public void deleteMember(@PathVariable Long id) {
    Optional<Member> MemberOpt = memberRepository.findById(id);
    if (MemberOpt.isPresent()) {
      Member member = MemberOpt.get();
      memberRepository.delete(member);
    } else {
      throw new MemberApiException(MemberApiStatus.MEMBER_NOT_FOUND);
    }
  }

  @PostMapping(value = "")
  public ResponseEntity<MemberDto> addMember(@Valid @RequestBody MemberDto memberDto, BindingResult result) {
    insertMember(memberDto, result);
    return new ResponseEntity<>(memberDto, HttpStatus.CREATED);
  }

  private void insertMember(@Valid MemberDto memberDto, BindingResult result) {
    List<String> msgs = new ArrayList<>();
    if (result.hasErrors()) {
      result.getAllErrors().forEach(oe -> msgs.add(oe.getDefaultMessage()));
      throw new MemberApiException(MemberApiStatus.VALIDATION_ERROR, StringUtils.join(msgs, ','));
    } else {
      Member member = Member.builder()
          .id(memberDto.getId() != null ? memberDto.getId() : null)
          .username(memberDto.getUsername())
          .email(memberDto.getEmail())
          .build();

      MemberInfo memberInfo = MemberInfo.builder()
          .id(memberDto.getId() != null ? memberDto.getId() : null)
          .phoneNumber(memberDto.getPhoneNumber())
          .job(memberDto.getJob())
          .member(member)
          .build();

      memberInfoRepository.save(memberInfo);
      memberRepository.save(member);
    }
  }


  @PutMapping("{id}")
  public void updateMemberInfo(@PathVariable long id, @RequestBody Member memberTotal) {
    Member member = memberRepository.findById(id).orElseThrow(() -> new MemberApiException(MemberApiStatus.MEMBER_NOT_FOUND));
    memberRepository.save(member);

    MemberInfo memberInfo = memberInfoRepository.findById(id).orElseThrow(() -> new MemberApiException(MemberApiStatus.MEMBER_NOT_FOUND));
    memberInfoRepository.save(memberInfo);
  }
}
