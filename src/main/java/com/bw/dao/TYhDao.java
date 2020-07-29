package com.bw.dao;

import com.bw.model.TYh;
import com.bw.model.TYhExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TYhDao {
    long countByExample(TYhExample example);

    int deleteByExample(TYhExample example);

    int insert(TYh record);

    int insertSelective(TYh record);

    List<TYh> selectByExample(TYhExample example);

    int updateByExampleSelective(@Param("record") TYh record, @Param("example") TYhExample example);

    int updateByExample(@Param("record") TYh record, @Param("example") TYhExample example);
}