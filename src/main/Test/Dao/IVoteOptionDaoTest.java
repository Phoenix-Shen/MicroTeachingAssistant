package Dao;
import SSM.Dao.IVoteOptionDao;
import SSM.Domain.VoteOption;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class IVoteOptionDaoTest {
    private IVoteOptionDao iVoteOptionDao;
    @Test
    public void createVoteOption(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iVoteOptionDao = (IVoteOptionDao) ac.getBean("IVoteOptionDao");

        VoteOption voteoption=new VoteOption();
        voteoption.setVID(5);
        voteoption.setChoice("114514");

        iVoteOptionDao.createVoteOption(voteoption);
    }

    @Test
    public void findVoteOptions(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iVoteOptionDao = (IVoteOptionDao) ac.getBean("IVoteOptionDao");

        List<VoteOption> voteOptions = iVoteOptionDao.findOneVoteOptions(2);
        for (VoteOption op:voteOptions
             ) {
            System.out.printf(op.getChoice());
        }
    }

    @Test
    public void findAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iVoteOptionDao = (IVoteOptionDao) ac.getBean("IVoteOptionDao");

        List<VoteOption> voteOptions = iVoteOptionDao.findAll();
        for (VoteOption op:voteOptions
        ) {
            System.out.printf(op.getChoice());
        }
    }

    @Test
    public void updateOptions(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iVoteOptionDao = (IVoteOptionDao) ac.getBean("IVoteOptionDao");

        VoteOption voteoption=new VoteOption();
        voteoption.setVID(2);
        voteoption.setChoice("114514");

        iVoteOptionDao.updateVoteOption(voteoption,"777");
    }

    @Test
    public void deleteVoteOption(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SqlMappingConfig.xml");
        iVoteOptionDao = (IVoteOptionDao) ac.getBean("IVoteOptionDao");
        iVoteOptionDao.deleteVote(2,"114514");
    }
}
