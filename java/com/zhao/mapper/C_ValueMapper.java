package com.zhao.mapper;

import org.apache.ibatis.annotations.Param;

import com.zhao.pojo.*;

public interface C_ValueMapper {
     Course_Value get(int courseId);
     void add( Course_Value course_value);
     void update(@Param("courseId") int courseId, @Param("course_value") Course_Value course_value);
     //删除一个课程所对应的所有属性值   因为我的表中course与coursevalue 为一对一关系 所以只存在这一种删除
     //当然这种设计是十分错误的 这样设计只是因为想尝试不同的做法
     void delete(int course_id);

}
