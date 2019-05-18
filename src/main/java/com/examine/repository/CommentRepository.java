package com.examine.repository;

import com.examine.model.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentRepository {
    @Insert("insert into comment (nickName, commentTime, content)" + "values (#{nickName}, #{commentTime}, #{content})")
    public int insertComment(Comment comment);

    @Select("select * from comment")
    public List<Comment> getAll();
}
