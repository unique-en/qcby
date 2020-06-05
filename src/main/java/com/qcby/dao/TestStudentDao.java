package com.qcby.dao;

import com.qcby.entity.TestStudent;
import com.qcby.entity.TestStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TestStudentDao {
    long countByExample(TestStudentExample example);

    int deleteByExample(TestStudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestStudent record);

    int insertSelective(TestStudent record);

    List<TestStudent> selectByExampleWithRowbounds(TestStudentExample example, RowBounds rowBounds);

    List<TestStudent> selectByExample(TestStudentExample example);

    TestStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestStudent record, @Param("example") TestStudentExample example);

    int updateByExample(@Param("record") TestStudent record, @Param("example") TestStudentExample example);

    int updateByPrimaryKeySelective(TestStudent record);

    int updateByPrimaryKey(TestStudent record);
}