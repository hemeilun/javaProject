package com.meiluna.eduservice.controller;

import com.meiluna.commonutils.R;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/eduservice/user")
public class EduUserController {

    @PostMapping("login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("info")
    public R info(){
        return R.ok().data("name","admin").data("avatar","https://image.meiluna.cn/wallhaven-6dq1w6.jpg");
    }
}
