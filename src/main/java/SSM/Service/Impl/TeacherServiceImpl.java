package SSM.Service.Impl;

import SSM.Dao.ITeacherDao;
import SSM.Domain.Teacher;
import SSM.Service.TeacherService;
import SSM.Utils.BadException;
import SSM.Utils.ErrPswdException;
import SSM.Utils.TeacherNotFoundException;
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
    public Teacher findOne(String name) throws Exception {
        Teacher teacher;
        if((teacher =  iTeacherDao.findOne(name))==null){
            throw new BadException();
        }
        else {return teacher;   }
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        iTeacherDao.updateTeacher(teacher);
    }

    public Teacher teacherLogin(Teacher teacher) throws Exception {
        Teacher findResult = iTeacherDao.findOne(teacher.getName());
        //找不到该用户
        if(findResult==null){
            throw new TeacherNotFoundException();
        }
        //用户密码对不上
        else if(findResult.getPassword().compareTo(teacher.getPassword())!=0){
            throw new ErrPswdException();
        }
        //炸胡 居然让这小子登上去了
        else{
            findResult.setPassword(null);
            return  findResult;
        }
    }
}
