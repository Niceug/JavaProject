package com.bittech.mybatis.entity;

import lombok.Data;

import java.util.Date;

/**
 * Author: secondriver
 * Created: 2018/6/23
 */
@Data
public class MemoGroup {
    
    private Integer id;
    
    private String name;
    
    private Date createdTime;
    
    private Date modifyTime;
    
}
