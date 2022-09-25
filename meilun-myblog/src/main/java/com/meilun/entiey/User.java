package com.meilun.entiey;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
@ToString
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long uId;

    /**
     * 用户头像
     */
    private String uPicture;

    /**
     * 用户昵称
     */
    private String uNickname;

    /**
     * 用户名
     */
    private String uUsername;

    /**
     * 用户密码
     */
    private String uPassword;

    /**
     * 用户邮箱
     */
    private String uEmail;

    /**
     * 用户手机
     */
    private String uPhone;

    /**
     * 用户github地址
     */
    private String uGithub;

    /**
     * 用户微信
     */
    private String uWechat;

    /**
     * 用户qq
     */
    private String uQq;

    /**
     * 该用户的博客列表
     */
    private List<Blog> uBlogList;

    /**
     * 该用户的分类列表
     */
    private List<Tags> uTagsList;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;



}