package com.bittech.mybatis.entity;

import com.bittech.mybatis.common.BackGround;
import lombok.Data;

import java.util.Date;

/**
 * Author: secondriver
 * Created: 2018/6/30
 */
@Data
public class MemoInfo {
    private Integer id;
    private Integer groupId;
    private String title;
    private String content;
    private Character privacy;
    private BackGround backGround;
    private Character remind;
    private Date remindTime;
    private Date createdTime;
    private Date modifyTime;
    
}
