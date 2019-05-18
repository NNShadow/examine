package com.examine.control;

import com.examine.model.Comment;
import com.examine.model.User;
import com.examine.service.CommentService;
import com.examine.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageControl {
    @Resource
    private UserService userService;
    private CommentService commentService;

    @GetMapping(value = "/register")
    public String registerStart() {
        return "register";
    }

    @GetMapping(value = "index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String loginComment(User user, HttpSession httpSession){
        if (userService.testPassword(user) == null)
//            return "不存在该用户";
            return "error/loginError";
        if (userService.testPassword(user).equals("true")) {
            httpSession.setAttribute("username", user.getUsername());
//            init();
            return "comments";
        }
        else
//            return "密码错误";
            return "error/loginError";
    }

    public void init(){
        ModelMap modelMap = new ModelMap();
        List<Comment> commentList = commentService.findAll();
        for (int i=0; i<commentList.size(); i++){
            modelMap.addAttribute("allComments", commentList.get(i));
        }
    }

}
