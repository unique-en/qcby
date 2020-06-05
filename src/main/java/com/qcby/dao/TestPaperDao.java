package com.qcby.dao;

import com.qcby.entity.TestPaper;
import com.qcby.entity.TestPaperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TestPaperDao {
    long countByExample(TestPaperExample example);

    int deleteByExample(TestPaperExample example);

    int deleteByPrimaryKey(String testId);

    int insert(TestPaper record);

    int insertSelective(TestPaper record);

    List<TestPaper> selectByExampleWithRowbounds(TestPaperExample example, RowBounds rowBounds);

    List<TestPaper> selectByExample(TestPaperExample example);

    TestPaper selectByPrimaryKey(String testId);

    int updateByExampleSelective(@Param("record") TestPaper record, @Param("example") TestPaperExample example);

    int updateByExample(@Param("record") TestPaper record, @Param("example") TestPaperExample example);

    int updateByPrimaryKeySelective(TestPaper record);

    int updateByPrimaryKey(TestPaper record);
}