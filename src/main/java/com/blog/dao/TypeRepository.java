package com.blog.dao;

import com.blog.pojo.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

    @Query("select t_type from Type t_type")
    List<Type> findTop(Pageable pageable);

}
