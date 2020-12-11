package SSM.Service.Impl;

import SSM.Dao.IEmailDao;
import SSM.Domain.Email;
import SSM.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("emailService")
public class EmailServiceImpl implements EmailService {
    private IEmailDao iEmailDao;

    @Autowired
    private EmailServiceImpl(IEmailDao iEmailDao){
        this.iEmailDao=iEmailDao;
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
}
