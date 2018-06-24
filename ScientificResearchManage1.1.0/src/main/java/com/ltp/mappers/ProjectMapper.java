package com.ltp.mappers;

import com.ltp.entities.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ProjectMapper {
    /**
     * 查询所有项目
     * @return
     */
    List<Project> queryAllProject();

    /**
     * 查询所有被验收的项目
     * @return
     */
    List<Project> queryCheckedDB();

    /**
     * 申报项目
     * @param p
     * @return
     */
    boolean addProject(Project p);

    /**
     * 根据项目编号查询项目
     * @param pNo 项目编号
     * @return
     */
    Project queryProjectByNo(int pNo);


    /**
     * 查询项目是否被审核
     * @param pNo
     * @return
     */
    Project queryCheckedProject(int pNo);

    /**
     * 审核项目
     * @param p
     * @return
     */
    boolean checkProject(Project p);

    /**
     * 验收项目
     * @param p
     */
    void passProject(Project p);

    /**
     * 获取院系列表
     * @return
     */
    List<String> getDepartmentList();

    /**
     * 获得全校申报项目总数
     */
    int getProjectCountDB();

    /**
     * 查询某个学院的项目申报数量
     * @param department
     * @return
     */
    int getProjectCountByDepartment(String department);


    /**
     * 查询各个学院项目已审核数量
     * @return
     */
    Map<String, Integer> getCheckedCountByDepartment();

}
