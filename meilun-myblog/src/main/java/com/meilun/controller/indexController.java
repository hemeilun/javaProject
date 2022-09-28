package com.meilun.controller;

import com.meilun.common.CommonPage;
import com.meilun.entiey.Blog;
import com.meilun.service.BlogService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class indexController {

    @Autowired
    BlogService blogService;


    @RequestMapping("/")
    public String index(HttpServletRequest request){

        CommonPage<Blog> blogCommonPage = blogService.selectAllBlogNotOnlyMe(1);
        request.setAttribute("indexpage",blogCommonPage);
        System.out.println(blogCommonPage.getRecords());
        System.out.println(blogCommonPage);

        return "index";
    }




    @GetMapping("/tags")
    public String tags(){
        return "tags";
    }

    @GetMapping("/tagsContext")
    public String tagsContext(){
        return "tagsContext";
    }

    @GetMapping("/about")
    public String aboutme(){
        return "about";
    }

    @GetMapping("/search")
    public String search(){
        return "search";
    }


    @GetMapping("/person")
    public String person(){
        return "admin/person";
    }

    @GetMapping("/blogAdmin")
    public String blogAdmin(){
        return "admin/blog";
    }


    @GetMapping("/bloginput")
    public String bloginput(){
        return "admin/bloginput";
    }

    @GetMapping("/blog")
    public String test(){
        return "blog";
    }


}
