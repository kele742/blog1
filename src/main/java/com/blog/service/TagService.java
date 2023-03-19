package com.blog.service;

import com.blog.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTagByName(String name);

    Tag getTag(Long id);

    Page<Tag> listTag(Pageable pageable,Tag tag);

    Tag updateTag(Long id,Tag tag);

    void deleteTag(Long id);

//    void updateSec(Long id);
}
