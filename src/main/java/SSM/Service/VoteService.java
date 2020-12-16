package SSM.Service;

import SSM.Domain.Vote;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface VoteService {
    List<Vote> findAll();
    Vote findOne(int VID);
    void updateVote(Vote vote);
    void createVote(Vote vote);
    void deleteVote(int VID);
    List<Vote> findVoteByTID(int tID);
}

