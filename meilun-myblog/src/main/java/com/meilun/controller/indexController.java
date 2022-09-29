package com.meilun.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meilun.common.CommonPage;
import com.meilun.entiey.Blog;
import com.meilun.entiey.Tags;
import com.meilun.entiey.User;
import com.meilun.service.BlogService;
import com.meilun.service.TagsService;
import com.meilun.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;

    @Autowired
    TagsService tagsService;


    @RequestMapping("/")
    public String index(HttpServletRequest request){

//        CommonPage<Blog> blogCommonPage = blogService.selectAllBlogNotOnlyMe(1);
//        request.setAttribute("indexpage",blogCommonPage);
//        System.out.println(blogCommonPage.getRecords());
//        System.out.println(blogCommonPage);

        toPageProcess(request,1);
        return "index";
    }



    @RequestMapping("/{pageId}")
    public String toPage(@PathVariable("pageId") long pageId,HttpServletRequest request){

        toPageProcess(request,pageId);
        return "index";

    }

    //根据pageId查询页面
    public void toPageProcess(HttpServletRequest request, long pageId){

        IPage<Blog> tagsIPage = blogService.selectAllBlogNotOnlyMe(pageId);

        long total = tagsIPage.getTotal();
        List<Blog> list = tagsIPage.getRecords();

        for (int i = 0; i < list.size(); i++) {
//            Tags tag = tagsService.getOne(new QueryWrapper<Tags>().eq("t_id", list.get(i).getBTagid()));
            User user1 = userService.getOne(new QueryWrapper<User>().eq("u_id", list.get(i).getBUserid()));

            tagsIPage.getRecords().get(i).setBUser(user1);
        }

        request.setAttribute("indexpage",tagsIPage);
        System.out.println(tagsIPage.getRecords());
        System.out.println(tagsIPage);

    }


    @GetMapping("/index/tags/{pageId}")
    public String tagsPage(@PathVariable("pageId") long pageId,HttpServletRequest request){

        toTagesPage(request,pageId);
        return "tags";
    }

    @GetMapping("/tags")
    public String tags(HttpServletRequest request){

        toTagesPage(request,1);
        return "tags";
    }


    public void toTagesPage(HttpServletRequest request,long pageId){

        CommonPage<Tags> tagsCommonPage = tagsService.selectAllTags(pageId);
        System.out.println(tagsCommonPage.getRecords());
        System.out.println(tagsCommonPage);
        request.setAttribute("tagsPage",tagsCommonPage);
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







}
