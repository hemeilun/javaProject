package com.meilun.entiey;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * 
 * @TableName comment
 */
@TableName(value ="comment")
@Data
@ToString
public class Comment implements Serializable {
    /**
     * 评论id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long cId;

    /**
     * 评论内容
     */
    private String cContent;

    /**
     * 评论时间
     */
    private Date cCreatedate;

    /**
     * 评论用户id
     */
    private Long cUserid;

    /**
     * 属于几级评论
     */
    private Long cParentcommentid;

    /**
     * 属于哪篇博客
     */
    private Blog cBlog;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}