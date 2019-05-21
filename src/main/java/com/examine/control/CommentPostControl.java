package com.examine.control;

import com.examine.model.Comment;
import com.examine.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class CommentPostControl {
    @Resource
    private CommentService commentService;

    //按评论时间排序
    @RequestMapping(value = "/comment/post")
    public String post(Comment comment, HttpSession httpSession){
        if(comment.getContent() != null){
            Date date = new Date();
            comment.setNickName((String) httpSession.getAttribute("username"));
            comment.setCommentTime(date);
            commentService.insertComment(comment);
        }
        return "redirect:/comments";
    }

}
