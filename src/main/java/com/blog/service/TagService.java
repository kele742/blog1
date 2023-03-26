package com.blog.service;

import com.blog.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTagByName(String name);

    Tag getTag(Long id);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    Tag updateTag(Long id,Tag tag);

    List<Tag> listTag(String ids);

    void deleteTag(Long id);

//    void updateSec(Long id);
}
