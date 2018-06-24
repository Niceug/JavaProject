package com.ltp.mappers;

import com.ltp.entities.Teacher;

public interface TeacherMapper {

    /**
     * 添加教师信息
     * @param t
     * @return
     */
    boolean addTeacher(Teacher t);

    /**
     * 删除教师信息
     * @param teacherNo
     * @return
     */
    boolean deleteTeacher(int teacherNo);


    /**
     * 修改教师信息
     * @param t
     * @return
     */
    boolean updateTeacher(Teacher t);

    /**
     * 查询教师信息
     * @param teacherNo
     * @return
     */
    Teacher queryTeacher(int teacherNo);
}
