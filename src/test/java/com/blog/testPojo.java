package com.blog;

import com.blog.service.BlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testPojo {
    @Autowired
    private BlogService blogService;


    @Test
    public void testfirstP(){
        Long id = Long.valueOf("14");
        String firstP = blogService.getBlog(id).getFirstPicture();
        System.out.println("受影响行数："+firstP);
    }

}
