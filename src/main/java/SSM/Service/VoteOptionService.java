package SSM.Service;


import SSM.Domain.VoteOption;


import java.util.List;

public interface VoteOptionService {

    List<VoteOption> findAll();
    List<VoteOption> findOneVoteOptions(int VID);
    void updateVoteOption(VoteOption voteOption,String choice_new);
    void createVoteOption(VoteOption voteoption);
    void deleteVote(int VID,String choice);
}
