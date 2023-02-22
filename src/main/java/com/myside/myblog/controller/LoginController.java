package com.myside.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.myside.myblog.service.BlogService;
import com.myside.myblog.vo.WebBlogRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;

@Controller
public class LoginController {
    @GetMapping("/all")
    public String alluser() {
        return "all";
    }
    @GetMapping("/member")
    public String memberuser() {
        return "member";
    }
    @GetMapping("/manager")
    public String manageruser() {
        return "manager";
    }
    @GetMapping("/admin")
    public String adminuser() {
        return "admin";
    }
}
