package SSM.Service.Impl;

import SSM.Dao.IEmailDao;
import SSM.Dao.ITeacherDao;
import SSM.Domain.Email;
import SSM.Domain.Teacher;
import SSM.Service.EmailService;
import SSM.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service("emailService")
public class EmailServiceImpl implements EmailService {
    private final IEmailDao iEmailDao;
    private final ITeacherDao iTeacherDao;
    @Autowired
    private EmailServiceImpl(IEmailDao iEmailDao,ITeacherDao iTeacherDao){
        this.iEmailDao=iEmailDao;
        this.iTeacherDao=iTeacherDao;
    }

    @Override
    public List<Email> findAll() {
        return iEmailDao.findAll();
    }

    @Override
    public Email findOne(int EID) {
        return iEmailDao.findOne(EID);
    }

    @Override
    public void updateEmail(Email email) {
        iEmailDao.updateEmail(email);
    }

    @Override
    public void createEmail(Email email) {
        iEmailDao.createEmail(email);
    }

    @Override
    public void deleteEmail(int EID) {
        iEmailDao.deleteEmail(EID);
    }

    @Override
    public List<Email> findEmailByTeacher(int tID) {
        return iEmailDao.findEmailByTeacher(tID);
    }

    @Override
    public String sendEmail(Map<String,Object> map)throws SQLException {
        Email email = (Email)map.get("Email");
        String context =(String)map.get("context");
        String TName =(String)map.get("TName");
        iEmailDao.createEmail(email);
        Teacher teacher=iTeacherDao.findOne(TName);
        Utils.sendEmail(email.getETitle(),context,teacher.getEmail());
        return "succeed";
    }
}
