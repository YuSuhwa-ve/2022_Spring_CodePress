package com.myside.myblog.controller.dto;

import com.myside.myblog.vo.WebBlogRow;
import lombok.Setter;
import java.util.Date;

@Setter //생성자를 자동으로 묵시적으로 만들어주는 어노테이션
public class BlogRequestDto { //dto는 스프링 프레이워크랑 관계가 아예없음
    Integer id;
    String title;
    String content;
    String username;
    Date dt_creation;
    public WebBlogRow creatBlogObject(){ //db에 저장될 형탠대로 request dto를 만들고 요청이 들어오면 db저장될수 있는 형태로 객체만듬
        return new WebBlogRow(this.id, this.title, this.content, this.username, this.dt_creation); //단일클래스 overloading
    }
}
