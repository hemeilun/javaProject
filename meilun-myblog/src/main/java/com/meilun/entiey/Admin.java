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
 * @TableName admin
 */
@TableName(value ="admin")
@Data
@ToString
public class Admin implements Serializable {
    /**
     * 管理员id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long aId;

    /**
     * 管理员名称
     */
    private String aUsername;

    /**
     * 管理员密码
     */
    private String aPassword;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;



}