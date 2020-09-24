package com.lty.service;

import com.lty.po.Blog;
import com.lty.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Blog saveBlog(Blog blog);
    Blog getBlog(Long id);
    Blog getAndConvent(Long id);
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);
    Page<Blog> listBlog(Pageable pageable);
    Page<Blog> listBlog(String query,Pageable pageable);


    List<Blog> listRecommendBlogTop(Integer size);

    Blog updateBlog(Long id, Blog blog);
    void deleteBlog(Long id);
}
