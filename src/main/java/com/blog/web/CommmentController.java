package com.blog.web;

import com.blog.pojo.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommmentController {

    //返回定义的片段，即commentList
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        model.addAttribute("comments","");
        //blog页面下的commentList
        return "blog :: commentList";
    }

    //点击发布按钮，接受信息
    //隐含域中已经放了一些值了，blog.id在HTML界面中有显示
    @PostMapping("/comments")
    public String post(Comment comment){

        return "redirect:/comments/" + comment.getBlog().getId();
    }

}
