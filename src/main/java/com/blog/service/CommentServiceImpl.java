package com.blog.service;

import com.blog.dao.CommentRepository;
import com.blog.pojo.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    
    @Autowired
    private CommentRepository commentRepository;
    
    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        Sort sort = Sort.by(Sort.Direction.ASC, "createTime");
        List<Comment> comments = commentRepository.findByBlogIdAndParentCommentNull(blogId,sort);
        return eachComment(comments);
    }

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {

        Long parentCommentId = comment.getParentComment().getId();
        if(parentCommentId != -1){
            comment.setParentComment(commentRepository.getOne(parentCommentId));
        }else {
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentRepository.save(comment);
    }

    //循环每个顶级的评论的节点
    private List<Comment> eachComment(List<Comment> comments){
        //copy一个新的集合，避免在数据库上的操作，另起一个开始操作
        List<Comment> commentsView = new ArrayList<>();
        for (Comment comment: comments) {
            Comment c = new Comment();
            BeanUtils.copyProperties(comment,c);
            commentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(commentsView);
        return commentsView;
    }

    //root根节点，blog不为空的对象集合
    private void combineChildren(List<Comment> comments){
        for (Comment comment: comments) {
            List<Comment> replys1 = comment.getReplyComments();
            for (Comment reply1:replys1) {
                //循环迭代，找出子代，存放temReplys中
                recursively(reply1);
            }
            //修改顶级节点的reply集合为迭代处理后的集合
            comment.setReplyComments(tempReplays);
            //清除临时存放区
            tempReplays = new ArrayList<>();
        }
    }
    //存放迭代找出的所有子代的集合，生命周期是整个此类
    private List<Comment> tempReplays = new ArrayList<>();

    //把所有的子集都放在这个tempRepalys容器中去
    private void recursively(Comment comment){
        tempReplays.add(comment);//顶节点添加到临时存放集合
        if (comment.getReplyComments().size()>0){
            List<Comment> replys = comment.getReplyComments();
            for (Comment reply:replys) {
                tempReplays.add(reply);
                if(reply.getReplyComments().size()>0){
                    recursively(reply);
                }
            }
        }
    }
}
