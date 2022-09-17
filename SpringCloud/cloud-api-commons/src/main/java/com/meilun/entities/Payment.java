package com.meilun.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName payment
 */

@Data
public class Payment implements Serializable {

    private Long id;
    private String serial;

}