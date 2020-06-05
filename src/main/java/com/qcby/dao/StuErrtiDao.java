package com.qcby.dao;

import com.qcby.entity.StuErrti;
import com.qcby.entity.StuErrtiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StuErrtiDao {
    long countByExample(StuErrtiExample example);

    int deleteByExample(StuErrtiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StuErrti record);

    int insertSelective(StuErrti record);

    List<StuErrti> selectByExampleWithRowbounds(StuErrtiExample example, RowBounds rowBounds);

    List<StuErrti> selectByExample(StuErrtiExample example);

    StuErrti selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StuErrti record, @Param("example") StuErrtiExample example);

    int updateByExample(@Param("record") StuErrti record, @Param("example") StuErrtiExample example);

    int updateByPrimaryKeySelective(StuErrti record);

    int updateByPrimaryKey(StuErrti record);
}