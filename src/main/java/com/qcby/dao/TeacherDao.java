package com.qcby.dao;

import com.qcby.entity.Teacher;
import com.qcby.entity.TeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TeacherDao {
    long countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(String teacId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExampleWithRowbounds(TeacherExample example, RowBounds rowBounds);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(String teacId);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}