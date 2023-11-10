package member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {
}
