package SSM.Service;

import SSM.Domain.OptionCount;
import SSM.Domain.Vote_Student;
import SSM.Utils.BadException;


import java.util.List;

public interface Vote_StudentService {
    List<Vote_Student> findAll();
    List<Vote_Student> findOneVoteResult(int VID);
    void updateVoteOption(Vote_Student vote_student);
    void createVoteOption(Vote_Student vote_student);
    void deleteVote(int VID,String SName);
    String createVoteOptions(List<Vote_Student> list) throws BadException;
    List<OptionCount> getOptionCounts(Integer vid);
}
