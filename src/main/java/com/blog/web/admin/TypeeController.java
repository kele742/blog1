package com.blog.web.admin;

import com.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TypeeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String list(Pageable pageable){

        typeService.listType(pageable);
        return "admin/types";
    }
}
