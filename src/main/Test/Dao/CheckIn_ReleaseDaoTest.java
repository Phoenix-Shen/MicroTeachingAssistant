package Dao;

import SSM.Dao.ICheckIn_ReleaseDao;
import SSM.Domain.CheckIn_Release;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CheckIn_ReleaseDaoTest {
    private ICheckIn_ReleaseDao iCheckIn_releaseDao;
    //在junit 5 中 before 和 after 是无效的 他们被换成 BeforeEach和AfterEach
    /*
    @BeforeEach
    public void init(){
        System.out.println("init");
    }*/
    @Test
    public void findAll() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iCheckIn_releaseDao = (ICheckIn_ReleaseDao) ac.getBean("ICheckIn_ReleaseDao");
        List<CheckIn_Release> checkList = iCheckIn_releaseDao.findAll();
        for (CheckIn_Release re : checkList
        ) {
            System.out.println(re.getTitle());
        }
    }

    @Test
    public void createCheckin() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iCheckIn_releaseDao = (ICheckIn_ReleaseDao) ac.getBean("ICheckIn_ReleaseDao");
        CheckIn_Release cr = new CheckIn_Release();
        cr.setTID(3);
        cr.setTitle("1111");
        cr.setStartTime(new Date());
        cr.setEndTime(new Date());
        iCheckIn_releaseDao.createCheckIn_Release(cr);
    }

    @Test
    public void updateCheckin()  {
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iCheckIn_releaseDao = (ICheckIn_ReleaseDao) ac.getBean("ICheckIn_ReleaseDao");
        CheckIn_Release cr = new CheckIn_Release();
        cr.setCID(2);
        cr.setTID(3);
        cr.setTitle("2222");
        cr.setStartTime(new Date());
        cr.setEndTime(new Date());
        iCheckIn_releaseDao.updateCheckIn_Release(cr);
    }

    @Test
    public void deleteCheckin() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iCheckIn_releaseDao = (ICheckIn_ReleaseDao) ac.getBean("ICheckIn_ReleaseDao");
        iCheckIn_releaseDao.deleteCheckIn_Release(2);
    }

    @Test
    public void findOne() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iCheckIn_releaseDao = (ICheckIn_ReleaseDao) ac.getBean("ICheckIn_ReleaseDao");
        CheckIn_Release cr = iCheckIn_releaseDao.findOne(2);
        if(cr!=null){  System.out.println(cr.getTitle());}
    }

    @Test
    public void findCheckInByTeacher() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iCheckIn_releaseDao = (ICheckIn_ReleaseDao) ac.getBean("ICheckIn_ReleaseDao");
        List<CheckIn_Release> checkList = iCheckIn_releaseDao.findCheckInByTeacher(2);
        for (CheckIn_Release re : checkList
        ) {
            System.out.println(re.getTitle());
        }
    }
}
