package com.lty.service;

import com.lty.po.Blog;
import com.lty.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {
   /* Blog saveBlog(Blog blog);
    Blog getBlog(Long id);
    Blog getAndConvent(Long id);
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);
    Page<Blog> listBlog(Pageable pageable);
    Page<Blog> listBlog(String query,Pageable pageable);


    List<Blog> listRecommendBlogTop(Integer size);

    Blog updateBlog(Long id, Blog blog);
    void deleteBlog(Long id);

    Page<Blog> listBolg(Pageable pageable, BlogQuery blogQuery);*/

    /**
     * 查询
     * @param id
     * @return
     */
    Blog getBlog(Long id);

    /**
     * 分页查询
     * @param pageable
     * @param blog
     * @return
     */
    Page<Blog> listBolg(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId,Pageable pageable);

    Page<Blog> listBlog(String query,Pageable pageable);

    List<Blog> listRecommendBlogTop(Integer size);

    Map<String, List<Blog>> archiveBlog();

    Long countBlog();

    Blog getAndConvert(Long id);


    /**
     * 新增
     * @param blog
     * @return
     */
    Blog saveBlog(Blog blog);

    /**
     * 修改
     * @param id
     * @param blog
     * @return
     */
    Blog updateBlog(Long id,Blog blog);

    /**
     * 删除
     * @param id
     */
    void deleteBlog(Long id);
}
