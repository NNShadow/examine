package com.examine.model;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

public class Comment {
    //id
    private int id;
    //评论人
    private String nickName;
    //评论内容
    private String content;
    //评论时间
    private Date commentTime;
    //点赞数
    private int likeNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(@RequestParam("content") String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }
}
