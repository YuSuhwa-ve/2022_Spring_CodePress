package com.myside.myblog.vo;

import java.util.Date;

public class WebBlogRow {
    //getter : converting 목적 //setter : vallidation 목적
    Integer id; //class-web-1234-2022-11(원천 id 값) => webB2211
    String title;
    String content;
    String username;
    Date dt_creation;
    Date dt_updated;
    Date dt_deleted;
    Date dt_access;


    public WebBlogRow(Integer id, String title, String content, String username, Date dt_creation, Date dt_updated, Date dt_deleted, Date dt_access) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
        this.dt_creation = dt_creation;
        this.dt_updated = dt_updated;
        this.dt_deleted = dt_deleted;
        this.dt_access = dt_access;
    }

    public WebBlogRow(Integer id, String title, String content, String username, Date dt_creation) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
        this.dt_creation = dt_creation;

    }
    public WebBlogRow(Integer id, String title, String content, String username) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDt_creation() {
        return dt_creation;
    }

    public void setDt_creation(Date dt_creation) {
        this.dt_creation = dt_creation;
    }

    public Date getDt_updated() {
        return dt_updated;
    }

    public void setDt_updated(Date dt_updated) {
        this.dt_updated = dt_updated;
    }

    public Date getDt_deleted() {
        return dt_deleted;
    }

    public void setDt_deleted(Date dt_deleted) {
        this.dt_deleted = dt_deleted;
    }

    public Date getDt_access() {
        return dt_access;
    }

    public void setDt_access(Date dt_access) {
        this.dt_access = dt_access;
    }
}
