package com.example.member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface MemberRepository {
  Map<Integer, Member> memberMap = new HashMap<>();

  void init();

  Optional<Member> findById(Integer id);

  Iterable<Member> findAll();

  Optional<Member> delete(Integer id);

  Optional<Member> save(Member member);

  default boolean existsById(Integer id) {
    return memberMap.containsKey(id);
  }

  default long count() {
    return memberMap.size();
  }
}
