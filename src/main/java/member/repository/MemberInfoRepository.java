package member.repository;

import member.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {

}
