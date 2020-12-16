package Dao;
import SSM.Dao.*;
import SSM.Domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
public class CheckInDaoTest {
    private ICheckInDao iCheckInDao;
    @Test
    public void createCheckIn(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iCheckInDao = (ICheckInDao) ac.getBean("ICheckInDao");
        CheckIn ck = new CheckIn();
        ck.setSTUID(11111121);
        ck.setCID(4);
        ck.setStuName("111112");
        ck.setCheckTime(new Date());
        ck.setCheckLocation("武汉");
        iCheckInDao.createCheckIn(ck);
    }
    @Test
    public void findOneListResult(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iCheckInDao = (ICheckInDao) ac.getBean("ICheckInDao");
        List<CheckIn> checkList = iCheckInDao.findOneListResult(3);
        for (CheckIn re : checkList
        ) {
            System.out.println(re.getStuName());
        }
    }
    @Test
    public void findOne(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iCheckInDao = (ICheckInDao) ac.getBean("ICheckInDao");
        CheckIn ckin = iCheckInDao.findOne(3,1111111);
        System.out.println(ckin);
    }

    @Test
    public void findAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iCheckInDao = (ICheckInDao) ac.getBean("ICheckInDao");
        List<CheckIn> checkList = iCheckInDao.findAll();
        for (CheckIn re : checkList
        ) {
            System.out.println(re.getStuName());
        }
    }

    @Test
    public void updateCheckIn(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iCheckInDao = (ICheckInDao) ac.getBean("ICheckInDao");
        CheckIn ck = new CheckIn();
        ck.setSTUID(1111111);
        ck.setCID(3);
        ck.setStuName("大大肥肥");
        ck.setCheckTime(new Date());
        ck.setCheckLocation("武汉");
        iCheckInDao.updateCheckIn(ck);
    }

    @Test
    public void deleteCheckIn(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iCheckInDao = (ICheckInDao) ac.getBean("ICheckInDao");
        iCheckInDao.deleteCheckIn(3,1111111);
    }
}
