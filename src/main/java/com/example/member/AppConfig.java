package com.example.member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Optional;

@Configuration
public class AppConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addRedirectViewController("/", "/member/list");
  }

  @Bean
  MemberRepository initMember() {
    MemberRepository repository = new MemberRepository() {
      @Override
      public void init() {
        // 샘플 데이터 등록
        memberMap.put(1, new Member(1, "홍길동", "hong@korea.com"));
        memberMap.put(2, new Member(2, "김철수", "kcs@google.com"));
        memberMap.put(3, new Member(3, "김영희", "kyh@naver.com"));
      }

      @Override
      public Optional<Member> findById(Integer id) {
        return Optional.ofNullable(memberMap.get(id));
      }

      @Override
      public Iterable<Member> findAll() {
        return memberMap.values();
      }

      @Override
      public Optional<Member> delete(Integer id) {
        return Optional.ofNullable(memberMap.remove(id));
      }

      @Override
      public Optional<Member> save(Member member) {
        return Optional.ofNullable(memberMap.put(member.getId(), member));
      }
    };
    repository.init();
    return repository;
  }
}
