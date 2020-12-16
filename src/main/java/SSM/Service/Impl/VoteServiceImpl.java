package SSM.Service.Impl;

import SSM.Dao.IVoteDao;
import SSM.Domain.Vote;
import SSM.Service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("voteService")
public class VoteServiceImpl implements VoteService {

    private final IVoteDao ivoteDao;

    @Autowired
    public VoteServiceImpl(IVoteDao ivoteDao) {
        this.ivoteDao = ivoteDao;
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
}
