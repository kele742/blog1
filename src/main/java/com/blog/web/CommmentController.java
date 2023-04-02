package com.blog.web;

import com.blog.pojo.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommmentController {
    @GetMapping("/comments/{blogId")
    public String comments(Long blog0d, Model model){
        model.addAttribute("commmets","");
        return "blog :: commentList";
    }

    public String post(Comment comment){

        return "redirect:/comments/" + comment.getBlog().getId();
    }

}
