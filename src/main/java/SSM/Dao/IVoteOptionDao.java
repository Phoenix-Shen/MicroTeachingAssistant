package SSM.Dao;
import SSM.Domain.VoteOption;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
*   private int VID;
    private String option;*/
@Repository
public interface IVoteOptionDao {
    @Select("select * from voteoption")
    List<VoteOption> findAll();
    @Select("select * from voteoption where VID=#{VID}")
    List<VoteOption> findOneVoteOptions(@Param("VID")int VID);
    @Update("update voteoption set choice=#{choice_new} where VID=#{voteoption.VID} and choice=#{voteoption.choice}")
    void updateVoteOption(@Param("voteoption") VoteOption voteOption,@Param("choice_new")String choice_new);
    @Insert("insert into voteoption (VID,choice) values(#{VID},#{choice})")
    void createVoteOption(VoteOption voteoption);
    @Delete("delete from voteoption where VID=#{VID} and choice=#{choice}")
    void deleteVote(@Param("VID")int VID,@Param("choice")String choice);
}
