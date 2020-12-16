package Dao;

import SSM.Dao.IVoteDao;
import SSM.Domain.Vote;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
/*
*   private int VID;
    private int TID;
    private String Theme;
    private Date ReleaseTime;*/
public class IVoteDaoTest {
    private IVoteDao iVoteDao;

    @Test
    public void createVote(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iVoteDao = (IVoteDao) ac.getBean("IVoteDao");
        Vote vote = new Vote();
        vote.setTID(3);
        vote.setTheme("1111111");
        vote.setReleaseTime(new Date());
        iVoteDao.createVote(vote);
    }

    @Test
    public void findOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iVoteDao = (IVoteDao) ac.getBean("IVoteDao");
        Vote vote = iVoteDao.findOne(1);
        if(vote !=null){
            System.out.println(vote.getTheme());
        }
    }

    @Test
    public void findAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iVoteDao = (IVoteDao) ac.getBean("IVoteDao");
        List<Vote> voteList = iVoteDao.findAll();
        for (Vote e:voteList
        ) {
            System.out.println(e.getTheme());
        }
    }

    @Test
    public void updateVote(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iVoteDao = (IVoteDao) ac.getBean("IVoteDao");

        Vote vote = new Vote();
        vote.setVID(1);
        vote.setTID(3);
        vote.setTheme("13123");
        vote.setReleaseTime(new Date());
        iVoteDao.updateVote(vote);
    }

    @Test
    public void findVOteByTID(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iVoteDao = (IVoteDao) ac.getBean("IVoteDao");
        List<Vote> voteList = iVoteDao.findVoteByTID(3);
        for (Vote e:voteList
        ) {
            System.out.println(e.getTheme());
        }
    }
    @Test
    public void deleteVote(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iVoteDao = (IVoteDao) ac.getBean("IVoteDao");
        iVoteDao.deleteVote(1);
    }
}
