package com.blog.dao;

import com.blog.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {

    @Query("select t_blog from Blog t_blog where t_blog.recommended = true")
    List<Blog> findTop(Pageable pageable);

    @Query("select t_blog from Blog t_blog where t_blog.title like ?1 or t_blog.content like ?1")
    Page<Blog> findByQuery(String query,Pageable pageable);

}
