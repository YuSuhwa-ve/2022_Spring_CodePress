package com.myside.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//컨트롤러는 뷰를 포함하는 컨트롤러
@Controller //이것을 컨트롤러로 쓸 것이다.
public class WelcomeClass {
    //어노테이션 : 누군가와 약속한 문법
    @ResponseBody //html없이 바디는 이걸로만 구성되어 있어. view 안찾겠다.
    // controller + responsbody = restcontrller
    @GetMapping("/webblog") //사용자가 이 url로 들어오면
    public String entryPoint(){
        return "Hi";
    }

    @GetMapping("/webblogpage") //사용자가 이 url로 들어오면
    public String viewPage(){
        return "index3"; //view를 찾아야하니까 resource/templates 안의 페이지 이름과 동일해야함
        //이때 페이지가 없거나 이름이 다르면 404에러
        //index는 기본으로 연결되는 페이지이기때문에 /로 들어오면 자동으로 들어감
    }
}