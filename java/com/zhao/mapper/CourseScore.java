package com.zhao.mapper;

import org.apache.ibatis.annotations.Param;

public interface CourseScore {
    void add(@Param("student_id") int student_id,@Param("course_id") int course_id,@Param("score") double score);

    //只可能根据student——id来更改
    void update(@Param("student_id") int student_id,@Param("course_id") int course_id,@Param("score") double score);
    Double get(@Param("student_id") int student_id,@Param("course_id") int course_id);
    void delete(@Param("student_id") int student_id,@Param("course_id") int course_id);
    void deleteAllByStudentId(@Param("student_id") int studentId);
    void deleteAllByCourseId(@Param("course_id") int course_id);
}
