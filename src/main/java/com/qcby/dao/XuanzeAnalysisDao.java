package com.qcby.dao;

import com.qcby.entity.XuanzeAnalysis;
import com.qcby.entity.XuanzeAnalysisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface XuanzeAnalysisDao {
    long countByExample(XuanzeAnalysisExample example);

    int deleteByExample(XuanzeAnalysisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XuanzeAnalysis record);

    int insertSelective(XuanzeAnalysis record);

    List<XuanzeAnalysis> selectByExampleWithRowbounds(XuanzeAnalysisExample example, RowBounds rowBounds);

    List<XuanzeAnalysis> selectByExample(XuanzeAnalysisExample example);

    XuanzeAnalysis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XuanzeAnalysis record, @Param("example") XuanzeAnalysisExample example);

    int updateByExample(@Param("record") XuanzeAnalysis record, @Param("example") XuanzeAnalysisExample example);

    int updateByPrimaryKeySelective(XuanzeAnalysis record);

    int updateByPrimaryKey(XuanzeAnalysis record);

    List<XuanzeAnalysis> selectAll();
}