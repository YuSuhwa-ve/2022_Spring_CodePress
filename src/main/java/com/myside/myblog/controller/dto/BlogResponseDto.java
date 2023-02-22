package com.myside.myblog.controller.dto;

import com.myside.myblog.vo.WebBlogRow;
import lombok.Getter;

import java.util.Date;

@Getter

public class BlogResponseDto {//답변 dto 는 불변객체 즉 setter 없다.
    Integer id;
    String title;
    String content;
    String username;
    Date dt_creation;

    public BlogResponseDto(WebBlogRow _row){
        this.id=_row.getId();
        this.title=_row.getTitle();
        this.content=_row.getContent();
        this.username=_row.getUsername();
        this.dt_creation=_row.getDt_creation();
    }
}
