package com.examine.control;

import com.examine.model.Comment;
import com.examine.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CommentControl {
    @Resource
    private CommentService commentService;

    @RequestMapping(value = "/comments")
    public String post(ModelMap modelMap){
        List<Comment> comments = commentService.findAll();
        modelMap.addAttribute("allComments",comments);
        return "comments";
    }
}
