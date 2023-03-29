package com.blog.service;

import com.blog.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    Type saveType(Type type);

    Type getTypeByName(String name);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    Type updateType(Long id,Type type);

    void deleteType(Long id);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

//    void updateSec(Long id);
}
