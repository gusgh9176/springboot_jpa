package com.example.webservice.web;



import com.example.webservice.dto.member.MemberDto;
import com.example.webservice.service.MaterialsService;
import com.example.webservice.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;
    private MaterialsService materialsService;

    // 회원가입 페이지
    @GetMapping("user/signup")
    public String dispSignup() {
        return "signup";
    }

    // 회원가입 처리
    @PostMapping("user/signup")
    public String execSignup(MemberDto memberDto) {
        if(memberService.joinUser(memberDto)== (long)-1){
            return "redirect:user/signupFailure";
        }
        return "redirect:user/login";
    }

    // 회원가입 실패 페이지
    @GetMapping("user/signupFailure")
    public String dispSignupFailure() {
        return "signupFailure";
    }

    // 로그인 페이지
    @GetMapping("user/login")
    public String dispLogin() {
        return "login";
    }

    // 로그인 결과 페이지
    @GetMapping("user/login/result")
    public String dispLoginResult() {
        return "loginSuccess";
    }

    // 로그아웃 결과 페이지
    @GetMapping("user/logout/result")
    public String dispLogout() {
        return "logout";
    }

    // 접근 거부 페이지
    @GetMapping("user/denied")
    public String dispDenied() {
        return "denied";
    }

    // 어드민 페이지
    @GetMapping("admin")
    public String dispAdmin(Model model) {
        model.addAttribute("materials", materialsService.findAllDesc());
        return "admin";
    }
}