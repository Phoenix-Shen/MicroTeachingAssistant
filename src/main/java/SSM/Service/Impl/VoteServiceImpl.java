package SSM.Service.Impl;

import SSM.Dao.IVoteDao;
import SSM.Dao.IVoteOptionDao;
import SSM.Domain.Vote;
import SSM.Domain.VoteOption;
import SSM.Service.VoteService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service("voteService")
public class VoteServiceImpl implements VoteService {

    private final IVoteDao ivoteDao;
    private final IVoteOptionDao ivOptionDao;
    @Autowired
    public VoteServiceImpl(IVoteDao ivoteDao,IVoteOptionDao ivOptionDao) {
        this.ivoteDao = ivoteDao;
        this.ivOptionDao = ivOptionDao;
    }

    @Override
    public List<Vote> findAll() {
        return ivoteDao.findAll();
    }

    @Override
    public Vote findOne(int VID) {
        return ivoteDao.findOne(VID);
    }

    @Override
    public void updateVote(Vote vote) {
        ivoteDao.updateVote(vote);
    }

    @Override
    public void createVote(Vote vote) {
        ivoteDao.createVote(vote);
    }

    @Override
    public void deleteVote(int VID) {
        ivoteDao.deleteVote(VID);
    }

    @Override
    public List<Vote> findVoteByTID(int tID) {
        return ivoteDao.findVoteByTID(tID);
    }

    @Override
    public String createVoteWithOptions(Map<String,Object> map){
        System.out.println(map.get("vote"));
        System.out.println(map.get("options"));
        Object o =map.get("vote");
        Object o2=map.get("options");
        ObjectMapper mapper =new ObjectMapper();
        Vote vote =mapper.convertValue(o,Vote.class);

        List<VoteOption>options =mapper.convertValue(o2,new TypeReference<List<VoteOption>>(){});
        ivoteDao.createVote(vote);
        List<Vote>exists =ivoteDao.findAll();
        exists.sort(Comparator.comparingInt(Vote::getVID));
        int VID_PUSH =exists.get(exists.size()-1).getVID();
        for (VoteOption option:options
        ) {
            option.setVID(VID_PUSH);
            ivOptionDao.createVoteOption(option);
        }
        return String.valueOf(VID_PUSH);
    }
}
