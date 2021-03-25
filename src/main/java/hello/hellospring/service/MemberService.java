package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.Optional;

// 회원서비스는 회원 레포지토리랑 도메인을 활용해서 실제 비즈니스 로직을 작성하는 것이다.
public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();


    /**
     * 회원 가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원x
        memberRepository.findByName(member.getName()).
            ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
                //Optional이라 가능한 메소드이다(ifPresent-값이 있다면), 기존에는 if(null이 아니면)
                //요즘에는 null일 가능성이 있으면 Optional로 한번 감싸서 반환을 해준다
            });



        memberRepository.save(member);
        return member.getId();
    }
}
