package com.examine.control;

import com.examine.model.Comment;
import com.examine.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class CommentPostControl {
    private static Map<String, List<Comment>> comments = new HashMap<>();
    @Resource
    private CommentService commentService;

    //按评论时间排序
    @RequestMapping(value = "/comment/post")
    public String post(@RequestParam(value = "all")String all, Comment comment, HttpSession httpSession){
        Date date = new Date();
        comment.setNickName((String) httpSession.getAttribute("username"));
        comment.setCommentTime(date);
        commentService.insertComment(comment);

        comments.computeIfAbsent(all, k -> new ArrayList<>()).add(comment);
        /*
        与上句一致
        List<Comment> res;
        if(comments.containsKey(songId)){
            res = comments.get(songId);
        }else {
            res = new ArrayList<>();
            comments.put(songId, res);
        }
        res.add(comment);
         */
        List<Comment> commentList = comments.get(all);
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                if(o1.getCommentTime().after(o2.getCommentTime())){
                    return -1;
                }else {
                    return 1;
                }
            }
        });

        return "redirect:/comments";
    }

    public List<Comment> getComments(String all){
        return comments.get(all);
    }

}
