package Dao;
import SSM.Dao.IVote_StudentDao;
import SSM.Domain.Vote_Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
public class IVote_StudentDaoTest {

    private IVote_StudentDao iv_StudentDao;
    @Test
    public void createVoteOption(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iv_StudentDao = (IVote_StudentDao) ac.getBean("IVote_StudentDao");

        Vote_Student vs = new Vote_Student();
        vs.setVID(3);
        vs.setSID(12222223);
        vs.setChoice("777");

        iv_StudentDao.createVoteOption(vs);
    }

    @Test
    public void findVoteOptions(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iv_StudentDao = (IVote_StudentDao) ac.getBean("IVote_StudentDao");


        List<Vote_Student> votestu = iv_StudentDao.findOneVoteResult(2);
        for (Vote_Student vs :votestu
        ) {
            System.out.printf(String.valueOf(vs.getSID()));
        }
    }

    @Test
    public void findAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iv_StudentDao = (IVote_StudentDao) ac.getBean("IVote_StudentDao");

        List<Vote_Student> votestu = iv_StudentDao.findAll();
        for (Vote_Student vs :votestu
        ) {
            System.out.printf(String.valueOf(vs.getSID()));
        }
    }

    @Test
    public void updateOptions(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iv_StudentDao = (IVote_StudentDao) ac.getBean("IVote_StudentDao");

        Vote_Student vs = new Vote_Student();
        vs.setVID(2);
        vs.setSID(12222222);
        vs.setChoice("777");

        iv_StudentDao.updateVoteOption(vs);
    }

    @Test
    public void deleteVoteOption(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iv_StudentDao = (IVote_StudentDao) ac.getBean("IVote_StudentDao");

        iv_StudentDao.deleteVote(2,12222222);
    }
}
