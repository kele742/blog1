package com.blog.service;

import com.blog.NotFoundException;
import com.blog.dao.TagRepository;
import com.blog.pojo.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagServiceImpl implements TagService {


    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.getReferenceById(id);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable, Tag tag) {
        return tagRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.getReferenceById(id);
        if(t == null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(t,tag);
        return tagRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "update t_table set id = id-1 where id>1")
//    public void updateSec(Long id) {
//        typeRepository.findById(id);
//
//    }
}
