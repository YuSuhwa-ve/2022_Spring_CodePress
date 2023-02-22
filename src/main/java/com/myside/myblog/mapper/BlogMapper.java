package com.myside.myblog.mapper;

import com.myside.myblog.vo.WebBlogRow;
import org.apache.ibatis.annotations.Mapper; //스프링과 관련없고 ibatis의 어노테이션이고 ibatis가 인식함
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper //멥퍼라고 알려줌
public interface BlogMapper {
    List<WebBlogRow> getAllBlogs();
    List<WebBlogRow> getPage(@Param("page") Integer page,@Param("getCount") Integer getCount); //???이거 맞니?
}
