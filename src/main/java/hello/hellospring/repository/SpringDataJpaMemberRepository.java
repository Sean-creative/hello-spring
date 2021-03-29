package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//스프링 데이터 jpa가 MemberRepository를 받고 있으면 얘가 구현체를 자동으로 빈으로 등록해준다
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {


    //select m from Member m where m.name = ?
    //인터페이스 이름만으로도 개발이 끝났다다
   @Override
    Optional<Member> findByName(String name);
}
