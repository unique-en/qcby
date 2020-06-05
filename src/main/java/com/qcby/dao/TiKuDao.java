package com.qcby.dao;

import com.qcby.entity.TiKu;
import com.qcby.entity.TiKuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TiKuDao {
    long countByExample(TiKuExample example);

    int deleteByExample(TiKuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TiKu record);

    int insertSelective(TiKu record);

    List<TiKu> selectByExampleWithRowbounds(TiKuExample example, RowBounds rowBounds);

    List<TiKu> selectByExample(TiKuExample example);

    TiKu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TiKu record, @Param("example") TiKuExample example);

    int updateByExample(@Param("record") TiKu record, @Param("example") TiKuExample example);

    int updateByPrimaryKeySelective(TiKu record);

    int updateByPrimaryKey(TiKu record);
}