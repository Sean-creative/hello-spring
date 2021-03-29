package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// JPA로 데이터를 저장하고 변경할 떄는 써줘야함
@Transactional
public class MemberService {
    // 회원서비스는 회원 레포지토리랑 도메인을 활용해서 실제 비즈니스 로직을 작성하는 것이다.

    private final MemberRepository memberRepository;

    //내가 직접 new 하지 않는다. 외부에서 넣어준다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {

        //같은 이름이 있는 중복 회원x
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).
            ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
                //Optional이라 가능한 메소드이다(ifPresent-값이 있다면), 기존에는 if(null이 아니면)
                //요즘에는 null일 가능성이 있으면 Optional로 한번 감싸서 반환을 해준다
            });
    }


    /**
     * 전체 회원 조회
     * 서비스 클래스는 비즈니스에서 가져온 용어를 써야한다.
     * 반면에 repository는 그냥 직관적인 용어인 경우가 많음 (save)
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
