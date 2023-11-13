package member;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import member.entity.Member;
import member.entity.MemberInfo;
import member.repository.MemberInfoRepository;
import member.repository.MemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Transactional
public class MemberTest implements ApplicationRunner {
  private final MemberRepository memberRepository;
  private final MemberInfoRepository memberInfoRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("Text 시작");

    for (Member m : memberRepository.findAll()) {
      System.out.println(m);
    }
    for (MemberInfo ma : memberInfoRepository.findAll()) {
      System.out.println(ma);
    }
  }
}
