package com.meilun.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meilun.entiey.Tags;
import com.meilun.entiey.User;
import com.meilun.entiey.UserTags;
import com.meilun.service.TagsService;
import com.meilun.service.UserTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/tags")
public class TagsController {

    @Autowired
    TagsService tagsService;

    @Autowired
    UserTagsService userTagsService;


    @RequestMapping("/admin")
    public String admin(HttpSession session, HttpServletRequest request){


        User user = (User)session.getAttribute("user");

        System.out.println(1);

//        IPage<Tags> tagsIPage = tagsService.selectAllTagsByUid(user.getUId(),pageId);
//
//        request.setAttribute("page",tagsIPage);
        this.toPageProcess(user,request,1);

        return "admin/tags";
    }


    //根据pageId查询页面
    public void toPageProcess(User user,HttpServletRequest request,long pageId){

        IPage<Tags> tagsIPage = tagsService.selectAllTagsByUid(user.getUId(),pageId);
        request.setAttribute("page",tagsIPage);

    }

    @RequestMapping("/{pageId}")
    public String toPage(@PathVariable("pageId") long pageId,HttpServletRequest request){

//        int pageIdInt = (int)pageId;
//        redirectAttributes.addFlashAttribute("pageId",pageIdInt);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        toPageProcess(user,request,pageId);

        return "/admin/tags";
    }


    @RequestMapping("/add")
    public String add(Tags tags, RedirectAttributes redirectAttributes, HttpServletRequest request){

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");


        if(tags.getTName() == null || "".equals(tags.getTName())){
            return "redirect:/user/active";
        }

        QueryWrapper<Tags> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t_name",tags.getTName());

        Tags one = tagsService.getOne(queryWrapper);

        //如果不存在此标签
        if(one == null){

           Tags tags1 = new Tags();
           tags1.setTName(tags.getTName());
           tagsService.save(tags1);


           UserTags userTags = new UserTags();
           userTags.setTId(tags1.getTId());
           userTags.setUId(user.getUId());
           userTagsService.save(userTags);

           //如果存在这个标签
        }else {

            QueryWrapper<UserTags> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("u_id", user.getUId()).eq("t_id", one.getTId());
            UserTags one1 = userTagsService.getOne(queryWrapper1);

            if(one1 == null){

                UserTags userTags = new UserTags();
                userTags.setTId(one.getTId());
                userTags.setUId(user.getUId());
                userTagsService.save(userTags);
                redirectAttributes.addFlashAttribute("errormessage","添加成功");
                return "redirect:/tags/admin";
            }else {
                redirectAttributes.addFlashAttribute("errormessage","标签已存在");
                return "redirect:/tags/admin";
            }

        }

        redirectAttributes.addFlashAttribute("errormessage","添加成功");
        return "redirect:/tags/admin";

    }










}
