package com.myside.myblog.controller;

import com.myside.myblog.controller.dto.BlogResponseDto;
import com.myside.myblog.service.BlogService;
import com.myside.myblog.vo.WebBlogRow;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import static java.time.LocalTime.now;

//@RestController //뷰가아니라 데이터를 주고받을것이기떄문에= api 이니까
@Controller
public class BlogAPIController {
    private BlogService blogService;

    public BlogAPIController(BlogService _blogService){
        this.blogService = _blogService;
    }

    //localhost:8080/api/getNextList?page=
    @GetMapping("/api/getNextList")
    @ResponseBody
    public List<BlogResponseDto> getNextList(@RequestParam Integer page){

        System.out.println("IN getNextList");

        List<BlogResponseDto> blogResponseDtoList = new ArrayList<>();

        /*
        blogResponseDtoList.add(
                new BlogResponseDto(
                        new WebBlogRow(4545,"샘플타이틀","sample","suer")
                )
        ); //실제 db에서가 아니라 그냥 더미 데이터
        blogResponseDtoList.add(
                new BlogResponseDto(
                        new WebBlogRow(1000,"샘플타이틀","샘플 컨텐츠","글쓴이")
                )
        );
         */
        System.out.println("in service 1");
        List<WebBlogRow> blogRowList=this.blogService.getPageList(page);
        System.out.println("in service 2 : " + blogRowList.toArray().length);

        for(WebBlogRow blog : blogRowList){
            blogResponseDtoList.add(new BlogResponseDto(blog));
        }

        System.out.println("in service 3 : " + blogResponseDtoList);


        return blogResponseDtoList;


    }
}
