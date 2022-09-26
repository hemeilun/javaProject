package com.meilun.entiey;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * 
 * @TableName user_tags
 */
@TableName(value ="user_tags")
@Data
@ToString
public class UserTags implements Serializable {
    /**
     * 
     */
    @TableId
    private Long utId;

    /**
     * 
     */
    private Long uId;

    /**
     * 
     */
    private Long tId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}