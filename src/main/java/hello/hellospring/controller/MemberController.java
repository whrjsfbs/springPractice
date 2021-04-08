package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    //(필드 주입: 아무것도 customizing 할 수 없어 추천 X)
    //@Autowired
    private final MemberService memberService;

    //(생성자 주입: 추천. 처음에 한번 만들고 변경 불가)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    (setter 주입:
//      - runtime 중에 memberService를 바꿀 수 있는 통로를 주는 것이라 추천하지 않음.
//      - memberService가 final이면 안됨.
//    )
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

}
