package member;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Transactional
public class MemberTest implements ApplicationRunner {
  private final MemberRepository memberRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("test");
  }
}
