package com.qfedu.dao;

import com.qfedu.domain.Recode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecodeDao {

    //新增
    @Insert("insert into t_recode(name,classname,title,res,createTime) values(#{name},#{classname},#{title},#{res},now())")
    int save(Recode recode);

    // 查询详情
    @Select("select id,name,classname,title,res,createTime from t_recode where id=#{id}")
    @ResultType(Recode.class)
    Recode queryById(int id);

    // 查询分页
    @Select("select id,name,classname,title,res,createTime from t_recode order by id desc limit #{index},#{count}")
    @ResultType(Recode.class)
    List<Recode> queryByPage(@Param("index") int index, @Param("count") int count);

    // 查询数量
    @Select("select count(*) from t_recode")
    @ResultType(long.class)
    long queryCount();

    // 模糊查询
    @Select("select id,name,classname,title,res,createTime from t_recode where name like #{msg} or title like #{msg} " +
            "order by id desc ")
    @ResultType(Recode.class)
    List<Recode> queryByLike(String msg);
}
