package Dao;

import SSM.Domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import SSM.Dao.IEmailDao;

import java.util.Date;
import java.util.List;

public class EmailDaoTest {
    private IEmailDao iemailDao;

    @Test
    public void createEmail(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iemailDao = (IEmailDao) ac.getBean("IEmailDao");
        Email email=new Email();
        email.setETitle("44444");
        email.setSender("Pimon");
        email.setSendTime(new Date());
        email.setTID(3);
        iemailDao.createEmail(email);
    }

    @Test
    public void findOne(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iemailDao = (IEmailDao) ac.getBean("IEmailDao");
        Email email = iemailDao.findOne(1);
        if(email!=null){
        System.out.println(email.getETitle());
    }}

    @Test
    public void findAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iemailDao = (IEmailDao) ac.getBean("IEmailDao");
        List<Email> emailList = iemailDao.findAll();
        for (Email e:emailList
             ) {
            System.out.println(e.getETitle());
        }
    }

    @Test
    public void updateEmail(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iemailDao = (IEmailDao) ac.getBean("IEmailDao");
        Email email=new Email();
        email.setETitle("44444");
        email.setSender("Pimon");
        email.setSendTime(new Date());
        email.setTID(3);
        iemailDao.updateEmail(email);
    }

    @Test
    public void deleteEmail(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iemailDao = (IEmailDao) ac.getBean("IEmailDao");
        iemailDao.deleteEmail(1);
    }
    @Test
    public void findEmaillByTeacher(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iemailDao = (IEmailDao) ac.getBean("IEmailDao");
        List<Email> emailList = iemailDao.findEmailByTeacher(3);
        for (Email e:emailList
        ) {
            System.out.println(e.getETitle());
        }
    }
}
