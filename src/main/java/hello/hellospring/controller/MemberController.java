package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
