package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//멤버 컨트롤러를 만들어야 하는데, 멤버 컨트롤러가 멤버 서비스를 통해서 데이터를
//        조회할 수 있어야 한다. 이런 관계를 -> 서로 의존관계가 있다고 표현한다.

//스프링 컨테이너에서 @Controller가 붙어있는 것들을 빈으로 관리함
@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    //객체를 따로 만들필요 없이, 스프링 컨테이너 한테 등록하면 -> 딱 하나만 등록이 된다.

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
}
