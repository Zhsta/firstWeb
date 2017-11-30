
package com.zhao.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zhao.pojo.*;

public interface CourseMapper {

    Course get(int id);
    List<Course> listAllCourse();
    List<Course> getAll(String courseName);
    Integer getId(@Param("courseName") String  courseName,@Param("teacherId") int teacherId);
     List<Course> getCourseByTeacher(int teacherId);
    //根据coursename 删除记录
    void delete(String courseName);
    //增添
    void add(Course course);
    //更新;
    void updateByCourse(@Param("course_name") String course_name,@Param("teacher_id")int teacher_id);
    void updateByTeacher(@Param("teacher_id")int teacher_id,@Param("course_name") String course_name);
    void deleteById(int courseId);
}
