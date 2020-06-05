package com.qcby.dao;

import com.qcby.entity.KuJianda;
import com.qcby.entity.KuJiandaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface KuJiandaDao {
    long countByExample(KuJiandaExample example);

    int deleteByExample(KuJiandaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(KuJianda record);

    int insertSelective(KuJianda record);

    List<KuJianda> selectByExampleWithRowbounds(KuJiandaExample example, RowBounds rowBounds);

    List<KuJianda> selectByExample(KuJiandaExample example);

    KuJianda selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") KuJianda record, @Param("example") KuJiandaExample example);

    int updateByExample(@Param("record") KuJianda record, @Param("example") KuJiandaExample example);

    int updateByPrimaryKeySelective(KuJianda record);

    int updateByPrimaryKey(KuJianda record);
}