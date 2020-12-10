package SSM.Service;

import SSM.Domain.Vote_Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Vote_StudentService {
    List<Vote_Student> findAll();
    List<Vote_Student> findOneVoteResult(int VID);
    void updateVoteOption(Vote_Student vote_student);
    void createVoteOption(Vote_Student vote_student);
    void deleteVote(int VID,int SID);
}
