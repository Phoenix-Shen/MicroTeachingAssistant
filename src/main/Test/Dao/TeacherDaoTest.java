package Dao;

import SSM.Dao.ITeacherDao;
import SSM.Domain.Teacher;

import org.junit.jupiter.api.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


public class TeacherDaoTest {
    private ITeacherDao iTeacherDao;
    /*@Before
    public void init(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:SqlMappingConfig.xml");
        ITeacherDao iTeacherDao = (ITeacherDao)ac.getBean("ITeacherDao");
        System.out.println("_______________________________");
    }*/
    @Test
    public void createTeacher() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:SqlMappingConfig.xml");
        ITeacherDao iTeacherDao = (ITeacherDao)ac.getBean("ITeacherDao");
        Teacher teacher = new Teacher();
        teacher.setID(1);
        System.out.println(LocalDateTime.now().toString());
        teacher.setName(LocalDateTime.now().toString().substring(10,19));
        teacher.setEmail("165@163.com");
        teacher.setPassword("大大展玮");
        iTeacherDao.createTeacher(teacher);
    }

    @Test
    public void updateTeacher() throws SQLException{
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:SqlMappingConfig.xml");
        ITeacherDao iTeacherDao = (ITeacherDao)ac.getBean("ITeacherDao");
        Teacher teacher = new Teacher();
        teacher.setID(1);
        teacher.setName("小小袁脑");
        teacher.setEmail("165@163.com");
        teacher.setPassword("大大肥嘴");
        iTeacherDao.updateTeacher(teacher);
    }

    @Test
    public void deleteTeacher() throws SQLException{
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:SqlMappingConfig.xml");
        ITeacherDao iTeacherDao = (ITeacherDao)ac.getBean("ITeacherDao");
        iTeacherDao.deleteTeacher(1);
    }

    @Test
    public void findAllTeacher() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:SqlMappingConfig.xml");
        ITeacherDao iTeacherDao = (ITeacherDao)ac.getBean("ITeacherDao");
        List<Teacher> teachers;
        teachers=iTeacherDao.findAll();
        for (Teacher teacher:teachers
             ) {
            System.out.println(teacher.getName());
        }
    }

    @Test
    public void findOne() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:SqlMappingConfig.xml");
        ITeacherDao iTeacherDao = (ITeacherDao)ac.getBean("ITeacherDao");
        Teacher teacher = iTeacherDao.findOne(3);
        System.out.println(teacher.getName());
    }
}
