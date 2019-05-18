package com.examine.control;

import com.examine.model.Comment;
import com.examine.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CommentControl {
    @Autowired
    private CommentPostControl commentPostControl;

    @RequestMapping(value = "/comments")
    public String post(ModelMap modelMap){
        List<Comment> comments = commentPostControl.getComments("666");
        modelMap.addAttribute("allComments",comments);
        return "comments";
    }
}
