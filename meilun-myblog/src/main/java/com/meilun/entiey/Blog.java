package com.meilun.entiey;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * 
 * @TableName blog
 */
@TableName(value ="blog")
@Data
@ToString
public class Blog implements Serializable {
    /**
     * 博客id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long bId;

    /**
     * 博客标题
     */
    private String bTitle;

    /**
     * 博客内容
     */
    private String bContent;

    /**
     * 博客图片
     */
    private String bPicture;

    /**
     * 博客访问数
     */
    private Integer bViews;

    /**
     * 博客创建如期
     */
    private Date bDate;

    /**
     * 博客是否公开
     */
    private Boolean bIspublic;

    /**
     * 博客是否发布
     */
    private Boolean bIspulish;

    /**
     * 博客属于哪个标签
     */
    private Long bTagid;

    /**
     * 博客属于哪个用户
     */
    private Long bUserid;

    /**
     * 博客描述
     */
    private String bDescription;

    /**
     * 博客标签
     */
    private Tags bTag;

    /**
     * 博客属于的用户
     */
    private User bUser;

    /**
     * 博客评论
     */
    private List<Comment> bCommentList;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}