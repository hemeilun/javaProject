package com.meilun.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meilun.entiey.User;
import com.meilun.service.MailService;
import com.meilun.service.UserService;
import com.meilun.utils.BCryptUtil;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.UUID;


//$2a$10$3VBeaoVQS.fJxIEzlL1EMuie7Ip/vou2wbhBEQmf4EsOPcy4gt3bu

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private MailService mailService;

    @RequestMapping("/login")
    public String returnLogin(){
        return "login";
    }


    @PostMapping("/loginverify")
    public String login(User user, HttpServletRequest request, RedirectAttributes redirectAttributes){


//        ModelAndView mav = new ModelAndView();

        if(user.getUUsername() == null || "".equals(user.getUUsername())){
            redirectAttributes.addFlashAttribute("errormessage","用户名为空");
            return "redirect:/user/login";
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_username",user.getUUsername());
        User one = userService.getOne(queryWrapper);

        if(one == null){
            redirectAttributes.addFlashAttribute("errormessage","不存在此用户");
            return "redirect:/user/login";
        }else {
            boolean checkpw = BCrypt.checkpw(user.getUPassword(), one.getUPassword());
            if(checkpw == false){
                redirectAttributes.addFlashAttribute("errormessage","用户名或密码错误");
                return "redirect:/user/login";
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("user",one);
                return "admin/person";
            }
        }
    }

    /**
     * 显示注册页面
     * @return
     */
    @GetMapping("/regist")
    public String regist(){
        return "regist";
    }


    /**
     * 注册页面验证
     * @return
     */
    @PostMapping("/registverify")
    public String registVerify(User user,@RequestParam("surePassword") String surePassword,RedirectAttributes redirectAttributes){

//        System.out.println(user+"     "+surePassword);

        if(!user.getUPassword().equals(surePassword)){
            redirectAttributes.addFlashAttribute("errormessage","两次密码输入不一致");
            return "redirect:/user/regist";
        }

        if(!user.getUEmail().equals(user.getUUsername())){
            redirectAttributes.addFlashAttribute("errormessage","用户名需与邮箱保持一致");
            return "redirect:/user/regist";
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_username",user.getUUsername());
        User one = userService.getOne(queryWrapper);


        if(one == null){
            String BPassword = BCryptUtil.bCrypt(user.getUPassword());
            String uuid = BCryptUtil.bCrypt(UUID.randomUUID ().toString ());
            user.setUPassword(BPassword);
            user.setUActivationCode(uuid);
            user.setUIsActive(false);
            userService.save(user);

            mailService.sendHtmlMail(user.getUUsername(),uuid);


            return "active";
        }else {
            redirectAttributes.addFlashAttribute("errormessage","用户名已被注册");
            return "redirect:/user/regist";
        }

    }


    @RequestMapping("/active")
    public String active(){
        return "active";
    }


    /**
     * 用户激活
     */
    @RequestMapping("/activeverify")
    public String activeverify(@RequestParam("uActivationCode") String uActivationCode,RedirectAttributes redirectAttributes){

        if(uActivationCode==null || "".equals(uActivationCode)){
            return "redirect:/user/active";
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_activation_code",uActivationCode).eq("u_is_active",false);

        User one = userService.getOne(queryWrapper);

        if(one==null){
            redirectAttributes.addFlashAttribute("errormessage","激活码错误或已被激活");
            return "redirect:/user/active";
        }else{
            one.setUIsActive(true);
            userService.saveOrUpdate(one);
            return "activesuccess";
        }

    }


}
