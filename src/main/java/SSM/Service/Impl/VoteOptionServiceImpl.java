package SSM.Service.Impl;

import SSM.Dao.IVoteOptionDao;
import SSM.Domain.VoteOption;
import SSM.Service.VoteOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("voteOptionService")
public class VoteOptionServiceImpl implements VoteOptionService {
    private IVoteOptionDao ivOptionDao;

    @Autowired
    public VoteOptionServiceImpl(IVoteOptionDao ivOptionDao) {
        this.ivOptionDao = ivOptionDao;
    }

    @Override
    public List<VoteOption> findAll() {
        return ivOptionDao.findAll();
    }

    @Override
    public List<VoteOption> findOneVoteOptions(int VID) {
        return ivOptionDao.findOneVoteOptions(VID);
    }

    @Override
    public void updateVoteOption(VoteOption voteOption, String choice_new) {
        ivOptionDao.updateVoteOption(voteOption,choice_new);
    }

    @Override
    public void createVoteOption(VoteOption voteoption) {
        ivOptionDao.createVoteOption(voteoption);
    }

    @Override
    public void deleteVote(int VID, String choice) {
        ivOptionDao.deleteVote(VID,choice);
    }
}
