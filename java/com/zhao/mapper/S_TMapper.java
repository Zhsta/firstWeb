package com.zhao.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zhao.pojo.*;

public interface S_TMapper {
    List<Teacher> getByStudent(int id);//根据学生id返回老师
    List<Student> getByTeacher(int id);//根据老师id返回学生
    void deleteAllByStudent(int id);//通过学生id删除从st表中删除老师信息 目的是为了实现关联删除
    void deleteOneLine(@Param("studentId") int studentId, @Param("teacherId")int teacherId);

    void deleteAllByTeacher(int id);//通过老师id从st表中删除学生信息 目的是为了实现关联删除

    //根据学生的id 将st表中的 相对应的teacherid 改为传入的teacherid
    void updateByStudent(@Param("studentId") int studentId, @Param("teacherId")int teacherId);

    //param注解传入多个参数
    //根据老师的id 将st表中的 相对应的studentid 改为传入的studentrid
    void updateByTeacher(@Param("studentId") int studentId, @Param("teacherId")int teacherId);
    //根据传入的studentid和teacherid在st表中新建一条记录
    void add(@Param("studentId") int studentId, @Param("teacherId")int teacherId);
}
