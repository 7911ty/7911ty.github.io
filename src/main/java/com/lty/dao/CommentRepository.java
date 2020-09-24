package com.lty.dao;

import com.lty.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
    /*狗*/
    /*List<Comment> findByBlogId(Long blogId, Sort sort);*/
}
