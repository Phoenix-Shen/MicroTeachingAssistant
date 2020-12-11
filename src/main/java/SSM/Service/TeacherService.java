package SSM.Service;

import SSM.Domain.Teacher;


import java.sql.SQLException;
import java.util.List;

public interface TeacherService {
    List<Teacher> findAll()throws SQLException;
    void createTeacher(Teacher teacher)throws SQLException;
    void deleteTeacher(int ID)throws SQLException;
    Teacher findOne(int ID) throws SQLException;
    void updateTeacher(Teacher teacher);
}
