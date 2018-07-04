package com.bittech.mybatis.mapper;

import com.bittech.mybatis.entity.MemoGroup;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2018/6/23
 */
public interface MemoGroupMapper {
    
    /**
     * 查询所有便签组
     *
     * @return
     */
    List<MemoGroup> queryAll(@Param("columnName") String columnName);
    
    MemoGroup queryById(Integer id);
    
    MemoGroup queryByIdWithResultType(Integer id);
    
    HashMap queryByIdWithHashMap(Integer id);
    
    /**
     * 插入一个便签组
     *
     * @param memoGroup
     * @return
     */
    int insetMemoGroup(MemoGroup memoGroup);
    
    /**
     * 修改便签组的名称
     *
     * @param id
     * @param name
     * @return
     */
    int updateMemoGroup(@Param("id") int id, @Param("name") String name);
    
    /**
     * 根据Id删除便签组
     *
     * @param id
     * @return
     */
    int deleteMemoGroup(int id);
}
