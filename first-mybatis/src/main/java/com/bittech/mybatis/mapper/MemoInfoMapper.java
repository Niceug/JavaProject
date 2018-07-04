package com.bittech.mybatis.mapper;

import com.bittech.mybatis.common.Page;
import com.bittech.mybatis.entity.MemoInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2018/6/30
 */
public interface MemoInfoMapper {
    
    /**
     * 插入便签信息，会自增长的主键值赋给对象
     *
     * @param memoInfo 便签对象
     * @return
     */
    int insertMemoInfo(MemoInfo memoInfo);
    
    /**
     * 根据ID查询便签信息
     *
     * @param id
     * @return
     */
    MemoInfo queryMemoInfoById(Integer id);
    
    /**
     * 更新便签信息，要求对象中id属性不能为空
     *
     * @param memoInfo
     * @return
     */
    int updateMemoInfo(MemoInfo memoInfo);
    
    //select * from memo_info limit pageSize offset (pageNumber-1)*pageSize order by columnName
    List<MemoInfo> queryByPage(
            @Param("pageSize") Integer pageSize,
            @Param("pageOffset") Integer pageOffset,
            @Param("columnName") String columnName
    );
    
    /**
     * 多个参数包装成为引用类型
     *
     * @param page
     * @return
     */
    List<MemoInfo> queryByPageWithObject(Page page);
    
    /**
     * 根据ID删除便签信息
     *
     * @param id
     * @return
     */
    int deleteMemoInfoById(@Param("memoInfoId") Integer id);
    
    /**
     * 根据便签组ID查询组中的便签信息
     *
     * @param groupId
     * @return
     */
    List<MemoInfo> queryMemoInfoByGroupId(@Param("groupId") Integer groupId);

    /**
     * 根据标题，内容，创建时间查询便签信息
     * @param title
     * @param content
     * @param createdTime
     * @return
     */
    List<MemoInfo> queryMemoInfoByTitleAndContentAndCreatedTime(
            @Param("title") String title, @Param("content") String content, @Param("createdTime") Date createdTime);

    /**
     * 更新便签信息
     * @param memoInfo
     * @return
     */
    int updateMemoInfoByMemo(MemoInfo memoInfo);

    /**
     * 根据私密状态或者提醒状态查询便签信息
     * @param privacy
     * @param remind
     * @return
     */
    List<MemoInfo> queryMemoInfoByPrivacy(
            @Param("privacy") Character privacy, @Param("remind") Character remind);


    /**
     * 查询符合一组编号的便签信息
     * @param list
     * @return
     */
    List<MemoInfo> queryMemoInfoFromIds(List<Integer> list);
}
