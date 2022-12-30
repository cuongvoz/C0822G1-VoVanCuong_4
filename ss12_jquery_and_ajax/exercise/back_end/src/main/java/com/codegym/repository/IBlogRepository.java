package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {


    @Query(value = "select * from blog where category_id = :id",nativeQuery = true)
    Page<Blog> selectByCategory(@Param("id") int id,Pageable pageable);

    @Query(value = "select * from blog where category_id = :id",nativeQuery = true)
    List<Blog> findByCategory(@Param("id") int id);

    @Query(value = "select * from blog where title like %:title%",nativeQuery = true)
    List<Blog> searchBlog(@Param("title") String title);
}
