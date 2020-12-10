package SSM.Service.Impl;

import SSM.Dao.IVote_StudentDao;
import SSM.Domain.Vote_Student;
import SSM.Service.Vote_StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("vote_StudentService")
public class Vote_StudentServiceImpl implements Vote_StudentService {
    private IVote_StudentDao iv_StudentDao;

    @Autowired
    public Vote_StudentServiceImpl(IVote_StudentDao iv_StudentDao){
        this.iv_StudentDao=iv_StudentDao;
    }

    @Override
    public List<Vote_Student> findAll() {
        return iv_StudentDao.findAll();
    }

    @Override
    public List<Vote_Student> findOneVoteResult(int VID) {
        return iv_StudentDao.findOneVoteResult(VID);
    }

    @Override
    public void updateVoteOption(Vote_Student vote_student) {
        iv_StudentDao.updateVoteOption(vote_student);
    }

    @Override
    public void createVoteOption(Vote_Student vote_student) {
        iv_StudentDao.createVoteOption(vote_student);
    }

    @Override
    public void deleteVote(int VID, int SID) {
        iv_StudentDao.deleteVote(VID,SID);
    }
}
