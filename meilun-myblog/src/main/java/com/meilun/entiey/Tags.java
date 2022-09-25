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
 * @TableName tags
 */
@TableName(value ="tags")
@Data
@ToString
public class Tags implements Serializable {
    /**
     * 分类id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long tId;

    /**
     * 分类名称
     */
    private String tName;

    /**
     * 属于哪个用户
     */
    private Long tUserid;

    /**
     * 属于的用户
     */
    private User tUser;

    /**
     * 该标签下的博客列表
     */
    private List<Blog> tBlogList;

    /**
     * 拥有该标签的用户
     */
    private List<User> tUserList;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}