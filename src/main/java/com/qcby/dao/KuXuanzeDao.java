package com.qcby.dao;

import com.qcby.entity.KuXuanze;
import com.qcby.entity.KuXuanzeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface KuXuanzeDao {
    long countByExample(KuXuanzeExample example);

    int deleteByExample(KuXuanzeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(KuXuanze record);

    int insertSelective(KuXuanze record);

    List<KuXuanze> selectByExampleWithRowbounds(KuXuanzeExample example, RowBounds rowBounds);

    List<KuXuanze> selectByExample(KuXuanzeExample example);

    KuXuanze selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") KuXuanze record, @Param("example") KuXuanzeExample example);

    int updateByExample(@Param("record") KuXuanze record, @Param("example") KuXuanzeExample example);

    int updateByPrimaryKeySelective(KuXuanze record);

    int updateByPrimaryKey(KuXuanze record);
}