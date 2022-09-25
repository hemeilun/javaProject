package com.meilun.test;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/")
    public String index(){

//        String password = "123456";
//        System.out.println(BCrypt.gensalt());
//        String hashPw = BCrypt.hashpw(password,BCrypt.gensalt());
//        System.out.println(hashPw);
//        boolean checkpw = BCrypt.checkpw(password, "$2a$10$3VBeaoVQS.fJxIEzlL1EMuie7Ip/vou2wbhBEQmf4EsOPcy4gt3bu");
//        System.out.println(checkpw);
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

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/person")
    public String person(){
        return "admin/person";
    }

    @GetMapping("/blogAdmin")
    public String blogAdmin(){
        return "admin/blog";
    }

    @GetMapping("/blogThis")
    public String blogThis(){
        return "/blogThis";
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
