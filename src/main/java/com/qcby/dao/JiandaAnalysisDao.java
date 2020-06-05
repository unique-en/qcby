package com.qcby.dao;

import com.qcby.entity.JiandaAnalysis;
import com.qcby.entity.JiandaAnalysisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface JiandaAnalysisDao {
    long countByExample(JiandaAnalysisExample example);

    int deleteByExample(JiandaAnalysisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JiandaAnalysis record);

    int insertSelective(JiandaAnalysis record);

    List<JiandaAnalysis> selectByExampleWithRowbounds(JiandaAnalysisExample example, RowBounds rowBounds);

    List<JiandaAnalysis> selectByExample(JiandaAnalysisExample example);

    JiandaAnalysis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JiandaAnalysis record, @Param("example") JiandaAnalysisExample example);

    int updateByExample(@Param("record") JiandaAnalysis record, @Param("example") JiandaAnalysisExample example);

    int updateByPrimaryKeySelective(JiandaAnalysis record);

    int updateByPrimaryKey(JiandaAnalysis record);
}