package com.bittech.mybatis.common;

import lombok.Data;

/**
 * Author: secondriver
 * Created: 2018/6/30
 */
@Data
public class Page {
    
    private Integer pageSize = 10;
    
    private Integer pageNumber = 1;
    
    private Integer pageOffset = (this.getPageNumber() - 1) * this.getPageSize();
    
    private String orderColumnName;
    
    public Integer getPageOffset() {
        this.pageOffset =
                (this.getPageNumber() - 1) * this.getPageSize();
        return this.pageOffset;
    }
}
