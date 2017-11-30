package com.zhao.mapper;
        import java.util.List;
        import org.apache.ibatis.annotations.Param;
        import com.zhao.pojo.*;

public interface S_CMapper {

    //根据课程id返回学生集合
    List<Student> getByCourse(int courseId);
    //根据学生id返回课程集合
    List<Course>  getByStudent(int StudentId);
    //通过学生id删除sc表中的相应所有记录
    void deleteAllByStudent(int id);
    //通过课程id 删除表中的所有相应记录
    void deleteAllByCourse(int id);
    //通过学生id 更新courseid
    void deleteOneLine(@Param("studentId") int studentId, @Param("courseId")int courseId);
    void updateByStudent(@Param("studentId") int studentId, @Param("courseId")int courseId);
    //param注解传入多个参数
    void updateByCourse(@Param("studentId") int studentId, @Param("courseId")int courseId);
    void add(@Param("studentId") int studentId, @Param("courseId")int courseId);
    Integer get(@Param("studentId")int studentId,@Param("courseId")int courseId);
}
