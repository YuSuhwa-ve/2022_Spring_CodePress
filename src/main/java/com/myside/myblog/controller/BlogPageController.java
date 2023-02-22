package com.myside.myblog.controller;

import com.myside.myblog.service.BlogService;

import com.myside.myblog.vo.WebBlogRow;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogPageController {
    private BlogService blogService;

    public BlogPageController(BlogService _blogService) {

        this.blogService = _blogService;
    }

    @GetMapping("/list")
    public String getBlogAllList(Model _model){

        System.out.println("IN");
        //List<WebBlogRow> blogAllList = this.blogService.getAllList();
        List<WebBlogRow> blogAllList = this.blogService.getPageList(0);

        //System.out.println(blogAllList);
        //System.out.println(blogAllList.stream().count());

        _model.addAttribute("rows", blogAllList); //모델이 뷰로가는 어쩌구????
        return "blogmain";
    }
}
