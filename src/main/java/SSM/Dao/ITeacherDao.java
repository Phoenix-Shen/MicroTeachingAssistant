package SSM.Dao;

import SSM.Domain.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.List;
/*
    private int ID;
    private String name;
    private String password;
    private String email;
*/

@Repository
public interface ITeacherDao {
    @Select("Select * from teacher")
    List<Teacher> findAll()throws SQLException;
    @Insert("insert into teacher (name,password,email) values(#{name},#{password},#{email})")
    void createTeacher(Teacher teacher)throws SQLException;
    @Delete("Delete from teacher where id=#{ID}")
    void deleteTeacher(@Param("ID")int ID)throws SQLException;
    @Select("Select * from teacher where id=#{ID}")
    Teacher findOne(@Param("ID")int ID) throws SQLException;
    @Update("update teacher set name=#{name} , password=#{password} , email=#{email} where ID=#{ID}")
    void updateTeacher(Teacher teacher);
}
