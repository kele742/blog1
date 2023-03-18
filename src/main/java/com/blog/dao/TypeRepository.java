package com.blog.dao;

import com.blog.pojo.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

}
