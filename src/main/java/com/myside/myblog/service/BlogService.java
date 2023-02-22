package com.myside.myblog.service;

import com.myside.myblog.mapper.BlogMapper;
import com.myside.myblog.vo.WebBlogRow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private  BlogMapper blogMapper; //의존성 주입

    public BlogService(BlogMapper _BlogMapper){ //생성자 코드
        this.blogMapper = _BlogMapper;
    }

    public List<WebBlogRow> getAllList(){
        ///~~~~~~
        //~~~
        //`~~~ 비즈니스로직은 아직없음
        //System.out.println("BlogService의 Mapper 필드의 GetAllList"+this.blogMapper.getAllBlogs());

        return this.blogMapper.getAllBlogs(); //??this 필요없?
    }

    public List<WebBlogRow> getPageList(Integer page){
        return this.blogMapper.getPage(page*2,2);
    }
}
//제어의 역전 : 내가 이 객체의 메소드를 쓰기위해서 객체를 만들어야하는데, 스프링이 만들어! 하는것
// 그것이 빈,
// 랙토리패턴(누군가가 걔속 객체를 만들어줌) 보급해줌 : 공장이 존재 = 제어의 역전 : classname~factory 이면 생성과 소멸관리
//싱글톤패턴 : 내가 가지고있는 프로그램안에서 딱 하나의 고유한 객체만 존재하는것  : 만들수는 없고 꼭하는 존재하는것. : 공통의 값을 쓴다거나 그런것