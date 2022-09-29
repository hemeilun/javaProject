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
import com.meilun.utils.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    TagsService tagsService;

    @Autowired
    UserService userService;



    @GetMapping("/admin")
    public String blog(HttpServletRequest request){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        toPageProcess(user,request,1);

        return "admin/blog";
    }


    @RequestMapping("/{pageId}")
    public String toPage(@PathVariable("pageId") long pageId, HttpServletRequest request){


        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        toPageProcess(user,request,pageId);

        return "/admin/blog";
    }


    @GetMapping("/detail/{pageBid}")
    public String toDetailPage(@PathVariable("pageBid") long pageBid,HttpServletRequest reques){

        System.out.println(pageBid);

        Blog blog = blogService.getById(pageBid);

        blog.setBViews(blog.getBViews()+1);
        blogService.updateById(blog);

        User user = userService.getOne(new QueryWrapper<User>().eq("u_id", blog.getBUserid()));
        blog.setBUser(user);

        Tags tag = tagsService.getOne(new QueryWrapper<Tags>().eq("t_id", blog.getBTagid()));
        blog.setBTag(tag);

//        System.out.println(blog);


        Blog blog1 = new Blog();
        BeanUtils.copyProperties(blog,blog1);
        String bContent = blog1.getBContent();
        blog1.setBContent(MarkdownUtils.markdownToHtmlExtensions(bContent));
        reques.setAttribute("detailBlog",blog1);

        return "blog";

    }


    //根据pageId查询页面
    public void toPageProcess(User user,HttpServletRequest request,long pageId){

        IPage<Blog> tagsIPage = blogService.selectAllBlog(user.getUId(),pageId);

        long total = tagsIPage.getTotal();
        List<Blog> list = tagsIPage.getRecords();

        for (int i = 0; i < list.size(); i++) {
            Tags tag = tagsService.getOne(new QueryWrapper<Tags>().eq("t_id", list.get(i).getBTagid()));
//            User user1 = userService.getOne(new QueryWrapper<User>().eq("u_id", list.get(i).getBUserid()));
            tagsIPage.getRecords().get(i).setBTag(tag);
//            tagsIPage.getRecords().get(i).setBUser(user1);
        }

        request.setAttribute("blogpage",tagsIPage);
        System.out.println(tagsIPage.getRecords());
        System.out.println(tagsIPage);

    }


    @GetMapping("/input")
    public String input(HttpServletRequest request,RedirectAttributes redirectAttributes){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        QueryWrapper<Blog> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("b_userid",user.getUId()).eq("b_ispulish",false);
        long count = blogService.count(queryWrapper);

        if(count>2){
            redirectAttributes.addFlashAttribute("errormessage","您的待审核文章过多，请稍后添加");
            return "redirect:/blog/admin";
        }

        List<Tags> tags = tagsService.selectAllTagsByUidNotPage(user.getUId());

        request.setAttribute("tags",tags);
        return "admin/bloginput";
    }


    @PostMapping("/add")
    public String addBlog(Blog blog ,HttpServletRequest request ,HttpSession session, RedirectAttributes redirectAttributes){


        User user = (User) session.getAttribute("user");
        QueryWrapper<Blog> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("b_userid",user.getUId()).eq("b_ispulish",false);
        long count = blogService.count(queryWrapper);

        if(count>2){
            redirectAttributes.addFlashAttribute("errormessage","您的待审核文章过多，请稍后添加");
            return "redirect:/blog/input";
        }

        if(blog.getBIspublic() == null){
            blog.setBIspublic(false);
        }

        blog.setBIspulish(false);
        blog.setBUserid(user.getUId());
        blog.setBDate(new Date());
        blog.setBViews(0);
        blogService.save(blog);


        redirectAttributes.addFlashAttribute("errormessage","添加成功,等待管理员审核完成后即可上线");
        return "redirect:/blog/admin";
    }


    @RequestMapping("/searchByTagsId/{tagId}")
    public String searchByTagsId(@PathVariable("tagId") long tagId,HttpServletRequest request){

        toTagsIdProcess(request,tagId,1);
        return "blogByTagsId";
    }

    @RequestMapping("/searchByTagsId/{tagId}/{pageId}")
    public String searchByTagsId(@PathVariable("tagId") long tagId,@PathVariable("pageId") long pageId,HttpServletRequest request){

        toTagsIdProcess(request,tagId,pageId);
        return "blogByTagsId";
    }

    public void toTagsIdProcess(HttpServletRequest request,long tid,long page){

        CommonPage<Blog> tagsIPage = blogService.selectAllBlogByTagsId(tid,page);
        long total = tagsIPage.getTotal();
        List<Blog> list = tagsIPage.getRecords();

        for (int i = 0; i < list.size(); i++) {
//            Tags tag = tagsService.getOne(new QueryWrapper<Tags>().eq("t_id", list.get(i).getBTagid()));
            User user1 = userService.getOne(new QueryWrapper<User>().eq("u_id", list.get(i).getBUserid()));

            tagsIPage.getRecords().get(i).setBUser(user1);
        }
        request.setAttribute("thisTagsId",tid);
        request.setAttribute("indexpage",tagsIPage);
    }


}
