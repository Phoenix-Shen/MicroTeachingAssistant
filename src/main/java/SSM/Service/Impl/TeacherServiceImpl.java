package SSM.Service.Impl;

import SSM.Dao.ITeacherDao;
import SSM.Domain.Teacher;
import SSM.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    private final ITeacherDao iTeacherDao;

    @Autowired
    public TeacherServiceImpl(ITeacherDao iTeacherDao){
        this.iTeacherDao=iTeacherDao;
    }

    @Override
    public List<Teacher> findAll() throws SQLException {
        return iTeacherDao.findAll();
    }

    @Override
    public void createTeacher(Teacher teacher) throws SQLException {
        iTeacherDao.createTeacher(teacher);
    }

    @Override
    public void deleteTeacher(int ID) throws SQLException {
        iTeacherDao.deleteTeacher(ID);
    }

    @Override
    public Teacher findOne(int ID) throws SQLException {
        return iTeacherDao.findOne(ID);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        iTeacherDao.updateTeacher(teacher);
    }
}
