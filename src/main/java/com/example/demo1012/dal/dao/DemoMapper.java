package com.example.demo1012.dal.dao;

import com.example.demo1012.model.Demo01;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author xujiajun
 * @since 2026/10/12
 */
@Mapper
public interface DemoMapper {

    @Select("SELECT * FROM demo01 WHERE id = #{id}")
    Demo01 getById(@Param("id") Integer id);

    Demo01 getByName(@Param("name") String name);
}
